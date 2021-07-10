package ar.edu.unju.edm.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.service.IUsuarioServiceImp;
//import ar.edu.unju.edm.service.EquipoInterface;
import ar.edu.unju.edm.modelo.Usuario;

@Controller
public class AplicacionController {
	
	@Autowired
	private IUsuarioServiceImp usuarioService;

	
	@GetMapping("/Cliente")
	public String cliente() {
		return "Cliente";
	}
	@GetMapping("/Admin")
	public String admin(Model model) {
		return "admin";
	}

	
	@GetMapping("/formulario")
	public String cargarFormulario(Model model) {
		model.addAttribute("usuarioDelForm", new Usuario());
		model.addAttribute("listaUsuarios", usuarioService.listarTodos());
		model.addAttribute("formTab", "active");
		return "listaUsuarios";
	}
	
	@PostMapping("/formulario")
	public String crearUsuario(@Valid @ModelAttribute("usuarioDelForm") Usuario usuario, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("usarioDelForm", usuario);			
			model.addAttribute("formTab", "active");			
		} else {		
			try {
				usuarioService.crear(usuario);
				model.addAttribute("usuarioDelForm", new Usuario());
				model.addAttribute("listTab", "active");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				model.addAttribute("formUsuarioErrorMessage",e.getMessage());
				model.addAttribute("usuarioDelForm", usuario);				
				model.addAttribute("formTab", "active");				
			}								
			model.addAttribute("listaUsuarios", usuarioService.listarTodos());
	}
		return "listaUsuarios";
	}
	
	@GetMapping("/formulario/cancelar")
	public String cancelarEditarUsuario(ModelMap model){		
		return "redirigirUsuario";
	}
}
