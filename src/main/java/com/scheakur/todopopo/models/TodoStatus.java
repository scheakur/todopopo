package com.scheakur.todopopo.models;

public enum TodoStatus {

	TODO, DONE;

	public String getName() {
		return name().toLowerCase();
	}

}
