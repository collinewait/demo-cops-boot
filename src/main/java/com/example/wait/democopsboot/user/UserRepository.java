package com.example.wait.democopsboot.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, UserId>, UserRepositoryCustom {
	Optional<User> findByEmailIgnoreCase(String email);
}
