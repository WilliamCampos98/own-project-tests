
package com.boot.client;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "description", "state", "dateCreation", "dateMerge", "dateRemoved", "idSubject",
		"noteList" })
public class ClientEvaluation {
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@JsonProperty("state")
	private Boolean state;
	@JsonProperty("dateCreation")
	private Date dateCreation;
	@JsonProperty("dateMerge")
	private Date dateMerge;
	@JsonProperty("dateRemoved")
	private Date dateRemoved;
	@JsonProperty("idSubject")
	private ClientSubject idSubject;
	@JsonProperty("noteList")
	private List<Object> noteList;

	public ClientEvaluation() {
	}

	public ClientEvaluation(Integer id) {
		this.id = id;
	}

	public ClientEvaluation(Integer id, String name) {
		this.id = id;
		this.name = name;
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

	public ClientSubject getIdSubject() {
		return idSubject;
	}

	public void setIdSubject(ClientSubject idSubject) {
		this.idSubject = idSubject;
	}

	public List<Object> getNoteList() {
		return noteList;
	}

	public void setNoteList(List<Object> noteList) {
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
		if (!(object instanceof ClientEvaluation)) {
			return false;
		}
		ClientEvaluation other = (ClientEvaluation) object;
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
