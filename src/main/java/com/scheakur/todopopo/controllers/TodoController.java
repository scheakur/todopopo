package com.scheakur.todopopo.controllers;

import com.scheakur.todopopo.models.Todo;
import com.scheakur.todopopo.models.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("")
public class TodoController {

	@Autowired
	private TodoRepository repo;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		Iterable<Todo> list = repo.findAll();
		model.addAttribute("todoList", list);
		return "todo/list";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String add(
			@RequestParam("title") String title, @RequestParam("duedate") String dateStr,
			@RequestParam("offset") int offsetMinutes, Model model) {
		ZonedDateTime dueDate = dueDateFrom(dateStr, offsetMinutes);
		repo.save(new Todo(title, dueDate));
		return list(model);
	}

	private ZonedDateTime dueDateFrom(String dateStr, int offsetMinutes) {
		LocalDate date = LocalDate.parse(dateStr, DateTimeFormatter.ISO_LOCAL_DATE);
		offsetMinutes *= -1; // date.getTimezoneOffset in JS returns inverse value
		ZoneId zoneId = ZoneId.ofOffset("UTC", ZoneOffset.ofHoursMinutes(offsetMinutes / 60, offsetMinutes % 60));
		ZonedDateTime dueDate = date.atStartOfDay(zoneId);
		return dueDate;
	}

}
