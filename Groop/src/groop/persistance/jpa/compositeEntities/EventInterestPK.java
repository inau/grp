package groop.persistance.jpa.compositeEntities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the eventInterests database table.
 * 
 */
@Embeddable
public class EventInterestPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="event_ref", unique=true, nullable=false)
	private int eventRef;

	@Column(name="einterest_ref", unique=true, nullable=false)
	private int einterestRef;

	public EventInterestPK() {
	}
	public int getEventRef() {
		return this.eventRef;
	}
	public void setEventRef(int eventRef) {
		this.eventRef = eventRef;
	}
	public int getEinterestRef() {
		return this.einterestRef;
	}
	public void setEinterestRef(int einterestRef) {
		this.einterestRef = einterestRef;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof EventInterestPK)) {
			return false;
		}
		EventInterestPK castOther = (EventInterestPK)other;
		return 
			(this.eventRef == castOther.eventRef)
			&& (this.einterestRef == castOther.einterestRef);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.eventRef;
		hash = hash * prime + this.einterestRef;
		
		return hash;
	}
}