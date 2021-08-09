package ar.edu.unju.edm.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.Usuario;
import ar.edu.unju.edm.repository.IUsuarioRepository;

@Service
public class LoginUsuarioServiceImp implements UserDetailsService{

	@Autowired
	IUsuarioRepository iUsuario;
	
	@Override
	public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		Usuario usuarioEncontrado = iUsuario.findByDni(dni).orElseThrow(()-> new UsernameNotFoundException("Usuario Invalido"));
		
		List<GrantedAuthority> tipos = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioEncontrado.getTipo());
		tipos.add(grantedAuthority);
		
		UserDetails user = (UserDetails) new User(dni, usuarioEncontrado.getPassword(),tipos);
		return user;
	}
}
