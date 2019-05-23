package com.example.wait.democopsboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.example.wait.democopsboot.infrastructure.SpringProfiles;
import com.example.wait.democopsboot.user.UserService;

@Component
@Profile(SpringProfiles.DEV)
public class DevelopmentDbInitializer implements ApplicationRunner {
	private final UserService userService;

	@Autowired
	public DevelopmentDbInitializer(UserService userService) {
		this.userService = userService;
	}

	@Override
	public void run(ApplicationArguments applicationArguments) {
		createTestUsers();
	}

	private void createTestUsers() {
		userService.createOfficer("officer@example.com", "officer");
	}
}
