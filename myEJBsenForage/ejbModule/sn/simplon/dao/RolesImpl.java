package sn.simplon.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import sn.simplon.entities.Roles;
import sn.simplon.entities.User;


@Stateless
public class RolesImpl implements IRoles {
	
	//Cette ligne nous permet de selectionner notre UP qu'on a creer dans le fichier persistance.xml
	@PersistenceContext(name = "myEJBsenForagePU")
	private EntityManager em;

	 public RolesImpl(){
		
	  }
	@Override
	public int add(Roles roles) {
	try {
		
		//em.getTransaction().begin();
		em.persist(roles);
		em.flush();
		//em.getTransaction().commit();
		
		return 1;
	} catch (Exception e) {
		e.printStackTrace();
		return 0;
	}
		
	}

	@Override
	public int update(Roles roles) {
		try {
			
			//em.getTransaction().begin();
			em.merge(roles);
			em.flush();
			//em.getTransaction().commit();
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public int delete(int id) {
		try {
			
			//em.getTransaction().begin();
			em.remove(em.find(Roles.class,id));
			em.flush();
			//em.getTransaction().commit();
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public Roles get(int id) {
		
		return (Roles)em.createQuery("SELECT r FROM Roles r WHERE r.id=:idR")
				     .setParameter("idR",id)
				     .getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Roles> getAll() {
		
		return (List<Roles>)em.createQuery("SELECT r FROM Roles r").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUserRoles(int id) {
		// TODO Auto-generated method stub
		return (List<User>)em.createQuery("SELECT r.users FROM Roles r WHERE r.id=:idR")
				 .setParameter("idR",id)
			     .getSingleResult();
	}

}
