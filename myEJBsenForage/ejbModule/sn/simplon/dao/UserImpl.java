package sn.simplon.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import sn.simplon.entities.User;


@Stateless
public class UserImpl implements IUser{
	//Cette ligne nous permet de selectionner notre UP qu'on a creer dans le fichier persistance.xml
	@PersistenceContext(unitName = "myEJBsenForagePU")
	private EntityManager em;
	public UserImpl()
	{
		
	}

	@Override
	public int add(User u) {
		 try {
	            
			 	//em.getTransaction().begin();
	            em.persist(u);
	            em.flush();
	          //  em.getTransaction().commit();
	            
	            return 1;
	        }catch (Exception ex){
	            ex.printStackTrace();
	            return 0;
	        }
	}
	
	@Override
	public User getConnection(String email, String password) {
		try {
			User user =new User();
			user = (User) em.createQuery("SELECT u FROM User u WHERE u.email=:em AND u.password=:pwd")
					       .setParameter("em", email)
			               .setParameter("pwd", password)
			                .getSingleResult();
			return user;
		} catch (Exception e) {
			
			return null;
		}
		
	}

	@Override
	public int update(User user) {
		try {
			
			em.merge(user);
			em.flush();
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		try {
			
			em.remove(em.find(User.class,id));
			em.flush();
			
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public User get(int id) {
		return (User)em.createQuery("SELECT u FROM User u WHERE u.id=:idU")
			     .setParameter("idU",id)
			     .getSingleResult();
	}

	@Override
	
	public List<User> getAll() {
		return (List<User>) em.createQuery("SELECT u FROM User u").getResultList();

	}

}
