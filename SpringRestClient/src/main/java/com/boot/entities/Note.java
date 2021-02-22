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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

//entidad desde base de datos
@Entity
@Table(name = "note")
public class Note implements Serializable {

	// atributos
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id")
	private Integer id;
	@Max(value = (long) 10.00)
	@Min(value = (long) 02.00)
	@Column(name = "score")
	private Double score;
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
	@JoinColumn(name = "id_evaluation", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Evaluation idEvaluation;
	@JoinColumn(name = "id_student", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Student idStudent;

	// constructor
	public Note() {
	}

	public Note(Integer id) {
		this.id = id;
	}

	// getters y setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
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

	public Evaluation getIdEvaluation() {
		return idEvaluation;
	}

	public void setIdEvaluation(Evaluation idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	public Student getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Student idStudent) {
		this.idStudent = idStudent;
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
		if (!(object instanceof Note)) {
			return false;
		}
		Note other = (Note) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.boot.entities.Note[ id=" + id + " ]";
	}
}
