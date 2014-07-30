package groop.persistance.jpa.compositeEntities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userInterests database table.
 * 
 */
@Entity
@Table(name="userInterests")
@NamedQuery(name="UserInterest.findAll", query="SELECT u FROM UserInterest u")
public class UserInterest implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserInterestPK id;

	public UserInterest() {
	}

	public UserInterestPK getId() {
		return this.id;
	}

	public void setId(UserInterestPK id) {
		this.id = id;
	}

}