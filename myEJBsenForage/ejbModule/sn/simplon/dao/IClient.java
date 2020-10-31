package sn.simplon.dao;

import java.util.List;

import javax.ejb.Local;

import sn.simplon.entities.Client;

@Local
public interface IClient {
	
	public int add(Client client);
	public int update(Client client);
	public int delete(int id);
	public Client get( int id);
	public List<Client> getAll();

}
