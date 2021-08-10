package ar.edu.unju.edm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.modelo.Compra;
import ar.edu.unju.edm.modelo.Usuario;
import ar.edu.unju.edm.repository.ICompraRepository;


@Service
public class ICompraServiceImp implements ICompraService {

	@Autowired
	ICompraRepository iCompraDAO;
	@Autowired
	Compra compra;
	@Autowired
	Usuario usuario;
	
	@Override
	public Compra guardarCompra(Compra compra) {
		return iCompraDAO.save(compra);
	}
	
	@Override
	public List<Compra> listarCompras() {
		return (List<Compra>) iCompraDAO.findAll();
	}

	@Override
	public void eliminarCompra(Long compra) {
		iCompraDAO.deleteById(compra);
	}

	@Override
	public Iterable<Compra> buscarCompraPorUsuario(Usuario usuario) {
		return iCompraDAO.findByUsuario(usuario);
	}

}
