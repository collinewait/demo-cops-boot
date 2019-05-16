package com.example.wait.democopsboot.user;

import java.util.Set;
import java.util.UUID;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "copsboot_user")
public class User {
	@Id
	private UUID id;
	private String email;
	private String password;
	
	@ElementCollection
	@Enumerated(EnumType.STRING)
	@NotNull
	private Set<UserRole> roles;
	
	protected User() {
		
	}

	public User(UUID id, String email, String password, Set<UserRole> roles) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public UUID getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}
}