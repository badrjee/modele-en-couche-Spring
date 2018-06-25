package presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import model.Client;
import service.ClientService;
import service.ClientServiceImpl;

public class Vue {

	//impl�mentation de Client Service
	
	@Autowired
	private ClientServiceImpl service;
	
	public void showClient(int id) {

		System.out.println(service.getValidatedClient(id));
	}

	public void createClient(String name) {
		Client c = new Client();
		c.setName(name);
		service.saveClient(c);
	}

	public void showAllClients() {
		
		List <Client> list = service.getAllClient(); 

		for(Client cl : list ) {
			System.out.println(cl);
		};

	}

}
