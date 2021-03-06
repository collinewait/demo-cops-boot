package com.example.wait.democopsboot.user;

import java.util.Optional;

public interface UserService {
	User createOfficer(String email, String password);

	Optional<User> getUser(UserId userId);

	Optional<User> findUserByEmail(String email);
}
