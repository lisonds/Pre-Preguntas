package com.prepreguntas.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.PostMapping;

import com.prepreguntas.entity.Usuario;
import com.prepreguntas.service.IUsuarioService;

@Controller
public class PrincipalController {
		@Autowired
		private IUsuarioService usuarioService;
		
		
		@PostMapping("/principal")
		public String BuscarCorreo(@Valid Usuario usuario, BindingResult result,Model model) {
			String nombre = null;
			String correo = null;
			List<Usuario> lista = usuarioService.busrcarEmail(usuario.getCorreo());
			System.out.println(" hay : "+lista.size());
			if(lista.size()==0) {
				return"redirect:/login";
			}else {
				for(Usuario v:lista) {
					nombre=v.getNombre();
					correo=v.getCorreo();
				}
				System.out.println(nombre+" "+ correo);
				model.addAttribute("nombre",nombre);
				model.addAttribute("correo",correo);
				
				
				return"principal/index";
			}
			
			}
}
