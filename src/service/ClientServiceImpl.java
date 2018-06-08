package service;

import java.sql.ResultSet;
import java.util.List;

import dao.ClientDAO;
import dao.SQLClientDAO;
import model.Client;

public class ClientServiceImpl implements ClientService {

	private ClientDAO dao = new SQLClientDAO();

	/**
	 * Méthode permettant d'ajouter un client en BDD
	 * 
	 */
	@Override
	public void addClient(Client c) {
		// TODO Auto-generated method stub
		if (c.getName().length()<5) {
			System.out.println("Le nom doit comporter 5 caractères au minimum");
		}else if(c.getName()==null) {
			System.out.println("Merci de saisir un nom");
		}else {
			dao.save(c);
		}
	}

	@Override
	public Client getValidatedClient(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Client> getAllClient() {
		return dao.findAll();
	}

	@Override
	public void deleteClient(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);

	}
}
