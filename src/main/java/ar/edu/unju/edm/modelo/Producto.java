package ar.edu.unju.edm.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;


@Entity
@Component
public class Producto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID= 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@GenericGenerator(name="native",strategy="native")
	@Id
	private Long id;
	@Column
	private String nombre;
	@Column
	private String codigo;
	@Column
	private Float precio;
	@Column
	private Float disponibilidad;
	@Column
    private Integer cantProductos;

	public Producto() {
		
	}
	

	public Producto(Long id, String nombre, String codigo, Float precio, Float disponibilidad, Integer cantProductos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.disponibilidad = disponibilidad;
		this.cantProductos = cantProductos;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public Float getPrecio() {
		return precio;
	}


	public void setPrecio(Float precio) {
		this.precio = precio;
	}


	public Float getDisponibilidad() {
		return disponibilidad;
	}


	public void setDisponibilidad(Float disponibilidad) {
		this.disponibilidad = disponibilidad;
	}


	public Integer getCantProductos() {
		return cantProductos;
	}


	public void setCantProductos(Integer cantProductos) {
		this.cantProductos = cantProductos;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cantProductos == null) ? 0 : cantProductos.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((disponibilidad == null) ? 0 : disponibilidad.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
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
		Producto other = (Producto) obj;
		if (cantProductos == null) {
			if (other.cantProductos != null)
				return false;
		} else if (!cantProductos.equals(other.cantProductos))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (disponibilidad == null) {
			if (other.disponibilidad != null)
				return false;
		} else if (!disponibilidad.equals(other.disponibilidad))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", precio=" + precio
				+ ", disponibilidad=" + disponibilidad + ", cantProductos=" + cantProductos + "]";
	}




	
}
