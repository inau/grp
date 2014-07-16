package groop;

import groop.service.user.AuthenticationService;
import groop.service.user.UserService;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rest")
public class ApplicationConfig extends Application {
	 
	    private final Set<Class<?>> classes;
	
	    public ApplicationConfig() {
	        HashSet<Class<?>> c = new HashSet<>();
	       
	        c.add(AuthenticationService.class);        
	        c.add(UserService.class);        
	        
	        classes = Collections.unmodifiableSet(c);
	    }
	 
	    @Override
	    public Set<Class<?>> getClasses() {
	        return classes;
	    }
}