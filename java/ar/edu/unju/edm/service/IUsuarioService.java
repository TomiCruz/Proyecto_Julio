package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.Usuario;

@Service
public interface IUsuarioService {
	
	public void guardar(Usuario unUsuario);
	public List<Usuario> listarUsuario();
	public void eliminar(Long id);
	public Usuario modificar(Usuario unUsuario) throws Exception;
	public Usuario encontrarUsuario(Long id) throws Exception;

	public Object obtenerTodosUsuarios();
	
	
}
