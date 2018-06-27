package presentation;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import model.Client;
import service.ClientService;
import service.ClientServiceImpl;

/**
 * Servlet permettant gérer toutes les requêtes HTTP GET se terminant par
 * ".html" (c.f. web.xml). La page JSP demandée est retrouvée grâce à
 * l'identifiant placé entre le dernier '/' et '.html' (ex:
 * /mon-appli/ma-super-page.html).
 */
public class ViewsServlet extends AutowiredServlet {
	private static final Logger LOGGER = LoggerFactory.getLogger(ViewsServlet.class);
	private static final long serialVersionUID = 1L;

	@Autowired
	private ClientService service;

	// @Override
	// public void init() throws ServletException {
	// final WebApplicationContext ctx =
	// WebApplicationContextUtils.getWebApplicationContext(getServletContext());
	// ctx.getAutowireCapableBeanFactory().autowireBean(this);
	// } //cette méthode est utiliser pour intgrer Autowired sans passer par une
	// classe AutowiredServlet et dans ce cas "public class ViewsServlet extends
	// httpServlet"

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LOGGER.debug("Passage dans doGet avec servletPath={}", request.getServletPath());
		final String view = request.getServletPath().replace(".html", "").split("/")[1];
		LOGGER.debug("Nom de vue déterminé depuis servletPath -> {}", view);
		if (view != null && !view.isEmpty()) {
			String clientId = request.getParameter("clientId");
			switch (view) {
			case "show-all":
				request.setAttribute("clients", this.service.getAllClient());
				break;
			case "show-client":
				request.setAttribute("client", this.service.getValidatedClient(Integer.parseInt(clientId)));
				break;
			case "edit-client":
				request.setAttribute("client", this.service.getValidatedClient(Integer.parseInt(clientId)));
				break;
			case "delete-client":
				this.service.deleteClient(Integer.parseInt(clientId));
				request.setAttribute("clients", this.service.getAllClient());
				
				break;

			}
			this.forwardToJsp(request, response, view);
		} else {
			LOGGER.debug("Aucun nom de vue valide, génération de l'erreur HTTP 405.");
			// Utilisation de super pour déclencher un response.sendError(..),
			// voir le code soruce de HttpServlet.doGet(..).
			super.doGet(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String strId = request.getParameter("id");
		final String name = request.getParameter("name");
		
		if (strId !=null)
		this.service.saveClient(new Client(Integer.parseInt(strId), name));
		
		else this.service.creeClient(name);
		response.sendRedirect(request.getContextPath() + "/show-all.html");
		
		
		
	}

	private void forwardToJsp(HttpServletRequest request, HttpServletResponse response, String view)
			throws ServletException, IOException {
		LOGGER.debug("Forward vers la JSP correspondante.");
		final String jspPath = "/WEB-INF/views/" + view + ".jsp";
		this.getServletContext().getRequestDispatcher(jspPath).forward(request, response);
	}
}
