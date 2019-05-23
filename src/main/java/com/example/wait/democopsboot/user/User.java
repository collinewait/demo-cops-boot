package com.example.wait.democopsboot.user;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.example.wait.orm.jpa.AbstractEntity;
import com.google.common.collect.Sets;

@Entity
@Table(name = "copsboot_user")
public class User extends AbstractEntity<UserId> {

	private String email;
	private String password;

	@ElementCollection
	@Enumerated(EnumType.STRING)
	@NotNull
	private Set<UserRole> roles;

	protected User() {

	}

	public User(UserId id, String email, String password, Set<UserRole> roles) {
		super(id);
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	public static User createOfficer(UserId userId, String email,
			String encodedPassword) {
		return new User(userId, email, encodedPassword,
				Sets.newHashSet(UserRole.OFFICER));
	}

	public static User createCaptain(UserId userId, String email,
			String encodedPassword) {
		return new User(userId, email, encodedPassword,
				Sets.newHashSet(UserRole.CAPTAIN));
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
