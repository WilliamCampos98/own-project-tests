
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//entidad desde base de datos relacional
@Entity
@Table(name = "evaluation")
public class Evaluation implements Serializable {
	// atributos
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 50)
	@Column(name = "name")
	private String name;
	@Size(max = 250)
	@Column(name = "description")
	private String description;
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
	@JoinColumn(name = "id_subject", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Subject idSubject;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idEvaluation")
	private List<Note> noteList;

	// constructor
	public Evaluation() {
	}

	public Evaluation(Integer id) {
		this.id = id;
	}

	public Evaluation(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	// getters y setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public Subject getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(Subject idSubject) {
		this.idSubject = idSubject;
	}

	public List<Note> getNoteList() {
		return noteList;
	}

	public void setNoteList(List<Note> noteList) {
		this.noteList = noteList;
	}

	// metodos
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Evaluation)) {
			return false;
		}
		Evaluation other = (Evaluation) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.boot.entities.Evaluation[ id=" + id + " ]";
	}
}
