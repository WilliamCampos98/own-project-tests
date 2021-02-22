
package com.boot.entities;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//entidad desde base de datos
@Entity
@Table(name = "role")
public class Role implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 25)
	@Column(name = "rol")
	private String rol;
	@Column(name = "state")
	private Boolean state;
	@Column(name = "date_creation")
	@Temporal(TemporalType.DATE)
	private Date dateCreation;
	@Column(name = "date_merge")
	@Temporal(TemporalType.DATE)
	private Date dateMerge;
	@Column(name = "date_removed")
	@Temporal(TemporalType.DATE)
	private Date dateRemoved;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idRole")
	private List<Users> usersList;

	// constructor
	public Role() {
	}

	public Role(Integer id) {
		this.id = id;
	}

	public Role(Integer id, String rol) {
		this.id = id;
		this.rol = rol;
	}

	// getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateMerge() {
		return dateMerge;
	}

	public void setDateMerge(Date dateMerge) {
		this.dateMerge = dateMerge;
	}

	public Date getDateRemoved() {
		return dateRemoved;
	}

	public void setDateRemoved(Date dateRemoved) {
		this.dateRemoved = dateRemoved;
	}

	public List<Users> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<Users> usersList) {
		this.usersList = usersList;
	}

	// metodos
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Role other = (Role) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", rol=" + rol + ", state=" + state + ", dateCreation=" + dateCreation
				+ ", dateMerge=" + dateMerge + ", dateRemoved=" + dateRemoved + ", usersList=" + usersList
				+ ", getId()=" + getId() + ", getRol()=" + getRol() + ", getState()=" + getState()
				+ ", getDateCreation()=" + getDateCreation() + ", getDateMerge()=" + getDateMerge()
				+ ", getDateRemoved()=" + getDateRemoved() + ", getUsersList()=" + getUsersList() + ", hashCode()="
				+ hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString() + "]";
	}
}
