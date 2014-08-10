package com.scheakur.todopopo.todo;

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
	@Getter private ZonedDateTime doneDate;
	@Getter private TodoStatus status;

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

	public void done(LocalDateTime utcDoneDate) {
		ZonedDateTime doneDate = utcDoneDate.atZone(dueDate.getZone());
		this.doneDate = doneDate;
		this.status = TodoStatus.DONE;
	}

	public void undone() {
		this.doneDate = null;
		this.status = TodoStatus.TODO;
	}

	public String getFormattedDueDate() {
		return dueDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
	}


}
