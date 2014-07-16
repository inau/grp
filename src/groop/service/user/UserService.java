package groop.service.user;


import groop.persistance.entities.eUser;
import groop.persistance.logic.implementation.UserAccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("users")
@Stateless
@Consumes("application/xml")
@Produces("application/xml")
public class UserService {
	
	UserAccess ua = new UserAccess();
	
	@Context
    private UriInfo uriInfo;

    /**
     * Default constructor. 
     */
    public UserService() {
    }
    
	@POST
    public String createUser(@QueryParam("uname") String uname, @QueryParam("psw") String psw) {    
    	if(ua.userExists(uname)) return "Username already taken";  
		
    	eUser user = new eUser();
    	user.setUname(uname);
    	user.setPassword(psw);
    	user.setRoleRef(0);
    	  
    	try {
			ua.createUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	  
        return "Hello "+uname+" with secret "+psw;
    }

	@GET
	public String getUsers() {
		List<eUser> l = ua.getUsers();
		if(l == null) return "Result list was empty";
		return "Users #"+l.size()+" - "+l.toString();
	}
    
	@GET
	@Path("{uname}")
	public String getUser(@PathParam("uname") String uname) {
		eUser u = ua.getUser(uname);
		return u.toString();
	}
	
	@GET
    @Path("role/{uname}")
	public String getUserRole(@PathParam("uname") String uname) {
		return "Hi "+uname+" with role AWSUMZ";
	}
    
    
}