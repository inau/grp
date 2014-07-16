package groop.persistance.logic;

import groop.persistance.entities.eUser;

import java.util.List;

public interface IUserAccess {

	public boolean userExists(String uname);
	public boolean userExists(int uid);
	
	public void createUser(eUser u) throws Exception;
	
	public eUser getUser(String uname);
	public eUser getUser(int uid);
	
	public List<eUser> getUsers();
	
	public List<eUser> getNearbyUsers(String sourceUname);
	public List<eUser> getNearbyUsers(int sourceUid);
	
	public 
	
	//Ommit delete - not crucial atm
	
	boolean validateUser(eUser u);
}
