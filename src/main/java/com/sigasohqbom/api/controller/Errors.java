package com.sigasohqbom.api.controller;

public enum Errors {
	
	BAD_REQEUEST("Bad Request"), 
	INTERNAL_SERVER_ERROR("Internal Server Error"), 
	NOT_FOUND("Not Found");

	private final String description;

	Errors(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
