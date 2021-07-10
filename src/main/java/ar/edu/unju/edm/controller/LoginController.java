package ar.edu.unju.edm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ar.edu.unju.edm.modelo.Usuario;
import ar.edu.unju.edm.service.IUsuarioServiceImp;

@Controller
public class LoginController {
		
	@Autowired
	private IUsuarioServiceImp usuarioService;
	@Autowired
	private Usuario unUsuario;
	
	@GetMapping({"/","/login"})
	public String ingresarLogin(Model model) {
		model.addAttribute("usuarioDelForm", new Usuario());
		
		//Long id, Integer dni, String nombre, String apellido,String tipo, String password

		Usuario bas=new Usuario((long)1,"43352542","Tomas","Cruz","Admin","1234");
		usuarioService.crear(bas);
	
		return "login";
	}
	
	@PostMapping("/ingresarUsuario")
	public String loginUsuario(@ModelAttribute("usuarioDelForm") Usuario usuario, ModelMap model) throws Exception{
		String redireccion = "";
			try {				
				Usuario usuarioEncontrado = usuarioService.encontrarUsuarioDni(usuario);
			
				if (usuarioEncontrado == null) {		        
		            throw new Exception("No hay coincidencia entre dni o contraseña.");
		        }
				redireccion = usuarioService.redirigirUsuario(usuarioEncontrado);
				model.addAttribute("usuarioDelForm", usuarioEncontrado);
				return redireccion;	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				model.addAttribute("formLoginErrorMessage",e.getMessage());
				model.addAttribute("usuarioDelForm", unUsuario);
				return "/login";
			}			
	}
}
