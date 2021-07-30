package ar.edu.unju.edm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.edm.modelo.Producto;

public interface IProductoRepository extends JpaRepository <Producto,Long>{
	@Query("from Producto e order by e.id")
	public List<Producto> listarProductos();
	public Optional<Producto> findByNombre(String nombre);
	
}

