package com.prepreguntas.controller;

import com.prepreguntas.entity.Producto;
import org.slf4j.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductosController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProductosController.class);

	@GetMapping("")
	public String verProducto() {
		return "productos/produc";
	}

	@GetMapping("/crear")
	public String crearProducto() {
		return "productos/crear";
	}

	@PostMapping("/guardar")
	public String guardar(Producto producto) {
		LOGGER.info("Guardando producto: {}", producto);
		return "redirect:/productos";
	}



}
