package dao;

import java.sql.ResultSet;
import java.util.List;

import model.Client;

public interface ClientDAO {

	public void save(Client c);

	public void delete(int id);

	public Client findById(int id);

	public List<Client> findAll();

}
