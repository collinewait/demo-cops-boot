package com.example.wait.democopsboot.user;

import com.example.wait.orm.jpa.AbstractEntityId;

import java.util.UUID;

public class UserId extends AbstractEntityId<UUID> {

	private static final long serialVersionUID = 1L;

	protected UserId() {
	}

	public UserId(UUID id) {
		super(id);
	}
}