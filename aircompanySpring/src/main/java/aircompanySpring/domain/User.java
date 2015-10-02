package aircompanySpring.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQueries({ 
			@NamedQuery(name = "User.findAllUsers", query = "SELECT u FROM User AS u"),
			@NamedQuery(name = "User.getByLoginAndPassword",
				query = "SELECT u FROM User AS u WHERE u.login=:login AND u.password=:password"),			
			@NamedQuery(name = "User.getByLogin", query = "SELECT u FROM User AS u WHERE u.login=:login")
			})

@Entity
@Table(name="user")
public class User {
	
	@Id  @GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column
	@Size(min = 6, max = 10)
    private String login;
	
	@NotNull
	@Size(min = 6, max = 10)
	@Column
    private String password;	 
	
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
	UserRole role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setUserRole(UserRole role) {
		this.role = role;
	}
	
		
}
