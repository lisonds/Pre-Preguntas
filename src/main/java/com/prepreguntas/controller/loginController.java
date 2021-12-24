package com.prepreguntas.controller;




import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.prepreguntas.entity.Usuario;
import com.prepreguntas.service.IUsuarioService;






@Controller

public class loginController {
	@Autowired
	private IUsuarioService usuarioService;
	
	
	/* muestra los datos de base de datos Usuario*/
	@GetMapping("/administrador")
	public String Usuarios(Model model) {
		model.addAttribute("usuarios",usuarioService.findAll());
	return "admin/admin";
	}
	
	/* se encarga de mostrar el formulario*/
	@GetMapping({"/login","/"})
	public String crearUauario(Map<String, Object> model) {
		Usuario usuario=new Usuario();
		model.put("usuario", usuario);
		return"view/login";
	}
	/*Guardar formulario*/
	@PostMapping("/loginCrear")
	public String guardar(@Valid Usuario usuario, BindingResult result,Model model){
		if(result.hasErrors()) {
			return "view/login";
		}
		
		usuarioService.Guardar(usuario);
		return"redirect:/administrador";
		
	}
	@RequestMapping(value = "/eliminar/{id}")
	public String Eliminar(@PathVariable(value="id") int id) {
		if(id>0) {
			usuarioService.delete(id);
			
		}
		return"redirect:/administrador";
	}
	@PostMapping("/login")
	public String BuscarCorreo(@Valid Usuario usuario, BindingResult result,Model model) {
		
		List<Usuario> lista = usuarioService.busrcarEmail(usuario.getCorreo());
		for(Usuario u:lista){
			System.out.println("encontro "+u.getNombre());
		}
			return"redirect:/prepreguntas";
		}
	}
	
	

