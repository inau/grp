package groop.persistance.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sessionTokens database table.
 * 
 */
@Entity
@Table(name="sessionTokens")
@NamedQuery(name="SessionToken.findAll", query="SELECT s FROM SessionToken s")
public class SessionToken implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date expires;

	@Column(nullable=false, length=256)
	private String hash;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="sessionTokenBean")
	private List<User> users;

	public SessionToken() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getExpires() {
		return this.expires;
	}

	public void setExpires(Date expires) {
		this.expires = expires;
	}

	public String getHash() {
		return this.hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setSessionTokenBean(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setSessionTokenBean(null);

		return user;
	}

}