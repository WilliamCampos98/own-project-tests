package com.boot.client;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "description", "state", "dateCreation", "dateMerge", "dateRemoved", "idSubject",
		"noteList" })
public class ClientNote {
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("score")
	private Double score;
	@JsonProperty("state")
	private Boolean state;
	@JsonProperty("dateCreation")
	private Date dateCreation;
	@JsonProperty("dateMerge")
	private Date dateMerge;
	@JsonProperty("dateRemoved")
	private Date dateRemoved;
	@JsonProperty("idEvaluation")
	private ClientEvaluation idEvaluation;
	@JsonProperty("idStudent")
	private ClientStudent idStudent;

	// constructor
	public ClientNote() {
	}

	public ClientNote(Integer id) {
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

	public ClientEvaluation getIdEvaluation() {
		return idEvaluation;
	}

	public void setIdEvaluation(ClientEvaluation idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	public ClientStudent getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(ClientStudent idStudent) {
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
		if (!(object instanceof ClientNote)) {
			return false;
		}
		ClientNote other = (ClientNote) object;
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
