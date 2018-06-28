package service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ClientRepository;
import model.Client;

public class ClientServiceImpl implements ClientService {

	@Autowired
	//private ClientDAO dao;
	ClientRepository dao;

	/**
	 * Méthode permettant d'ajouter un client en BDD
	 * 
	 */
	@Override
	public void updateClient(Client c) {
		if (c.getName().length() < 5) {
			System.out.println("Le nom doit comporter 5 caractères au minimum");
		} else if (c.getName() == null) {
			System.out.println("Merci de saisir un nom");
		} else {
			if (c.getId() != null) {
				Client cc = this.getValidatedClient(c.getId());
				cc.setName(c.getName());
				dao.save(cc);
			}
		}
	}

	@Override
	public Client getValidatedClient(int id) {
		Client result = new Client();
		Optional<Client> c = dao.findById(id);
		
		if(c.isPresent()) result =c.get();
		
		return result;
		
	}

	@Override
	public List<Client> getAllClient() {
		return dao.findAll();
	}

	@Override
	public void deleteClient(int id) {
		Client c = new Client();
		c.setId(id);
		dao.delete(c);
	}


	
	@Override
	public void creeClient(String name){
		Client c = new Client(name);
		dao.save(c);
		
	}
	
}
