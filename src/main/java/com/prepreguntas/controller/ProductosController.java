package com.prepreguntas.controller;

import com.prepreguntas.entity.Producto;
import com.prepreguntas.service.ProductoServiceImpl;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/productos")
public class ProductosController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProductosController.class);

	@Autowired
	private ProductoServiceImpl productoService;

	@GetMapping("")
	public String verProducto(Model model) {
		model.addAttribute("productos", productoService.findAll());
		return "productos/produc";
	}

	@GetMapping("/crear")
	public String crearProducto() {
		return "productos/crear";
	}

	@PostMapping("/guardar")
	public String guardar(Producto producto) {
		LOGGER.info("Guardando producto: {}", producto);
		productoService.saveOne(producto);
		return "redirect:/productos";
	}



}
