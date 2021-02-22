
package com.boot.models;

import java.util.Date;

import com.boot.entities.Note;

//entidad clon
public class NoteM {
	// atributos clones
	private Integer id;
	private int idEvaluation;
	private int idStudent;
	private Double score;
	private Boolean state;
	private Date dateCreation;
	private Date dateMerge;
	private Date dateRemoved;

	public NoteM() {
	}

	// constructor a partir de la entidad real
	public NoteM(Note note) {
		this.id = note.getId();
		this.idEvaluation = note.getIdEvaluation().getId();
		this.idStudent = note.getIdStudent().getId();
		this.score = note.getScore();
		this.state = note.getState();
		this.dateCreation = note.getDateCreation();
		this.dateMerge = note.getDateMerge();
		this.dateRemoved = note.getDateRemoved();
	}

	public NoteM(Integer id) {
		this.id = id;
	}

	public NoteM(Integer id, int idEvaluation, int idStudent, Double score, Boolean state, Date dateCreation,
			Date dateMerge, Date dateRemoved) {
		this.id = id;
		this.idEvaluation = idEvaluation;
		this.idStudent = idStudent;
		this.score = score;
		this.state = state;
		this.dateCreation = dateCreation;
		this.dateMerge = dateMerge;
		this.dateRemoved = dateRemoved;
	}

	// getters y setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getIdEvaluation() {
		return idEvaluation;
	}

	public void setIdEvaluation(int idEvaluation) {
		this.idEvaluation = idEvaluation;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
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
		NoteM other = (NoteM) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "NoteM [id=" + id + ", idEvaluation=" + idEvaluation + ", idStudent=" + idStudent + ", score=" + score
				+ ", state=" + state + ", dateCreation=" + dateCreation + ", dateMerge=" + dateMerge + ", dateRemoved="
				+ dateRemoved + "]";
	}
}
