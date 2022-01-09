package com.prepreguntas.controller;

import com.prepreguntas.entity.Producto;
import com.prepreguntas.service.ProductoServiceImpl;
import com.prepreguntas.service.UploadFileService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
		List<Producto> productos = productoService.findAll();
		model.addAttribute("productos",productos);
		return "productos/produc";
	}

	@GetMapping("/detalle/{id}")
	public String detallesProducto(@PathVariable int id, Model model) {
		LOGGER.info("ID producto enviando como parametro: {}", id);
		Producto producto = new Producto();
		Optional<Producto> optProducto = productoService.get(id);
		producto = optProducto.get();
		model.addAttribute("producto", producto);
		return "productos/detalleProduct";
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
			System.out.println("nombre del imagen "+ nombreImagen);
		}
		
		productoService.saveOne(producto);
		return "redirect:/productos";
	}





}
