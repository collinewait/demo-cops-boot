package com.example.wait.democopsboot.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wait.democopsboot.infrastructure.security.ApplicationUserDetails;
import com.example.wait.democopsboot.user.User;
import com.example.wait.democopsboot.user.UserNotFoundException;
import com.example.wait.democopsboot.user.UserService;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

	private final UserService service;

	@Autowired
	public UserRestController(UserService service) {
		this.service = service;
	}

	@GetMapping("/me")
	public UserDto currentUser(
			@AuthenticationPrincipal ApplicationUserDetails userDetails) {
		User user = service.getUser(userDetails.getUserId()).orElseThrow(
				() -> new UserNotFoundException(userDetails.getUserId()));
		return UserDto.fromUser(user);
	}

}
