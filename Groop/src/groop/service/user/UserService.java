package groop.service.user;


import groop.persistance.jpa.entities.User;
import groop.requests.user.NewUserRequest;

import java.io.StringWriter;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@Path("user")
@Stateless
@Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_XML, MediaType.TEXT_PLAIN })
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML, MediaType.TEXT_XML, MediaType.TEXT_PLAIN })
public class UserService {
	
	@PersistenceContext
	EntityManager em;
	
	@Context
    private UriInfo uriInfo;

    /**
     * Default constructor. 
     */
    public UserService() {
    }
    
	@GET
	public String rootUsage() {
		return "<h1>User service:</h1>\n"
				+ "<br>Lookup user: add username or id to uri ie. /groop/rest/user/Ted OR /groop/rest/user/1 </br> \n"
				+ "<br>Create user: Issue POST with json representation to request body "
				+ "<br>Obtain template by appending template.json or template.xml to current uri</br> </br>\n ";
	}

	/**
	 * Get a json template for creating a new user request
	 * @return NewUserRequest
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("template.json")
	public NewUserRequest getNewUserRequestTemplateJson() {
		NewUserRequest nur = new NewUserRequest();
		return nur;
	}
	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("template.xml")
	public NewUserRequest getNewUserRequestTemplateXml() {
		NewUserRequest nur = new NewUserRequest();
		return nur;
	}
	
	/**
	 * Get user by path parameter uname
	 * @param uname
	 * @return User
	 */
	@GET
	@Path("name/{uname}")
	public User getUserByName(@PathParam("uname") String uname) {
		return (User)em.createNamedQuery("User.findByName", User.class).setParameter("uname", uname);
	}

	/**
	 * Get user by path parameter uid
	 * @param uname
	 * @return User
	 */
	@GET
	@Path("id/{uid}")
	public User getUserById(@PathParam("uid") int uid) {
		return em.find(User.class, uid);
	}
	
	@POST
	@Consumes(MediaType.TEXT_XML)
	public String createUserXml(NewUserRequest nur) {
	    	
	    	return "Create user was called with json";
	}
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String createUserJson(NewUserRequest nur) {
    	
    	return "Create user was called with json";
    }
    
}