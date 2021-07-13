package ar.edu.unju.edm;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class AutenticacionSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	//es un procedimiento donde se busca el suceso de la autenticacion 
		//3 parametros,la solicitud ,la respuesta y la autenticacion
		//2 tipo de datos booleanos
		//colecction (nombre de de tipo de datos) extiende todas las variables ,
		//es igual a la autenticacion pasada por parametros,solicito el tipo de datos
		//recorre la coleccion
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		boolean tipoAdmin = false;
		boolean tipoClient = false;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if(grantedAuthority.getAuthority().equals("Admin")) {
				tipoAdmin = true;
				break;
			}else {
				if(grantedAuthority.getAuthority().equals("Client")) {
					tipoClient = true;
					break;
				}
			}
		}
		//redireccion
		if(tipoAdmin) {
			redirectStrategy.sendRedirect(request, response, "/InterfazAdmin");
		}else {
			if(tipoClient) {
				redirectStrategy.sendRedirect(request, response, "/InterfazClient");
			}else {
					throw new IllegalStateException();
				}
			}
		}
	}
