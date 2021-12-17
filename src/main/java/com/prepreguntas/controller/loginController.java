package com.prepreguntas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prepreguntas.entity.Usuario;
import com.prepreguntas.repo.UsuarioRepository;

@RestController
@RequestMapping("/login")
public class loginController {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	List<Usuario> Logint() {
		
		return usuarioRepository.findAll();
	}
	@PostMapping
	Usuario crear(@RequestBody Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
}
