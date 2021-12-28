package com.prepreguntas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.prepreguntas.entity.Usuario;
import com.prepreguntas.service.IUsuarioService;

@Controller
public class PrincipalController {
		@Autowired
		private IUsuarioService usuarioService;
		@GetMapping("/prepreguntas")
		public String view() {
			
			return "principal/index";
		}
}
