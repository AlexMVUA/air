package aircompanySpring.domain;


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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@NamedQueries({ @NamedQuery(name = "Route.findAllRoutes", query = "SELECT r FROM Route AS r"),
				@NamedQuery(name = "Route.searchRoutes", 
					query = "SELECT r FROM Route AS r where "
							+ "lower(r.destinationFrom.country) like :searchString "
							+ "or lower(r.destinationFrom.city) like :searchString "
							+ "or lower(r.destinationFrom.airport) like :searchString "
							+ "or lower(r.destinationTo.country) like :searchString "
							+ "or lower(r.destinationTo.city) like :searchString "
							+ "or lower(r.destinationTo.airport) like :searchString"),
				@NamedQuery(name = "Route.findSameRoute", 
					query = "SELECT r FROM Route AS r  where r.destinationFrom.id =:destinationFromID "
							+ "and r.destinationTo.id =:destinationToID") })
@Entity
@Table(name= "route")
public class Route {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "destinationFromId", nullable = false)	
    private Destination destinationFrom;	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "destinationToId", nullable = false)
    private Destination destinationTo; 
	
	@OneToMany(mappedBy="route",fetch = FetchType.LAZY, 
			cascade={CascadeType.REMOVE, CascadeType.MERGE, CascadeType.REFRESH})
	@OrderBy("id")
	private Set<Flight> schedule;
	    
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
				
	public Destination getDestinationFrom() {
		return destinationFrom;
	}
	
	public void setDestinationFrom(Destination destinationFrom) {
		this.destinationFrom = destinationFrom;
	}
	
	public Destination getDestinationTo() {
		return destinationTo;
	}
	
	public void setDestinationTo(Destination destinationTo) {
		this.destinationTo = destinationTo;
	}
	
	public Set<Flight> getSchedule() {
		return schedule;
	}

	public void setSchedule(Set<Flight> schedule) {
		this.schedule = schedule;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(" ");
		builder.append(destinationFrom);
		builder.append(" : ");
		builder.append(destinationTo);
		
		return builder.toString();
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
		Route other = (Route) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
    
    
}
