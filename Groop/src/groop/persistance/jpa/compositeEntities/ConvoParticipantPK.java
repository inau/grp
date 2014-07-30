package groop.persistance.jpa.compositeEntities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the convo_participants database table.
 * 
 */
@Embeddable
public class ConvoParticipantPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="convo_id", unique=true, nullable=false)
	private int convoId;

	@Column(name="participant_ref", unique=true, nullable=false)
	private int participantRef;

	public ConvoParticipantPK() {
	}
	public int getConvoId() {
		return this.convoId;
	}
	public void setConvoId(int convoId) {
		this.convoId = convoId;
	}
	public int getParticipantRef() {
		return this.participantRef;
	}
	public void setParticipantRef(int participantRef) {
		this.participantRef = participantRef;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConvoParticipantPK)) {
			return false;
		}
		ConvoParticipantPK castOther = (ConvoParticipantPK)other;
		return 
			(this.convoId == castOther.convoId)
			&& (this.participantRef == castOther.participantRef);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.convoId;
		hash = hash * prime + this.participantRef;
		
		return hash;
	}
}