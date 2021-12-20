package com.prepreguntas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.prepreguntas.entity.Usuario;
import com.prepreguntas.repo.UsuarioRepository;

@Controller

public class loginController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping("/login")
	public String Logint() {
		
		return "view/login";
	}
	@PostMapping("/login")
	public String Loguear(Model model,
			@RequestParam String nombre,
			@RequestParam String email,
			@RequestParam String password,
			@RequestParam String password2) {
		model.addAttribute("nombre",nombre);
		model.addAttribute("email",email);
		model.addAttribute("password",password);
		model.addAttribute("password2",password2);
		return "prueba";
	}
	
}
