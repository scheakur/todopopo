package com.scheakur.todopopo.controllers;

import com.scheakur.todopopo.todo.Todo;
import com.scheakur.todopopo.todo.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.time.LocalDateTime;

@Controller
@RequestMapping("")
public class TodoController {

	@Autowired
	private TodoService service;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {
		Iterable<Todo> list = service.findAll();
		model.addAttribute("todoList", list);
		return "todo/list";
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public String add(
			@RequestParam("title") String title, @RequestParam("duedate") String dateStr,
			@RequestParam("offset") int offsetMinutes, Model model) {
		Todo todo = service.create(title, dateStr, offsetMinutes);
		service.save(todo);
		return list(model);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public String done(@PathVariable("id") String id, Model model) {
		Todo todo = service.findOne(id);
		todo.done(LocalDateTime.now(Clock.systemUTC()));
		service.save(todo);
		return "ok";
	}

	@RequestMapping(value = "{id}", method = RequestMethod.POST)
	@ResponseBody
	public String undone(@PathVariable("id") String id, Model model) {
		Todo todo = service.findOne(id);
		todo.undone();
		service.save(todo);
		return "ok";
	}

}
