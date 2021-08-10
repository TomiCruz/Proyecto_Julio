package ar.edu.unju.edm.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.edu.unju.edm.modelo.Compra;
import ar.edu.unju.edm.modelo.Usuario;

@Repository
public interface ICompraRepository extends CrudRepository<Compra, Long>{
	public Iterable<Compra> findByUsuario(Usuario usuario);
	
}
