	package aircompanySpring.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@NamedQueries({ @NamedQuery(name = "Flight.findAllFlights", query = "SELECT f FROM Flight AS f"),
	@NamedQuery(name = "Flight.findAllFlightsByRouteId", 
	query = "SELECT f FROM Flight AS f where f.route.id=:routeId"),
	@NamedQuery(name = "Flight.searchFlights", 
	query = "SELECT f FROM Flight AS f where "
			+ "lower(f.route.destinationFrom.country) like :searchString "
			+ "or lower(f.route.destinationFrom.city) like :searchString "
			+ "or lower(f.route.destinationFrom.airport) like :searchString "
			+ "or lower(f.route.destinationTo.country) like :searchString "
			+ "or lower(f.route.destinationTo.city) like :searchString "
			+ "or lower(f.route.destinationTo.airport) like :searchString "
			+ "or lower(f.plane.model) like :searchString "
			+ "or lower(f.name) like :searchString"),
			@NamedQuery(name = "Flight.findSameFlight", 
			query = "SELECT f FROM Flight AS f where "
					+ "f.route=:route "					
					+ "and ((DAY(DATE(f.departure)) - DAY(:departure)) > 1 "
							+ " and (DAY(DATE(f.arrival)) - DAY(:arrival)) > 1)")})
//+ "or f.name=:name "

@Entity
public class Flight {

	@Id @GeneratedValue
	private Long id;

	@Size(min = 4, max = 6)
	@Pattern(regexp = "[a-zA-Z0-9]+")
	@Column(name = "name", nullable = false, unique = true)
	private String name;	

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "routeId", nullable = false)	
	private Route route;	

	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "planeId", nullable = false)
	private Plane plane;	

	@NotNull
	@Future
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date arrival;

	@NotNull
	@Future	
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date departure;

	@OneToMany(mappedBy="flight", fetch = FetchType.LAZY,
			cascade = {CascadeType.REMOVE, CascadeType.MERGE,
			CascadeType.REFRESH})
	@OrderBy("id")
	private Set<Crew> appointments;	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Date getArrival() {
		return arrival;
	}

	public void setArrival(Date arrival) {
		this.arrival = arrival;
	}

	public Date getDeparture() {
		return departure;
	}

	public void setDeparture(Date departure) {
		this.departure = departure;
	}

	public Long getId() {
		return id;
	}

	public Set<Crew> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Crew> appointments) {
		this.appointments = appointments;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(name);
		builder.append(" (");
		builder.append(route);
		builder.append("). ");
		builder.append(plane);
		builder.append(" ");
		builder.append(arrival);
		builder.append("-");
		builder.append(departure);
		
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
