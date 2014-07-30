package groop.persistance.jpa.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the locations database table.
 * 
 */
@Entity
@Table(name="locations")
@NamedQuery(name="Location.findAll", query="SELECT l FROM Location l")
public class Location implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="loc_id", unique=true, nullable=false)
	private int locId;

	//bi-directional one-to-one association to Geolocation
	@OneToOne(mappedBy="location")
	private Geolocation geolocation;

	//bi-directional many-to-one association to City
	@ManyToOne
	@JoinColumn(name="city_ref", nullable=false)
	private City city;

	//bi-directional many-to-one association to Country
	@ManyToOne
	@JoinColumn(name="country_ref", nullable=false)
	private Country country;

	public Location() {
	}

	public int getLocId() {
		return this.locId;
	}

	public void setLocId(int locId) {
		this.locId = locId;
	}

	public Geolocation getGeolocation() {
		return this.geolocation;
	}

	public void setGeolocation(Geolocation geolocation) {
		this.geolocation = geolocation;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

}