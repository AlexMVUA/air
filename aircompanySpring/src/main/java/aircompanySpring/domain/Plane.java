package aircompanySpring.domain;

import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@NamedQueries({ @NamedQuery(name = "Plane.findAllPlanes", query = "SELECT p FROM Plane AS p"),
	@NamedQuery(name = "Plane.findSamePlane", 
	 query = "SELECT p FROM Plane AS p  where lower(p.model) like :model ") })

@Entity
@Table(name= "plane")
public class Plane {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Size(min = 3, max = 15)
	@Pattern(regexp = "[a-zA-Z\u0430-\u044F\u0410-\u042F0-9- ]+")
	@Column(name = "model")
    private String model;
		
	
	@Min(2)
	@Max(6)
	@Column(name = "pilotNeeds")
    private int pilotNeeds;
	 
	@Min(0)
	@Max(2)
	@Column(name = "navigatorNeeds")
    private int navigatorNeeds;
 
	@Min(0)
	@Max(2)
	@Column(name = "radiomanNeeds")
    private int radiomanNeeds;
	 
	@Min(2)
	@Max(10)
	@Column(name = "stewardessNeeds")
    private int stewardessNeeds;
    
	@OneToMany(mappedBy="plane", fetch = FetchType.LAZY, 
			cascade = {CascadeType.REMOVE, CascadeType.MERGE,
			   CascadeType.REFRESH})
	@OrderBy("id")
	private Set<Flight> schedule;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getPilotNeeds() {
		return pilotNeeds;
	}
	public void setPilotNeeds(int pilotNeeds) {
		this.pilotNeeds = pilotNeeds;
	}
	public int getNavigatorNeeds() {
		return navigatorNeeds;
	}
	public void setNavigatorNeeds(int navigatorNeeds) {
		this.navigatorNeeds = navigatorNeeds;
	}
	public int getRadiomanNeeds() {
		return radiomanNeeds;
	}
	public void setRadiomanNeeds(int radiomanNeeds) {
		this.radiomanNeeds = radiomanNeeds;
	}
	public int getStewardessNeeds() {
		return stewardessNeeds;
	}
	public void setStewardessNeeds(int stewardessNeeds) {
		this.stewardessNeeds = stewardessNeeds;
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
		builder.append(model);
		builder.append(" ");
		return builder.toString();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
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
		Plane other = (Plane) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		return true;
	}
    
}
