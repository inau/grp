package groop.service.user;


import groop.persistance.jpa.entities.Role;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Stateless
@Path("")
public class RoleService {
	
	@PersistenceContext(name="Groop_db")
    EntityManager entityManager;
    
	@Context
    private UriInfo uriInfo;
	
    @Context
    Request request;
	
    /**
     * Default constructor. 
     */
    public RoleService() {
    }

    @GET
    @Path("/roles/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Role> getRolesJson() {
    	Query q = entityManager.createNamedQuery("Role.findAll", Role.class);
        return q.getResultList();
    }
    
    @GET
    @Path("/role/")
    @Consumes(MediaType.TEXT_HTML)
    @Produces({MediaType.TEXT_HTML})
    public String getRoleEmptyUri() {
    	return "<h1>Role service</h1> requires a role_id in the uri";
    }
    
    @POST
    @Path("/role/{rid}")
    @Consumes(MediaType.TEXT_HTML)
    @Produces({MediaType.APPLICATION_JSON})
    public Role getRoleJson(@PathParam("rid")int rid) {
    	return entityManager.find(Role.class, rid);
    }
    
}