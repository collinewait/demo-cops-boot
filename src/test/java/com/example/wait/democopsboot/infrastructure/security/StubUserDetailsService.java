package com.example.wait.democopsboot.infrastructure.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.wait.democopsboot.user.Users;

public class StubUserDetailsService implements UserDetailsService {
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		switch (username) {
		case Users.OFFICER_EMAIL:
			return new ApplicationUserDetails(Users.officer());
		case Users.CAPTAIN_EMAIL:
			return new ApplicationUserDetails(Users.captain());
		default:
			throw new UsernameNotFoundException(username);
		}
	}
}
