package groop.persistance.logic.implementation;

import groop.persistance.entities.eUser;
import groop.persistance.logic.IUserAccess;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class UserAccess implements IUserAccess {

	@PersistenceContext(name="groop_db")
    EntityManager entityManager;
	
	public boolean userExists(String uname) {
		int res = entityManager.createNativeQuery("SELECT uname FROM user WHERE uname LIKE '"+uname+"'").getResultList().size();
		if(res > 0) return true;
		else return false;
	}
	
	@Override
	public boolean validateUser(eUser u) {
		u.getUname();
		return true;
	}

	@Override
	public boolean userExists(int uid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createUser(eUser u) throws java.lang.Exception {
		if(validateUser(u)) entityManager.persist(u);
		else throw new java.lang.Exception("My exception");
	}
	
	@Override
	public eUser getUser(String uname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public eUser getUser(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<eUser> getUsers() {
		Query q = entityManager.createQuery("SELECT * FROM user", eUser.class);
		return q.getResultList();
	}

	@Override
	public List<eUser> getNearbyUsers(String sourceUname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<eUser> getNearbyUsers(int sourceUid) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
