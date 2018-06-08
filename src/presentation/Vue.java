package presentation;

import java.util.List;

import model.Client;
import service.ClientService;
import service.ClientServiceImpl;

public class Vue {

	//implémentation de Client Service
	private ClientService service = new ClientServiceImpl();
	
	public void showClient(int id) {
		Client cl =service.getValidatedClient(id);
		System.out.println(cl);
	}

	public void createClient(String name) {
		Client c = new Client();
		c.setName(name);
		service.addClient(c);
	}

	public void showAllClients() {
		
		List <Client> list = service.getAllClient(); 

		for(Client cl : list ) {
			System.out.println(cl);
		};

	}

}
