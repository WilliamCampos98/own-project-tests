
package com.boot.models;

import java.util.Date;

import com.boot.entities.Evaluation;

//Informacion: Esta xona esta dedicada a los modelos de las entidades relaciones debido
//a que las entidades realacionales no se trabajan directamente debido a que sus relaciones
//causan bugs esto es similar a crear una plantilla de reportes
public class EvaluationM {

	// atributos clones de las entidades reales
	private Integer id;
	private String name;
	private String description;
	private Boolean state;
	private Date dateCreation;
	private Date dateMerge;
	private Date dateRemoved;
	private Integer idSubject;

	// Nota: todas las entidades clon cuentan con este tipo de constructor con
	// excepcion de usuario y rols
	// constructor como parametro de entrada la entidad real para pasar el valor de
	// sus variables
	// de manera mas rapida y efectiva
	public EvaluationM(Evaluation evaluation) {
		this.id = evaluation.getId();
		this.name = evaluation.getName();
		this.description = evaluation.getDescription();
		this.state = evaluation.getState();
		this.dateCreation = evaluation.getDateCreation();
		this.dateMerge = evaluation.getDateMerge();
		this.dateRemoved = evaluation.getDateRemoved();
		this.idSubject = evaluation.getIdSubject().getId();
	}

	public EvaluationM(Integer id) {
		this.id = id;
	}

	// contructor comun con todos sus atributos
	public EvaluationM(Integer id, String name, String description, Boolean state, Date dateCreation, Date dateMerge,
			Date dateRemoved, Integer idSubject) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.state = state;
		this.dateCreation = dateCreation;
		this.dateMerge = dateMerge;
		this.dateRemoved = dateRemoved;
		this.idSubject = idSubject;
	}

	// getters and setters
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

	public Integer getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(Integer idSubject) {
		this.idSubject = idSubject;
	}

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
		EvaluationM other = (EvaluationM) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EvaluationM [id=" + id + ", name=" + name + ", description=" + description + ", state=" + state
				+ ", dateCreation=" + dateCreation + ", dateMerge=" + dateMerge + ", dateRemoved=" + dateRemoved
				+ ", idSubject=" + idSubject + "]";
	}
}
