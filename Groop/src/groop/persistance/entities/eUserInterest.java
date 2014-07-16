package groop.persistance.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the user_interest database table.
 * 
 */
@Entity
@Table(name="user_interest")
@NamedQuery(name="eUserInterest.findAll", query="SELECT e FROM eUserInterest e")
public class eUserInterest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="useri_id")
	private int useriId;

	@Column(name="interest_ref")
	private int interestRef;

	//bi-directional many-to-one association to eUser
	@ManyToOne
	@JoinColumn(name="user_ref")
	private eUser user;

	public eUserInterest() {
	}

	public int getUseriId() {
		return this.useriId;
	}

	public void setUseriId(int useriId) {
		this.useriId = useriId;
	}

	public int getInterestRef() {
		return this.interestRef;
	}

	public void setInterestRef(int interestRef) {
		this.interestRef = interestRef;
	}

	public eUser getUser() {
		return this.user;
	}

	public void setUser(eUser user) {
		this.user = user;
	}

}