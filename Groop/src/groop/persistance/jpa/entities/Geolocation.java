package groop.persistance.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the geolocations database table.
 * 
 */
@Entity
@Table(name="geolocations")
@NamedQuery(name="Geolocation.findAll", query="SELECT g FROM Geolocation g")
public class Geolocation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_update", nullable=false)
	private Date lastUpdate;

	@Column(nullable=false)
	private double latitude;

	@Column(name="loc_ref", nullable=false)
	private int locRef;

	@Column(nullable=false)
	private double longitude;

	//bi-directional one-to-one association to Location
	@OneToOne
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private Location location;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="id", nullable=false, insertable=false, updatable=false)
	private User user;

	public Geolocation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getLastUpdate() {
		return this.lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public double getLatitude() {
		return this.latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public int getLocRef() {
		return this.locRef;
	}

	public void setLocRef(int locRef) {
		this.locRef = locRef;
	}

	public double getLongitude() {
		return this.longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}