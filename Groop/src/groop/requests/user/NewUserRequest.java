package groop.requests.user;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;

@XmlRootElement
public class NewUserRequest implements Serializable {

	private static final long serialVersionUID = 1L;

    String uname;

    String firstname;
    
    String lastname;
    
    int age;
	
    String password;
	
    public NewUserRequest() {
    	this.uname = "x";
        this.password = "x";
    	this.firstname = "x";
        this.lastname = "x";
        this.age = 0;
    }

    public NewUserRequest(final String uname, final String password) {
        this();
    	this.uname = uname;
        this.password = password;
    	this.firstname = "";
        this.lastname = "";
        this.age = 0;
    }
    
    public NewUserRequest(final String uname, final String password, final String firstname, final String lastname, final int age) {
        this(uname, password);
    	this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
    }

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
