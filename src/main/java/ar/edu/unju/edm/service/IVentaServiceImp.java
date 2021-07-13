package ar.edu.unju.edm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.Venta;
import ar.edu.unju.edm.repository.IVentaRepository;

@Service
public class IVentaServiceImp implements IVentaService{

	@Autowired
	Venta venta;

	@Autowired
	IVentaRepository iVenta;

	@Override
	public void guardarVenta(Venta unaVenta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Venta crearVenta() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venta encontrarUnaVenta(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
}
