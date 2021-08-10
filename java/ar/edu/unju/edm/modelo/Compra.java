package ar.edu.unju.edm.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table
public class Compra implements Serializable{
	
	/**
	 * 
	 */	
	private static final long serialVersionUID = 1L;
	 

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native", strategy="native")
	private Long idCompra;
	
	//mcuhas compra pueden ser realizadas por un usuario
	@ManyToOne
	@JoinColumn(name = "idProducto")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;
	
	@Column
    private Integer cantProductos;
	
	public Compra() {
		
	}

	public Compra(Long idCompra, Producto producto, Usuario usuario, Integer cantProductos) {
		super();
		this.idCompra = idCompra;
		this.producto = producto;
		this.usuario = usuario;
		this.cantProductos = cantProductos;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public Long getIdCompra() {
		return idCompra;
	}



	public Producto getProducto() {
		return producto;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public Integer getCantProductos() {
		return cantProductos;
	}



	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}


	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public void setCantProductos(Integer cantProductos) {
		this.cantProductos = cantProductos;
	}


}