package com.prepreguntas.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.prepreguntas.entity.Publicacion;
import com.prepreguntas.entity.Usuario;
import com.prepreguntas.service.IUsuarioService;

@Controller
@SessionAttributes("publicacion")
public class AdminController {
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("/administrador")
	public String Usuarios(Model model) {
		model.addAttribute("usuarios",usuarioService.findAll());
	return "admin/admin";
	}
	
	@GetMapping("/administrador/form/{usuarioId}")
	public String crear(@PathVariable(value = "usuarioId") int id, Map<String, Object> model) {
		Usuario usuario=usuarioService.findOne(id);
		
		if(usuario==null) {
			System.out.println("No hay USUARIO ES NULLLLLLLLLLLLLLLLLL ");
			return "redirect:/administrador";
		}
		Publicacion publicacion =new Publicacion();
		
		publicacion.setUsuario(usuario);
		System.out.println("LLEgo asta AQUIIIIIIIIIIIIIIIII "+publicacion.getUsuario().getId());
		model.put("publicacion", publicacion);
		return "admin/admin2";
	}
	
	@GetMapping(value = "/administrador/{id}")
	public String ver(@PathVariable(value = "id") int id, Map<String, Object> model, RedirectAttributes flash) {

		Usuario usuario = usuarioService.findOne(id);
		if (usuario == null) {
			flash.addFlashAttribute("error", "El cliente no existe en la base de datos");
			return "redirect:/administrador";
		}
		
		System.out.println("llego asta Aqui "+ usuario.getPublicacion());
		for(Publicacion com:usuario.getPublicacion()) {
			System.out.println(com.getContenido());
		}
		 
		model.put("usuario",usuario);
		
		//model.put("titulo", "Detalle cliente: " + cliente.getNombre());
		
		return "admin/admin2";
	}
}
