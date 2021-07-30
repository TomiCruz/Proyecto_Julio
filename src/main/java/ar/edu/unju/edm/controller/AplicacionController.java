package ar.edu.unju.edm.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.edm.modelo.Producto;
import ar.edu.unju.edm.modelo.Usuario;
import ar.edu.unju.edm.service.IProductoService;
import ar.edu.unju.edm.service.IUsuarioService;

@Controller
public class AplicacionController {
	@Autowired
	IUsuarioService iUsuarioService;
	@Autowired
		IProductoService iProductoService;
	
	@GetMapping("/Client")
	public String InterfazClient() {
		return "InterfazCliente";
	}
	@GetMapping("/Admin")
	public String InterfazAdmin(Model model) {
		return "InterfazAdmin";
	}
	
	
	@GetMapping({"/","/login","/home","/login?error=true"})
	public String obtenerLogin(Model model) {
		
		//Long id, String dni, String nombre, String apellido,String tipo, String password
		
	//	Usuario bas1=new Usuario((long)1,"43352542","Tomas","Cruz","Admin","1234");
		//iUsuarioService.guardar(bas1);
		
		//Usuario bas = new Usuario((long)2,"123","T","C","Client","123");
		//iUsuarioService.guardar(bas);
		
		//Long id, String nombre, String codigo, Float precio, Float disponibilidad, Integer cantProductos
		
		iProductoService.guardar(new Producto((long)1,"Hambureguesa", "1",Float.parseFloat("100.0"),Float.parseFloat("100.5"), null));
		iProductoService.guardar(new Producto((long)2,"Milanesa", "2",Float.parseFloat("50.0"),Float.parseFloat("500.5"), null));
		iProductoService.guardar(new Producto((long)3,"Pollo", "3",Float.parseFloat("90.0"),Float.parseFloat("800.5"), null));
		iProductoService.guardar(new Producto((long)4,"Arroz", "4",Float.parseFloat("50.0"),Float.parseFloat("1100.5"), null));
 
		
		return "login";
	}
	

	@GetMapping("/logout")
    public String fetchSignoutSite(HttpServletRequest request, HttpServletResponse response) {        
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
          
        return "redirect:/login?logout";
    }
}
