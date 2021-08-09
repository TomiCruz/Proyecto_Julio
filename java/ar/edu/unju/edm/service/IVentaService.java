package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.Venta;
@Service
public interface IVentaService {
	
	public void guardarVenta(Venta unaVenta);
	public Venta crearVenta();
	public List<Venta> listarVenta();
	public Venta encontrarUnaVenta(int codigo) throws Exception;
	
}
