package com.example.wait.democopsboot.user.web;

import java.util.Set;

import com.example.wait.democopsboot.user.User;
import com.example.wait.democopsboot.user.UserId;
import com.example.wait.democopsboot.user.UserRole;

import lombok.Value;

@Value
public class UserDto {
	private final UserId id;
	private final String email;
	private final Set<UserRole> roles;

	public static UserDto fromUser(User user) {
		return new UserDto(user.getId(), user.getEmail(), user.getRoles());
	}
}
