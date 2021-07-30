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
			redirectStrategy.sendRedirect(request, response, "/Admin");
		}else {
			if(tipoClient) {
				redirectStrategy.sendRedirect(request, response, "/Client");
			}else {
					throw new IllegalStateException();
				}
			}
		}
	}
