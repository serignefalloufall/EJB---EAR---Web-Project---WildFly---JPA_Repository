package sn.simplon.dao;

import java.util.List;

import javax.ejb.Local;

import sn.simplon.entities.Roles;
import sn.simplon.entities.User;


@Local
public interface IRoles {

	public int add(Roles roles);
	public int update(Roles roles);
	public int delete(int id);
	public Roles get( int id);
	public List<Roles> getAll();
	public List<User> getAllUserRoles(int id);
	
}
