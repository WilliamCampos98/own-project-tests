package com.boot.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//entidad de usuario unicamnte para logueo de spring security
//esta entidad se adapto a la forma de diseño de las demas tablas
@Entity
@Table(name = "users")
public class Users implements Serializable {
	// atributos
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 40)
	@Column(name = "user")
	private String user;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 100)
	@Column(name = "pass")
	private String pass;
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
	@JoinColumn(name = "id_role", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Role idRole;

	// construtor
	public Users() {
	}

	public Users(Integer id) {
		this.id = id;
	}

	public Users(Integer id, String user, String pass) {
		this.id = id;
		this.user = user;
		this.pass = pass;
	}

	public Users(Integer id, @NotNull @Size(min = 1, max = 40) String user,
			@NotNull @Size(min = 1, max = 100) String pass, Boolean state, Date dateCreation, Date dateMerge,
			Date dateRemoved, Role idRole) {
		this.id = id;
		this.user = user;
		this.pass = pass;
		this.state = state;
		this.dateCreation = dateCreation;
		this.dateMerge = dateMerge;
		this.dateRemoved = dateRemoved;
		this.idRole = idRole;
	}

	// getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
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

	public Role getIdRole() {
		return idRole;
	}

	public void setIdRole(Role idRole) {
		this.idRole = idRole;
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
		Users other = (Users) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", user=" + user + ", pass=" + pass + ", state=" + state + ", dateCreation="
				+ dateCreation + ", dateMerge=" + dateMerge + ", dateRemoved=" + dateRemoved + ", idRole=" + idRole
				+ "]";
	}
}
