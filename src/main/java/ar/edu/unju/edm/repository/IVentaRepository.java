package ar.edu.unju.edm.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import ar.edu.unju.edm.modelo.Venta;

public interface IVentaRepository extends JpaRepository<Venta,Long>{
	//@Query("from Venta e order by e.id")
	//public List<Venta> listarVenta();
	//public Optional<Venta> findByVenta(String venta);
}
