package groop.persistance.jpa.compositeEntities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the friends_with database table.
 * 
 */
@Embeddable
public class FriendsWithPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="user_ref", unique=true, nullable=false)
	private int userRef;

	@Column(name="friend_ref", unique=true, nullable=false)
	private int friendRef;

	public FriendsWithPK() {
	}
	public int getUserRef() {
		return this.userRef;
	}
	public void setUserRef(int userRef) {
		this.userRef = userRef;
	}
	public int getFriendRef() {
		return this.friendRef;
	}
	public void setFriendRef(int friendRef) {
		this.friendRef = friendRef;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FriendsWithPK)) {
			return false;
		}
		FriendsWithPK castOther = (FriendsWithPK)other;
		return 
			(this.userRef == castOther.userRef)
			&& (this.friendRef == castOther.friendRef);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userRef;
		hash = hash * prime + this.friendRef;
		
		return hash;
	}
}