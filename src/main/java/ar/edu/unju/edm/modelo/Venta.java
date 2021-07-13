package ar.edu.unju.edm.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

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
	
	@ManyToOne
	@JoinColumn(name = "idProducto")
    private List<Producto> productos;

	@ManyToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaVenta;
	
	@Column
    private float total;
	
	
	
	public Venta() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Venta(Integer idVenta, List<Producto> productos, Usuario usuario, LocalDate fechaVenta, float total) {
		super();
		this.idVenta = idVenta;
		this.productos = productos;
		this.usuario = usuario;
		this.fechaVenta = fechaVenta;
		this.total = total;
	}
	
	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
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


	public void setTotal(float total) {
		this.total = total;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaVenta == null) ? 0 : fechaVenta.hashCode());
		result = prime * result + ((idVenta == null) ? 0 : idVenta.hashCode());
		result = prime * result + ((productos == null) ? 0 : productos.hashCode());
		result = prime * result + Float.floatToIntBits(total);
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
		if (productos == null) {
			if (other.productos != null)
				return false;
		} else if (!productos.equals(other.productos))
			return false;
		if (Float.floatToIntBits(total) != Float.floatToIntBits(other.total))
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
		return "Venta [idVenta=" + idVenta + ", productos=" + productos + ", usuario=" + usuario + ", fechaVenta="
				+ fechaVenta + ", total=" + total + "]";
	}

	public Float getTotal() {
        float t =  0f;
        for (Producto producto : this.productos) {
            t += producto.getPrecio()*producto.getCantProductos();
        }
        return t;
    }
	
	
}

