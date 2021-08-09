package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.Producto;
import ar.edu.unju.edm.modelo.Venta;
import ar.edu.unju.edm.repository.IProductoRepository;
import ar.edu.unju.edm.repository.IVentaRepository;

@Service
public class IVentaServiceImp implements IVentaService{

	@Autowired
	Venta venta;

	@Autowired
	IVentaRepository iVenta;

	@Autowired
	IProductoRepository iProducto;
	
	
	@Override
	public void guardarVenta(Venta unaVenta) {
		// TODO Auto-generated method stub
		iVenta.save(unaVenta);
	}

	@Override
	public Venta crearVenta() {
		// TODO Auto-generated method stub
		return venta;
	}

	@Override
	public Venta encontrarUnaVenta(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> listarVenta() {
		// TODO Auto-generated method stub
		return (List<Venta>) iVenta.findAll();//listado de todos los productos
	}
			
}