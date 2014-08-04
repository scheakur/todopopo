package com.scheakur.todopopo.todo;

public enum TodoStatus {

	TODO, DONE;

	public String getName() {
		return name().toLowerCase();
	}

}
