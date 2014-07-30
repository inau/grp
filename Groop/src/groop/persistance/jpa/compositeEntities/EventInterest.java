package groop.persistance.jpa.compositeEntities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the eventInterests database table.
 * 
 */
@Entity
@Table(name="eventInterests")
@NamedQuery(name="EventInterest.findAll", query="SELECT e FROM EventInterest e")
public class EventInterest implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private EventInterestPK id;

	public EventInterest() {
	}

	public EventInterestPK getId() {
		return this.id;
	}

	public void setId(EventInterestPK id) {
		this.id = id;
	}

}