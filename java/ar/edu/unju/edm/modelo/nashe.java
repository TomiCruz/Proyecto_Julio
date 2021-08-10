package ar.edu.unju.edm.modelo;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Entity
@Component
public class Venta implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1626101561822049027L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idVenta;
	
	@ManyToOne(cascade = CascadeType.ALL)	
	@JoinColumn(name = "idProducto")
    private Producto producto;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaVenta;
	
	@Column
    private Integer cantidad;
	
	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Venta(Integer idVenta, Producto producto, Usuario usuario, LocalDate fechaVenta, Integer cantidad) {
		super();
		this.idVenta = idVenta;
		this.producto = producto;
		this.usuario = usuario;
		this.fechaVenta = fechaVenta;
		this.cantidad = cantidad;
	}



	
	public Integer getIdVenta() {
		return idVenta;
	}



	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}



	public Producto getProducto() {
		return producto;
	}



	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	public Usuario getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}



	public LocalDate getFechaVenta() {
		return fechaVenta;
	}



	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}



	public Integer getCantidad() {
		return cantidad;
	}



	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}



	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantidad == null) ? 0 : cantidad.hashCode());
		result = prime * result + ((fechaVenta == null) ? 0 : fechaVenta.hashCode());
		result = prime * result + ((idVenta == null) ? 0 : idVenta.hashCode());
		result = prime * result + ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venta other = (Venta) obj;
		if (cantidad == null) {
			if (other.cantidad != null)
				return false;
		} else if (!cantidad.equals(other.cantidad))
			return false;
		if (fechaVenta == null) {
			if (other.fechaVenta != null)
				return false;
		} else if (!fechaVenta.equals(other.fechaVenta))
			return false;
		if (idVenta == null) {
			if (other.idVenta != null)
				return false;
		} else if (!idVenta.equals(other.idVenta))
			return false;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Venta [idVenta=" + idVenta + ", producto=" + producto + ", usuario=" + usuario + ", fechaVenta="
				+ fechaVenta + ", cantidad=" + cantidad + "]";
	}



	

	
}

