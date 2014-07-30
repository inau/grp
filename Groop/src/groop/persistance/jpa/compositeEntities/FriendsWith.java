package groop.persistance.jpa.compositeEntities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the friends_with database table.
 * 
 */
@Entity
@Table(name="friends_with")
@NamedQuery(name="FriendsWith.findAll", query="SELECT f FROM FriendsWith f")
public class FriendsWith implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private FriendsWithPK id;

	public FriendsWith() {
	}

	public FriendsWithPK getId() {
		return this.id;
	}

	public void setId(FriendsWithPK id) {
		this.id = id;
	}

}