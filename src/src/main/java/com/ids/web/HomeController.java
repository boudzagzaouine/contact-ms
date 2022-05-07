package com.ids.web;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home(Model m) {
		m.addAttribute("sinc", LocalTime.now());
		return "home";
	}
}
