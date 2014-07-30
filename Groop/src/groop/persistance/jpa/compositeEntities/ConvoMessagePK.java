package groop.persistance.jpa.compositeEntities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the convo_messages database table.
 * 
 */
@Embeddable
public class ConvoMessagePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="convo_ref", unique=true, nullable=false)
	private int convoRef;

	@Column(name="msg_ref", unique=true, nullable=false)
	private int msgRef;

	public ConvoMessagePK() {
	}
	public int getConvoRef() {
		return this.convoRef;
	}
	public void setConvoRef(int convoRef) {
		this.convoRef = convoRef;
	}
	public int getMsgRef() {
		return this.msgRef;
	}
	public void setMsgRef(int msgRef) {
		this.msgRef = msgRef;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ConvoMessagePK)) {
			return false;
		}
		ConvoMessagePK castOther = (ConvoMessagePK)other;
		return 
			(this.convoRef == castOther.convoRef)
			&& (this.msgRef == castOther.msgRef);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.convoRef;
		hash = hash * prime + this.msgRef;
		
		return hash;
	}
}