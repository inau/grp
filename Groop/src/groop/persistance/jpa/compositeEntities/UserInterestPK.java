package groop.persistance.jpa.compositeEntities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the userInterests database table.
 * 
 */
@Embeddable
public class UserInterestPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="user_ref", unique=true, nullable=false)
	private int userRef;

	@Column(name="interest_ref", unique=true, nullable=false)
	private int interestRef;

	public UserInterestPK() {
	}
	public int getUserRef() {
		return this.userRef;
	}
	public void setUserRef(int userRef) {
		this.userRef = userRef;
	}
	public int getInterestRef() {
		return this.interestRef;
	}
	public void setInterestRef(int interestRef) {
		this.interestRef = interestRef;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof UserInterestPK)) {
			return false;
		}
		UserInterestPK castOther = (UserInterestPK)other;
		return 
			(this.userRef == castOther.userRef)
			&& (this.interestRef == castOther.interestRef);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.userRef;
		hash = hash * prime + this.interestRef;
		
		return hash;
	}
}