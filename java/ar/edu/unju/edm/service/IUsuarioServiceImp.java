package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.Usuario;
import ar.edu.unju.edm.repository.IUsuarioRepository;
//import ar.edu.unju.edm.repository.IUsuarioRepositoryImp;

@Service
public class IUsuarioServiceImp implements IUsuarioService{
	
	@Autowired
	IUsuarioRepository iUsuario;

	@Override
	public void guardar(Usuario usuario) {
		// TODO Auto-generated method stub
		String pw = usuario.getPassword();
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		usuario.setPassword(bCryptPasswordEncoder.encode(pw));
		iUsuario.save(usuario);
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		iUsuario.deleteById(id);
	}

	@Override
	public Usuario modificar(Usuario unUsuario) throws Exception {	
		Usuario usuarioB = iUsuario.findByDni(unUsuario.getDni()).orElseThrow(()->new Exception("El Cliente no fue encontrado"));
		mapearUsuario(unUsuario, usuarioB);
		return iUsuario.save(usuarioB);
	}
//Long id, String dni, String nombre, String apellido,String tipo, String password
	public void mapearUsuario(Usuario desde, Usuario hacia) {
		//hacia.setDni(desde.getDni());
		hacia.setNombre(desde.getNombre());
		hacia.setApellido(desde.getApellido());
		hacia.setPassword(desde.getPassword());
		hacia.setTipo(desde.getTipo());
		
		//observen que NO se ha cambiado el id, ya que ese atributo no debería permitirse cambiar
	}	
	
//--------------------------------------------------------------------
	@Override
	public Usuario encontrarUsuario(Long id) throws Exception {
		// TODO Auto-generated method stub
		return iUsuario.findById(id).orElseThrow(() -> new Exception("El usuario no existe"));

	}


	@Override
	public List<Usuario> listarUsuario() {
		 //TODO Auto-generated method stub
		return iUsuario.listarUsuarios();
	}
}