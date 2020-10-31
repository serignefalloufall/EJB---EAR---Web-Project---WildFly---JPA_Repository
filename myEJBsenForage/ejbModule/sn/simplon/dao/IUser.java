package sn.simplon.dao;

import java.util.List;

import javax.ejb.Local;

import sn.simplon.entities.User;


@Local
public interface IUser {

	public int add(User user);
	public int update(User user);
	public int delete(int id);
	public User get( int id);
	public List<User> getAll();
	public  User  getConnection(String email,String password); 
}
