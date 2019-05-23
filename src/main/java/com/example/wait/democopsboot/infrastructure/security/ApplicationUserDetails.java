package com.example.wait.democopsboot.infrastructure.security;

import com.example.wait.democopsboot.user.User;
import com.example.wait.democopsboot.user.UserId;
import com.example.wait.democopsboot.user.UserRole;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class ApplicationUserDetails extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;

	private static final String ROLE_PREFIX = "ROLE_";
	private final UserId userId;

	public ApplicationUserDetails(User user) {
		super(user.getEmail(), user.getPassword(), createAuthorities(user.getRoles()));
		this.userId = user.getId();
	}

	public UserId getUserId() {
		return userId;
	}

	private static Collection<SimpleGrantedAuthority> createAuthorities(Set<UserRole> roles) {
		return roles.stream().map(userRole -> new SimpleGrantedAuthority(ROLE_PREFIX + userRole.name()))
				.collect(Collectors.toSet());
	}
}
