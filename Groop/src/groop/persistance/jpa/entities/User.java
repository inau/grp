package groop.persistance.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQueries({
	@NamedQuery(name="User.findAll", query="SELECT u FROM User u"),
	@NamedQuery(name="User.findByName", query="SELECT u FROM User u WHERE u.uname = :uname")
})

public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private int id;

	private int age;

	@Column(length=45)
	private String firstname;

	@Column(nullable=false, length=255)
	private String hashedPassword;

	@Column(length=45)
	private String lastname;

	@Column(nullable=false, length=45)
	private String uname;

	//bi-directional many-to-one association to Conversation
	@OneToMany(mappedBy="user")
	private List<Conversation> conversations1;

	//bi-directional one-to-one association to Geolocation
	@OneToOne(mappedBy="user")
	private Geolocation geolocation;

	//bi-directional many-to-one association to Message
	@OneToMany(mappedBy="user")
	private List<Message> messages;

	//uni-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="role_ref", insertable=false, updatable=false, nullable=false)
	private Role role;

	//bi-directional many-to-one association to SessionToken
	@ManyToOne
	@JoinColumn(name="session_token")
	private SessionToken sessionTokenBean;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getHashedPassword() {
		return this.hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getUname() {
		return this.uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public List<Conversation> getConversations1() {
		return this.conversations1;
	}

	public void setConversations1(List<Conversation> conversations1) {
		this.conversations1 = conversations1;
	}

	public Conversation addConversations1(Conversation conversations1) {
		getConversations1().add(conversations1);
		conversations1.setUser(this);

		return conversations1;
	}

	public Conversation removeConversations1(Conversation conversations1) {
		getConversations1().remove(conversations1);
		conversations1.setUser(null);

		return conversations1;
	}

	public Geolocation getGeolocation() {
		return this.geolocation;
	}

	public void setGeolocation(Geolocation geolocation) {
		this.geolocation = geolocation;
	}

	public List<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Message addMessage(Message message) {
		getMessages().add(message);
		message.setUser(this);

		return message;
	}

	public Message removeMessage(Message message) {
		getMessages().remove(message);
		message.setUser(null);

		return message;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public SessionToken getSessionTokenBean() {
		return this.sessionTokenBean;
	}

	public void setSessionTokenBean(SessionToken sessionTokenBean) {
		this.sessionTokenBean = sessionTokenBean;
	}

}