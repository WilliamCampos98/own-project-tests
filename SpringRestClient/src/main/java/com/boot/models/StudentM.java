
package com.boot.models;

import java.util.Date;
import java.util.List;

import com.boot.entities.Student;

//entidad clon
public class StudentM {
	// atributos
	private Integer id;
	private String nie;
	private String firstName;
	private String secondName;
	private String surname;
	private String secondSurname;
	private Date dateBirth;
	private Boolean state;
	private Date dateCreation;
	private Date dateMerge;
	private Date dateRemoved;
	private List<NoteM> noteList;

	public StudentM() {
	}

	public StudentM(Integer id) {
		this.id = id;
	}

	public StudentM(Integer id, String nie, String firstName, String secondName, String surname, String secondSurname,
			Date dateBirth, Boolean state, Date dateCreation, Date dateMerge, Date dateRemoved, List<NoteM> noteList) {
		this.id = id;
		this.nie = nie;
		this.firstName = firstName;
		this.secondName = secondName;
		this.surname = surname;
		this.secondSurname = secondSurname;
		this.dateBirth = dateBirth;
		this.state = state;
		this.dateCreation = dateCreation;
		this.dateMerge = dateMerge;
		this.dateRemoved = dateRemoved;
		this.noteList = noteList;
	}

	// constructor a partir de la entidad real
	public StudentM(Student student) {
		this.id = student.getId();
		this.nie = student.getNie();
		this.firstName = student.getFirstName();
		this.secondName = student.getSecondName();
		this.surname = student.getSurname();
		this.secondSurname = student.getSecondSurname();
		this.dateBirth = student.getDateBirth();
		this.state = student.getState();
		this.dateCreation = student.getDateCreation();
		this.dateMerge = student.getDateMerge();
		this.dateRemoved = student.getDateRemoved();
	}

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

	public List<NoteM> getNoteList() {
		return noteList;
	}

	public void setNoteList(List<NoteM> noteList) {
		this.noteList = noteList;
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
		StudentM other = (StudentM) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentM [id=" + id + ", nie=" + nie + ", firstName=" + firstName + ", secondName=" + secondName
				+ ", surname=" + surname + ", secondSurname=" + secondSurname + ", dateBirth=" + dateBirth + ", state="
				+ state + ", dateCreation=" + dateCreation + ", dateMerge=" + dateMerge + ", dateRemoved=" + dateRemoved
				+ ", getId()=" + getId() + ", getNie()=" + getNie() + ", getFirstName()=" + getFirstName()
				+ ", getSecondName()=" + getSecondName() + ", getSurname()=" + getSurname() + ", getSecondSurname()="
				+ getSecondSurname() + ", getDateBirth()=" + getDateBirth() + ", getState()=" + getState()
				+ ", getDateCreation()=" + getDateCreation() + ", getDateMerge()=" + getDateMerge()
				+ ", getDateRemoved()=" + getDateRemoved() + ", hashCode()=" + hashCode() + ", getClass()=" + getClass()
				+ ", toString()=" + super.toString() + "]";
	}
}
