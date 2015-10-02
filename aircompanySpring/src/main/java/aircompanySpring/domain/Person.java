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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@NamedQueries({ @NamedQuery(name = "Person.findAllPersons", query = "SELECT p FROM Person AS p") ,
				@NamedQuery(name = "Person.searchPersons", 
						query = "SELECT p FROM Person AS p where "
								+ "lower(p.surname) like :searchString "			
								+ "or lower(p.name) like :searchString " 
								+ "or lower(p.lastName) like :searchString " 
								+ "or lower(p.email) like :searchString " 
								+ "or lower(p.position.specialty) like :searchString " 
								+ "or lower(p.mobile) like lower(:searchString) "),
				@NamedQuery(name = "Person.findSamePerson", 
						query = "SELECT p FROM Person AS p where "
								+ "lower(p.surname) like :surname "			
								+ "or lower(p.email) like :email ") })


@Entity
@Table(name= "person")
public class Person {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Size(min = 2, max = 20)
	@Pattern(regexp = "[a-zA-Z\u0430-\u044F\u0410-\u042F- ]+")
	@Column(name = "surname", nullable = false)
	private String surname;

	@Size(min = 2, max = 20)
	@Pattern(regexp = "[a-zA-Z\u0430-\u044F\u0410-\u042F- ]+")
	@Column(name = "name", nullable = false)
	private String name;

	@Size(min = 0, max = 20)
	@Pattern(regexp = "[a-zA-Z\u0430-\u044F\u0410-\u042F- ]*")
	@Column(name = "lastName")
	private String lastName;

	@NotNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "positionId", nullable = false)
	private Position position;

	
	@Past
	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "birthday", nullable = false)
	private Date birthday;

	@Size(min = 4, max = 12)
	@Pattern(regexp = "[0-9]+")
	@Column(name = "mobile")
	private String mobile;

	@Email
	@Column(name = "email")
	private String email;

	@Max(50)
	@Min(0)
	@Column(name = "experience")
	private Integer experience;

	@OneToMany(mappedBy="person", fetch = FetchType.LAZY, 
			cascade = {CascadeType.REMOVE, CascadeType.MERGE,
			CascadeType.REFRESH, CascadeType.PERSIST})
	@OrderBy("id")
	private Set<Crew> appointments;


	/*@OneToOne
	@JoinColumn(name = "idUser")
	private User idUser;
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;

	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}	

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	/*public User getIdUser() {
		return idUser;
	}

	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}*/

	public void setExperience(Integer experience) {
		this.experience = experience;
	}

	public Integer getExperience() {
		return experience;
	}

	public Set<Crew> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Crew> appointments) {
		this.appointments = appointments;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
	
		builder.append(surname);
		builder.append(" ");
		builder.append(name);
		
		builder.append(":");
		builder.append(position);
		
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((experience == null) ? 0 : experience.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
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
		Person other = (Person) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (experience == null) {
			if (other.experience != null)
				return false;
		} else if (!experience.equals(other.experience))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}	



}
