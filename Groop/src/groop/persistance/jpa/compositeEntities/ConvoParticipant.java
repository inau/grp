package groop.persistance.jpa.compositeEntities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the convo_participants database table.
 * 
 */
@Entity
@Table(name="convo_participants")
@NamedQuery(name="ConvoParticipant.findAll", query="SELECT c FROM ConvoParticipant c")
public class ConvoParticipant implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConvoParticipantPK id;

	public ConvoParticipant() {
	}

	public ConvoParticipantPK getId() {
		return this.id;
	}

	public void setId(ConvoParticipantPK id) {
		this.id = id;
	}

}