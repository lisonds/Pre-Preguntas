package com.prepreguntas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class loginController {
	
	@GetMapping("/crear")
	public String Logint() {
		
		return "/view/login";
	}
	
}
