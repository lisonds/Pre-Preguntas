package com.prepreguntas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PrincipalController {
		@GetMapping("/prepreguntas")
		public String view() {
			return "principal/index";
		}
}
