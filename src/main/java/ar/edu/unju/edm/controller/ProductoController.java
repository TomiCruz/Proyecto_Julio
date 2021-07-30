package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ar.edu.unju.edm.modelo.Producto;
import ar.edu.unju.edm.service.IProductoService;


@Controller
@RequestMapping
public class ProductoController {

	@Autowired
	IProductoService productoService;
		
	//agregar producto
	@GetMapping("/cargarProducto")
	public String agregarP(Model model) {
		model.addAttribute("productoF", new Producto());
		return "agregarProducto";
	}
	
	@PostMapping("/guardarProducto")
	public String guardarP(@ModelAttribute Producto producto, Model model) {
		productoService.guardar(producto);
		model.addAttribute("productoF", new Producto());
		return "redirect:/cargarProducto"; 
	}
	//Listar producto
	@GetMapping("/Lproductos")
	public String mostrarProductos(Model model){
		model.addAttribute ("productos",productoService.listarProducto());
		return "listaProductos";	
	}	
	
	//modificar producto	 
	@GetMapping("/EDproducto/{id}")
	public String EditarProducto(Model model,@PathVariable(name="id") Long id) throws Exception{
		Producto productoEncontrada = productoService.encontrarProducto(id);
		model.addAttribute("productoF", productoEncontrada);
		model.addAttribute("editMode","true");
		return "Fproducto";
	}
	
	@PostMapping("/Mproducto")
	public String postEditarProducto( @ModelAttribute("productoF") Producto producto, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {			
			model.addAttribute("productoF", producto);
			model.addAttribute("editMode", "true");
		}else {
			try {
				System.out.println(producto.getId());

				productoService.modificar(producto);
				model.addAttribute("productoF", producto);
				model.addAttribute("editMode", "false");
			} catch (Exception e) {

				model.addAttribute("formProductoErrorMessage", e.getMessage());
				model.addAttribute("productoForm", producto);
				model.addAttribute("editMode", "true");
			}
		}

		model.addAttribute("productos",productoService.listarProducto());
		return "redirect:/Lproductos";
	}
	
	//eliminar producto
	@GetMapping("/Elproducto/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
			productoService.eliminar(id);
			return "redirect:/listaProductos";
		}
			
	//cancelar productos
	@GetMapping("/cancelarProducto")
	public String cancelarEditarProducto(ModelMap model) {
		return "redirect:/Vproductos";	
	}
}

