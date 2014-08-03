package com.scheakur.todopopo.models;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Entity
@ToString
public class Todo {

	@Id @Getter private final UUID id;
	@Getter private String title;
	@Getter private ZonedDateTime dueDate;
	@Getter private final ZonedDateTime doneDate;
	@Getter private final TodoStatus status;

	protected Todo() {
		this.id = UUID.randomUUID();
		this.status = TodoStatus.TODO;
		this.doneDate = null;
	}

	public Todo(String title, ZonedDateTime dueDate) {
		this();
		this.title = title;
		this.dueDate = dueDate;
	}

	private Todo(Todo todo, ZonedDateTime doneDate) {
		this.id = todo.id;
		this.title = todo.title;
		this.dueDate = todo.dueDate;
		this.doneDate = doneDate;
		this.status = TodoStatus.DONE;
	}

	public Todo done(LocalDateTime utcDoneDate) {
		ZonedDateTime doneDate = utcDoneDate.atZone(dueDate.getZone());
		return new Todo(this, doneDate);
	}

	public String getFormattedDueDate() {
		return dueDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}

}
