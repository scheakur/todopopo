package com.scheakur.todopopo.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class TodoService {

	@Autowired
	TodoRepository repo;

	public Iterable<Todo> findAll() {
		return repo.findAll();
	}

	public Todo findOne(String id) {
		return repo.findOne(UUID.fromString(id));
	}

	public void save(Todo todo) {
		repo.save(todo);
	}

	public Todo create(String title, String dateStr, int offsetMinutes) {
		ZonedDateTime dueDate = dueDateFrom(dateStr, offsetMinutes);
		return new Todo(title, dueDate);
	}

	private ZonedDateTime dueDateFrom(String dateStr, int offsetMinutes) {
		LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);
		offsetMinutes *= -1; // date.getTimezoneOffset in JS returns inverse value
		ZoneId zoneId = ZoneId.ofOffset("UTC", ZoneOffset.ofHoursMinutes(offsetMinutes / 60, offsetMinutes % 60));
		ZonedDateTime dueDate = date.atStartOfDay(zoneId);
		return dueDate;
	}

}
