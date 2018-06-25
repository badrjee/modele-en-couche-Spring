package presentation;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;


import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class AutowiredServlet
 */
@WebServlet("/AutowiredServlet")

public class AutowiredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    protected AutowireCapableBeanFactory ctx;
    
    public void init() throws ServletException{
    	WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    	ctx = context.getAutowireCapableBeanFactory();
    	ctx.autowireBean(this);
	}

}
