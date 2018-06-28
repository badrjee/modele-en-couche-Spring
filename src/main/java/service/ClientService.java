package service;

import java.util.List;

import model.Client;

public interface ClientService {

	public void updateClient(Client c);

	public Client getValidatedClient(int id);

	public List<Client> getAllClient();

	public void deleteClient(int id);
	
	public void creeClient(String name);
	
	

}
