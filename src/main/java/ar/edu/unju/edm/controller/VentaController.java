package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.modelo.Producto;
import ar.edu.unju.edm.modelo.Venta;
import ar.edu.unju.edm.service.IUsuarioService;
import ar.edu.unju.edm.service.IVentaService;

import ar.edu.unju.edm.service.IProductoService;

public class VentaController {

	@Autowired
	IVentaService ventaService;
	
	@Autowired
	Venta unaVenta;
	
	@Autowired
	IProductoService productoService;
	
	@Autowired
	IUsuarioService usuarioService;
	
	@Autowired
	Producto productoSelec;
	
	@GetMapping("/producto/ventas")
	public String cargarVentas(Model model) {					//??
		//model.addAttribute("unProducto", productoService.guardar();
		model.addAttribute("productos", productoService.listarProducto());
		return("ventas");
	}
	
	@GetMapping("/producto/vender/{codigo}")	
	public String realizarVenta(Model model, @PathVariable(name="codigo") Integer codigo) throws Exception {
		Venta venta = new Venta();	
		
		try {												  //??
			productoSelec = productoService.encontrarProducto(null);
			venta = ventaService.crearVenta();		
			//venta.getProductos(productoSelec);
			model.addAttribute("venta", venta);
			model.addAttribute("usuarios",usuarioService.listarUsuario());
		}
		catch (Exception e) {
			model.addAttribute("formUsuarioErrorMessage",e.getMessage());		
		}		
		return "venta-modal";
	}
	
	@PostMapping("/producto/vender")
	public String guardarNuevoProducto(@ModelAttribute("venta") Venta unaVenta, Model model) {
		ventaService.guardarVenta(unaVenta);
		
		return("redirect:/producto/ventas");
	}
}
