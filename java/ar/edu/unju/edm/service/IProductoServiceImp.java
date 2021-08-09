package ar.edu.unju.edm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.Producto;
import ar.edu.unju.edm.modelo.Usuario;
import ar.edu.unju.edm.repository.IProductoRepository;

@Service
public class IProductoServiceImp implements IProductoService{

	@Autowired
	IProductoRepository iProducto;
	private List<Producto> proAux = new ArrayList<>();
	@Override
	public void guardar(Producto unProducto) {
		// TODO Auto-generated method stub
		iProducto.save (unProducto);
		proAux.add (unProducto);
	}
	@Override
	public Producto encontrarProducto(Long id) throws Exception {
		// TODO Auto-generated method stub
		return iProducto.findById(id).orElseThrow(() -> new Exception("Error"));
	}
	
	@Override
	public List<Producto> listarProducto() {
		return iProducto.findAll();//listado de todos los productos
	}

	@Override
	public void eliminar(Long id) {
		iProducto.deleteById(id);
	}
	
	@Override
	public Producto modificar(Producto unaProducto) throws Exception {
		Producto ProductoB = iProducto.findByCodigo(unaProducto.getCodigo()).orElseThrow(()->new Exception("El producto no fue encontrado"));;
		mapearProducto(unaProducto, ProductoB);
		return iProducto.save(ProductoB);
	}
	//Long id, String nombre, String codigo, Float precio, Float disponibilidad
	public void mapearProducto(Producto desde,Producto hacia) {
	//	hacia.setId(desde.getId());
		hacia.setNombre(desde.getNombre());
		//hacia.setCodigo(desde.getCodigo());
		hacia.setPrecio(desde.getPrecio());
		hacia.setDisponibilidad(desde.getDisponibilidad());
	}
	
		@Override
	public Producto buscarProducto(String nombre) throws Exception {
	return iProducto.findByCodigo(nombre).orElseThrow(()-> new Exception("La producto no existe en la base de datos")) ;
	}
		
		
		public List<Producto> obtenerTodosProductos() {
			// TODO Auto-generated method stub
			return (List<Producto>) iProducto.findAll();
		}
	
		
		@Override
		public Producto encontrarUnProducto(String codigo) throws Exception {
			// TODO Auto-generated method stub
			return iProducto.findByCodigo(codigo).orElseThrow(() -> new Exception("Error"));
		}
		
}

