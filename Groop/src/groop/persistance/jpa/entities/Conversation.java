package groop.persistance.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the conversations database table.
 * 
 */
@Entity
@Table(name="conversations")
@NamedQuery(name="Conversation.findAll", query="SELECT c FROM Conversation c")
public class Conversation implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private User user;
	private List<Message> messages;
	private List<User> users;

	public Conversation() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="owner", insertable=false, updatable=false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}