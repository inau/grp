package groop.persistance.jpa.compositeEntities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the convo_messages database table.
 * 
 */
@Entity
@Table(name="convo_messages")
@NamedQuery(name="ConvoMessage.findAll", query="SELECT c FROM ConvoMessage c")
public class ConvoMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ConvoMessagePK id;

	public ConvoMessage() {
	}

	public ConvoMessagePK getId() {
		return this.id;
	}

	public void setId(ConvoMessagePK id) {
		this.id = id;
	}

}