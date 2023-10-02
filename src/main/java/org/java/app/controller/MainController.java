package org.java.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index(Model model) {
		final String name = "Alessandro";
		model.addAttribute("name",name);
		
		return "index";
	}

}
