package com.scheakur.todopopo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
@ComponentScan
public class App {

	public static void main(final String... args) {
		SpringApplication.run(App.class, args);
	}

	@RequestMapping("")
	public String home() {
		return "home";
	}

}
