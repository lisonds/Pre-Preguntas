package com.prepreguntas.controller;

import com.prepreguntas.entity.Producto;
import com.prepreguntas.service.ProductoServiceImpl;
import com.prepreguntas.service.UploadFileService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/productos")
public class ProductosController {

	private final Logger LOGGER = LoggerFactory.getLogger(ProductosController.class);

	@Autowired
	private ProductoServiceImpl productoService;

	@Autowired
	private UploadFileService uploadFileService;

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
	public String guardar(Producto producto, @RequestParam("img") MultipartFile file) throws IOException {
		LOGGER.info("Guardando producto: {}", producto);

		//imagen
		if (producto.getIdProducto()==0) { // cuando se crea un producto
			String nombreImagen= uploadFileService.saveImage(file);
			producto.setImagen(nombreImagen);
		}
		productoService.saveOne(producto);
		return "redirect:/productos";
	}



}
