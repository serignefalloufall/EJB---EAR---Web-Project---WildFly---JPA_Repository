package sn.simplon.dao;

import java.util.List;

import javax.ejb.Local;

import sn.simplon.entities.Village;


@Local
public interface IVillage {
	
	public int add(Village village);
	public int update(Village village);
	public int delete(int id);
	public Village get( int id);
	public List<Village> getAll();

}
