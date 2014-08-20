package com.scheakur.todopopo.controllers;

import com.scheakur.todopopo.habit.Activity;
import com.scheakur.todopopo.habit.Habit;
import com.scheakur.todopopo.habit.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("habit")
public class HabitController {

	@Autowired
	private HabitService service;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String list(Model model) {

		Map<Habit, List<Activity>> data = service.findAll();

		return "habit/list";
	}

}
