package com.prepreguntas.controller;




import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.prepreguntas.DAO.IUsuarioDao;
import com.prepreguntas.entity.Usuario;




@Controller

public class loginController {
	@Autowired
	private IUsuarioDao usuarioDao;
	
	
	/* muestra los datos de base de datos Usuario*/
	@GetMapping("/administrador")
	public String Usuarios(Model model) {
		model.addAttribute("usuarios",usuarioDao.findAll());
	return "admin/admin";
	}
	
	/* se encarga de mostrar el formulario*/
	@GetMapping("/login")
	public String crearUauario(Map<String, Object> model) {
		Usuario usuario=new Usuario();
		model.put("usuario", usuario);
		return"view/login";
	}
	/*Guardar formulario*/
	@PostMapping("/login")
	public String guardar(@Valid Usuario usuario, BindingResult result,Model model){
		if(result.hasErrors()) {
			return "view/login";
		}
		
		usuarioDao.Guardar(usuario);
		return"redirect:administrador";
		
	}
	
	
	
}
