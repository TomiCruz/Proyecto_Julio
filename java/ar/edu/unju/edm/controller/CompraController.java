package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.modelo.Compra;
import ar.edu.unju.edm.service.IProductoService;
import ar.edu.unju.edm.service.ICompraService;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
public class CompraController {
	
	@Autowired
	Compra compra;
	
	@Autowired
	ICompraService iCompraService;
	
	@Autowired
	IProductoService iProductoService;
	
	@Autowired
	IUsuarioService iUsuarioService;

	
	//lista
	@GetMapping("/listaCompras")
	public String listaCompras(Model model) {
		model.addAttribute("compras",iCompraService.listarCompras());
		return "comprar";
	}
	
	//compra
	@GetMapping("/comprar")
	public String comprarProducto(Model model) {
		model.addAttribute("productos", iProductoService.listarProducto());
		model.addAttribute("compraNueva", new Compra());
		return "comprar";
	}

	@PostMapping("/comprar")
	public String comprarProductoPost(@ModelAttribute("compraNueva") Compra compra, Model model) {
		iCompraService.guardarCompra(compra);
		return "comprar";
	}
	
}