package com.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entities.Note;
import com.boot.repo.NoteRepo;

//servicio del repositorio de notas
@Service
public class NoteService {
	// repositorio de notas autowired para que el framework me de una instancia
	@Autowired
	private NoteRepo repo;
	// entidad y listas
	private List<Note> listNotes;
	private Note notes;

	// metodo con validaciones leves de errores para guardar
	// se podria mejorar cada uno
	public Note create(Note note) {
		try {
			notes = repo.save(note);
			return notes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// metodo de borrado por id
	public Boolean delete(Integer id) {
		try {
			// aunquen se puede borrar por id utilice la entidad completa
			// primero la consulto por id el metodo devuelve un Optional<Entidad>
			// aunque le pido que me devuelva directamnete la entidad
			notes = repo.findById(id).get();
			// cuando la tengo la borro y devueleve un true si falla un false e imprime el
			// error
			repo.delete(notes);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	// enontrar por id
	public Note find(Integer id) {
		try {
			notes = repo.findById(id).get();
			return notes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// litar todos los rsultados en una lista
	public List<Note> findAll() {
		try {
			listNotes = new ArrayList<Note>();
			listNotes = repo.findAll();
			return listNotes;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
