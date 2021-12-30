package com.prepreguntas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class productosController {
	
	@GetMapping("/productos")
	public String verProducto() {
		return "productos/produc";
	}

}
