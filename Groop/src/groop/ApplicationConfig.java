package groop;

import groop.service.user.RoleService;
import groop.service.user.UserService;
import groop.service.user.UsersService;

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
	       
	        c.add(RoleService.class);
	        
	        c.add(UsersService.class);        
	        c.add(UserService.class);        
	        
	        classes = Collections.unmodifiableSet(c);
	    }
	 
	    @Override
	    public Set<Class<?>> getClasses() {
	        return classes;
	    }
}
