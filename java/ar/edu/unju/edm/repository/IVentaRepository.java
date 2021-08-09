package ar.edu.unju.edm.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ar.edu.unju.edm.modelo.Venta;

public interface IVentaRepository extends CrudRepository<Venta,Long>{
	
	//public List<Venta> listarVenta();
	public Optional<Venta> findByIdVenta(String idVenta);
}
