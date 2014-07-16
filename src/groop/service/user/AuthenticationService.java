package groop.service.user;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/auth/")
@Stateless
public class AuthenticationService {
	
	@PersistenceContext(name="Groop_db")
    EntityManager entityManager;
    
	@Context
    private UriInfo uriInfo;
	
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public AuthenticationService() {
    }

//    @POST
//    public Response requestToken(String uname, String psw) {        
//          //entityManager.createNamedQuery(uname);
//          //persist(book);
//          URI uri = uriInfo.getAbsolutePathBuilder().path("hfZxs12345FHGS").build();
//          return Response.created(uri).build();
//    }
    
    @POST
    @Consumes("application/json")
    public Response requestToken(@QueryParam("uname") String uname, @QueryParam("psw") String psw) {
    	  String token = "authenticated "+uname+" with secret "+psw;
    	  
          return Response.ok().entity(token).build();
    }
    
    
}