package com.scheakur.todopopo.models;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@ToString
public class Todo {

	@Id @Getter private final UUID id;
	@Getter private String title;
	@Getter private ZonedDateTime dueDate;

	protected Todo() {
		this.id = UUID.randomUUID();
	}

	public Todo(String title, ZonedDateTime dueDate) {
		this.id = UUID.randomUUID();
		this.title = title;
		this.dueDate = dueDate;
	}

}
