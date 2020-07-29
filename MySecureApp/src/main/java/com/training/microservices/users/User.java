package com.training.microservices.users;


import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	public enum Role {USER, ADMIN}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 25)
	private Integer id;

	@Column(name = "email", length = 50)
	private String email;

	@Column(name = "password", length = 800)
	private String password;

	@Column(name = "role", length = 50)
	@Enumerated(EnumType.STRING)
	private Role role;

	public User(String email, String encodedPwd, Role role) {
		this.email = email;
		this.password = encodedPwd;
		this.role= role;
	}
	public User() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}


