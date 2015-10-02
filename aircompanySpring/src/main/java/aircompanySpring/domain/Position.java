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

@Entity
@Table(name= "position")
@NamedQueries({ @NamedQuery(name = "Position.findAllPositions", query = "SELECT p FROM Position AS p")})
public class Position {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	@Column(name = "specialty")
	private String specialty;
	
	@OneToMany(mappedBy="position", fetch=FetchType.LAZY, 
			cascade = {CascadeType.REMOVE, CascadeType.MERGE,
			   CascadeType.REFRESH})
	@OrderBy("id")
	private Set<Person> persons;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(" ");
		builder.append(specialty);
		builder.append(" ");
		return builder.toString();
	}
	
	
}
