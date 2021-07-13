package ar.edu.unju.edm.service;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.Venta;
@Service
public interface IVentaService {
	
	public void guardarVenta(Venta unaVenta);
	public Venta crearVenta();
	public Venta encontrarUnaVenta(int id) throws Exception;
	
}
