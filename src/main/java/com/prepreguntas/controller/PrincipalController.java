package com.prepreguntas.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.prepreguntas.entity.Publicacion;
import com.prepreguntas.entity.Usuario;
import com.prepreguntas.service.IUsuarioService;

@Controller
public class PrincipalController {
		@Autowired
		private IUsuarioService usuarioService;
		
		
		@PostMapping("/principal")
		public String BuscarCorreo(@Valid Usuario usuario, BindingResult result,Model model) {
			
			int id=0;
			List<Usuario> lista = usuarioService.busrcarEmail(usuario.getCorreo());
			
			if(lista.size()==0) {
				return"redirect:/login";
			}else {
				for(Usuario v:lista) {
					
					id=v.getId();
				}
			Usuario usuario1=usuarioService.findOne(id);
				model.addAttribute("nombre",usuario1.getNombre());
				model.addAttribute("correo",usuario1.getCorreo());
				model.addAttribute("id",usuario1.getId());
				Publicacion publicacion=new Publicacion();
				publicacion.setUsuario(usuario1);
				
				model.addAttribute("publicacion",publicacion);
				model.addAttribute("titulo"," crea tu publicacion");
				return"principal/index";
			}
			
			}
		@PostMapping("/publicacion/form")
		public String CapturarPublicacion(Publicacion publicacion,Model model, @RequestParam("file") MultipartFile imagen) {
			/*EXTRAENDO IMAGEN PARA SUBIR AL BASE DE DATOS*/
			if(!imagen.isEmpty()) {
				System.out.println("llego asta aqui");
				Path directoriaoRecursos=Paths.get("src//main//resources//static/uploads");
				String rootPath=directoriaoRecursos.toFile().getAbsolutePath();
				try {
					byte[] bytes=imagen.getBytes();
					Path rutaCompleta=Paths.get(rootPath+"/"+imagen.getOriginalFilename());
					Files.write(rutaCompleta, bytes);
					System.out.println("has subido un imagen "+ imagen.getOriginalFilename());
					publicacion.setImagen(imagen.getOriginalFilename());
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
			
			System.out.println(publicacion.getContenido());
			System.out.println(publicacion.getImagen());
			return "redirect:/principal";
		}
		
		
		
}


