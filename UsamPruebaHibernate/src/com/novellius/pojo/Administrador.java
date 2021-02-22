package com.novellius.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "administrador")
@XmlRootElement
public class Administrador implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idAd")
	private Integer idAd;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 80)
	@Column(name = "nombre")
	private String nombre;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "cargo")
	private String cargo;
	@Basic(optional = false)
	@NotNull
	@Column(name = "fechaCreacion")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date fechaCreacion;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idAd")
	private List<Direccion> direccionList;

	public Administrador() {
	}

	public Administrador(Integer idAd) {
		this.idAd = idAd;
	}

	public Administrador(Integer idAd, String nombre, String cargo, Date fechaCreacion) {
		this.idAd = idAd;
		this.nombre = nombre;
		this.cargo = cargo;
		this.fechaCreacion = fechaCreacion;
	}

	public Integer getIdAd() {
		return idAd;
	}

	public void setIdAd(Integer idAd) {
		this.idAd = idAd;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@XmlTransient
	public List<Direccion> getDireccionList() {
		return direccionList;
	}

	public void setDireccionList(List<Direccion> direccionList) {
		this.direccionList = direccionList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAd == null) ? 0 : idAd.hashCode());
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
		Administrador other = (Administrador) obj;
		if (idAd == null) {
			if (other.idAd != null)
				return false;
		} else if (!idAd.equals(other.idAd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Administrador [idAd=" + idAd + ", nombre=" + nombre + ", cargo=" + cargo + ", fechaCreacion="
				+ fechaCreacion + ", direccionList=" + direccionList + "]";
	}
}
