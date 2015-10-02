package aircompanySpring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@NamedQueries({ @NamedQuery(name = "Crew.findAllCrews", query = "SELECT c FROM Crew AS c"),
				@NamedQuery(name = "Crew.findAllCrewsByRoute", 
							query = "SELECT c FROM Crew AS c WHERE c.flight.route.id=:routeId"),
				@NamedQuery(name = "Crew.findAllCrewsByPerson",
							query = "SELECT c FROM Crew AS c WHERE c.person.id=:personId")})
@Entity
@Table(name= "crew")
public class Crew {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
		
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "flightId", nullable = false)
	private Flight flight;
	
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "personId", nullable = false)
	private Person person;
	
	public Long getId() {
		return id;
	}
	
	public void setIdCrew(Long id) {
		this.id = id;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Crew other = (Crew) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
