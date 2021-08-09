package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.Producto;

@Service
public interface IProductoService {

	public void guardar(Producto unaProducto);
	public List<Producto> listarProducto();
	public void eliminar(Long id);
	public Producto modificar(Producto unaProducto) throws Exception;
	public Producto encontrarProducto(Long id) throws Exception;
	public Producto buscarProducto(String nombre) throws Exception;
	public List<Producto> obtenerTodosProductos();
	public Producto encontrarUnProducto(String codigo) throws Exception;
	
	
	
	
}
