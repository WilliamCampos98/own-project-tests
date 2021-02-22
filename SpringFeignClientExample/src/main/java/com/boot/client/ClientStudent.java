package com.boot.client;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "nie", "firstName", "secondName", "surname", "secondSurname", "dateBirth", "state",
		"dateCreation", "dateMerge", "dateRemoved", "noteList" })

public class ClientStudent {
	@JsonProperty("id")
	private Integer id;
	@JsonProperty("nie")
	private String nie;
	@JsonProperty("firstName")
	private String firstName;
	@JsonProperty("secondName")
	private String secondName;
	@JsonProperty("surname")
	private String surname;
	@JsonProperty("secondSurname")
	private String secondSurname;
	@JsonProperty("dateBirth")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateBirth;
	@JsonProperty("state")
	private Boolean state;
	@JsonProperty("dateCreation")
	private Date dateCreation;
	@JsonProperty("dateMerge")
	private Date dateMerge;
	@JsonProperty("dateRemoved")
	private Date dateRemoved;
	@JsonProperty("noteList")
	private List<Object> noteList;

	// constructor
	public ClientStudent() {
	}

	public ClientStudent(Integer id) {
		this.id = id;
	}

	public ClientStudent(Integer id, String nie, String firstName, String secondName, String surname,
			String secondSurname, Date dateBirth) {
		this.id = id;
		this.nie = nie;
		this.firstName = firstName;
		this.secondName = secondName;
		this.surname = surname;
		this.secondSurname = secondSurname;
		this.dateBirth = dateBirth;
	}

	// getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNie() {
		return nie;
	}

	public void setNie(String nie) {
		this.nie = nie;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getSecondSurname() {
		return secondSurname;
	}

	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}

	public Date getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Date dateBirth) {
		this.dateBirth = dateBirth;
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
		if (!(object instanceof ClientStudent)) {
			return false;
		}
		ClientStudent other = (ClientStudent) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.boot.entities.Student[ id=" + id + " ]";
	}
}
