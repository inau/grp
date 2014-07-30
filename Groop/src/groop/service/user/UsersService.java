package groop.service.user;


import groop.persistance.jpa.entities.User;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("users")
@Stateless
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_XML, MediaType.TEXT_PLAIN })
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_XML, MediaType.TEXT_PLAIN })
public class UsersService {
	
	@PersistenceContext
	EntityManager em;
	
	@Context
    private UriInfo uriInfo;

    /**
     * Default constructor. 
     */
    public UsersService() {
    }
    
	@GET
	public List<User> getAllUsers() {
		try {
			List l = em.createNamedQuery("User.findAll", User.class).getResultList();
			return l;
		}
		catch(Exception e) {
			return null;
		}

	}
	
	//Find nearby location

}