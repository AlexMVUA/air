package aircompanySpring.domain;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NamedQueries({ @NamedQuery(name = "Destination.findAllDestinations", query = "SELECT d FROM Destination AS d"),
	 @NamedQuery(name = "Destination.findSameDestination", 
	 query = "SELECT d FROM Destination AS d   where "
				+ "lower(d.country) like :country "
				+ "and lower(d.city) like :city "
				+ "and lower(d.airport) like :airport " ) })
@Entity
@Table(name= "destination")
public class Destination {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[a-zA-Z\u0430-\u044F\u0410-\u042F- ]+")
	@Column(name = "country", nullable = false)
    private String country;
	
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[a-zA-Z\u0430-\u044F\u0410-\u042F- ]+")
	@Column(name = "city", nullable = false)
    private String city;
	
	@Size(min = 3, max = 20)
	@Pattern(regexp = "[a-zA-Z0-9\u0430-\u044F\u0410-\u042F- ]+")
	@Column(name = "airport", nullable = false)
    private String airport;
    
	@OneToMany(mappedBy="destinationFrom", fetch = FetchType.LAZY)
	@OrderBy("id")
	private Set<Route> routes;	
	
	@OneToMany(mappedBy="destinationTo", fetch = FetchType.LAZY)
	@OrderBy("id")
	private Set<Route> routesD;	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getAirport() {
		return airport;
	}
	
	public void setAirport(String airport) {
		this.airport = airport;
	}
	
	/*public Set<Route> getRoutes() {
		return routes;
	}

	public void setRoutes(Set<Route> routes) {
		this.routes = routes;
	}*/

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(airport);
		builder.append(" ");
		builder.append(city);
		builder.append(" ");
		builder.append(country);
		
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((airport == null) ? 0 : airport.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
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
		Destination other = (Destination) obj;
		if (airport == null) {
			if (other.airport != null)
				return false;
		} else if (!airport.equals(other.airport))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;		
		return true;
	}
        
	
	
}
