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

import ar.edu.unju.edm.modelo.Usuario;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
@RequestMapping
public class UsuarioController {
	@Autowired
	IUsuarioService usuarioService;
	
	@GetMapping("/cargarUsuario")
	public String agregarU(Model model) {
		model.addAttribute("usuarioF",new Usuario());
		return "agregarUsuario";
	}
	
	@PostMapping("/guardarUsuario")
	public String guardarU(@ModelAttribute Usuario usuario, Model model) {
		//verificardni
		usuarioService.guardar(usuario);
		model.addAttribute("usuarioF", usuario);
		return "redirect:/cargarUsuario";
	} 
	
 
	@GetMapping("/Lusuarios")
	public String mostrarUsuarios(Model model){
		model.addAttribute("usuarios", usuarioService.listarUsuario());
		return "listaUsuarios";	
		
	}
	

	//modificar
	@GetMapping("/EDusuario/{id}")
	public String ObtenerFormularioEditarUsuario(Model model, @PathVariable(name="id") Long id) throws Exception {
		Usuario usuarioEncontrado = usuarioService.encontrarUsuario(id);
		model.addAttribute("usuarioF", usuarioEncontrado);
		model.addAttribute("editMode","true");
		return "editarUsuario";
	}
	
	@PostMapping("/Musuario")
	public String postEditarUsuario(@ModelAttribute("usuarioF") Usuario usuario, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("usuarioF", usuario);
			model.addAttribute("editMode", "true");
			model.addAttribute("usuarios", usuarioService.listarUsuario());
		}else {
			try {
				System.out.println(usuario.getId());

				usuarioService.modificar(usuario);
				model.addAttribute("usuarioF", usuario);
				model.addAttribute("editMode", "false");
			} catch (Exception e) {
				model.addAttribute("formUsuarioErrorMessage", e.getMessage());
				model.addAttribute("userForm", usuario);
				model.addAttribute("editMode", "true");
			}
		}

		
		return "redirect:/Lusuarios";
	}
	
	
	//eliminar
	@GetMapping("/Elusuario/{id}")
	public String eliminar(@PathVariable Long id, Model model) {
		usuarioService.eliminar(id);
		return "redirect:/Lusuarios";
	}
	
	@GetMapping("/cancelar")
	public String cancelar() {
		return "redirect:/Admin";
	}
	
}