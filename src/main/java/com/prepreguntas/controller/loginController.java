package com.prepreguntas.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.prepreguntas.DAO.IUsuarioDao;




@Controller

public class loginController {
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@GetMapping("/usuarios")
	public String Usuarios(Model model) {
		model.addAttribute("usuarios",usuarioDao.findAll());
	return "admin/admin";
	}
}
