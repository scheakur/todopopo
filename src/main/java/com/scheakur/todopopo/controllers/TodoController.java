package com.scheakur.todopopo.controllers;

import com.scheakur.todopopo.models.Todo;
import com.scheakur.todopopo.models.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.ZonedDateTime;
import java.util.UUID;

@Controller
@RequestMapping("")
public class TodoController {

	@Autowired
	private TodoRepository repo;

	@RequestMapping("")
	public String list(Model model) {
		repo.deleteAll();
		repo.save(new Todo("Foo", ZonedDateTime.now()));
		repo.save(new Todo("Bar", ZonedDateTime.now()));
		repo.save(new Todo("Baz", ZonedDateTime.now()));
		Iterable<Todo> list = repo.findAll();
		model.addAttribute("todoList", list);
		return "todo/list";
	}


}
