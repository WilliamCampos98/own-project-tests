
package com.boot.models;

import java.util.Date;
import java.util.List;

import com.boot.entities.Subject;
import com.fasterxml.jackson.annotation.JsonProperty;

//entidad clon
public class SubjectM {
	// atributos clon
	private Integer id;
	private String name;
	private Boolean state;
	private Date dateCreation;
	private Date dateMerge;
	private Date dateRemoved;
	@JsonProperty("Evaluaciones")
	private List<EvaluationM> evaluationList;

	public SubjectM() {
	}

	public SubjectM(Subject subject) {
		this.id = subject.getId();
		this.name = subject.getName();
		this.state = subject.getState();
		this.dateCreation = subject.getDateCreation();
		this.dateMerge = subject.getDateMerge();
		this.dateRemoved = subject.getDateRemoved();
	}

	// constructor a partir de la entidad real
	public SubjectM(Integer id, String name, Boolean state, Date dateCreation, Date dateMerge, Date dateRemoved) {
		this.id = id;
		this.name = name;
		this.state = state;
		this.dateCreation = dateCreation;
		this.dateMerge = dateMerge;
		this.dateRemoved = dateRemoved;
	}

	// getters y setters
	public SubjectM(Integer id) {
		this.id = id;
	}

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

	public List<EvaluationM> getEvaluationList() {
		return evaluationList;
	}

	public void setEvaluationList(List<EvaluationM> evaluationList) {
		this.evaluationList = evaluationList;
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
		SubjectM other = (SubjectM) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SubjectM [id=" + id + ", name=" + name + ", state=" + state + ", dateCreation=" + dateCreation
				+ ", dateMerge=" + dateMerge + ", dateRemoved=" + dateRemoved + ", evaluationList=" + evaluationList
				+ "]";
	}
}
