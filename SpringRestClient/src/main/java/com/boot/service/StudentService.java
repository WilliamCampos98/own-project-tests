package com.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.boot.entities.Student;
import com.boot.repo.StudentRepo;

//servicio de repositoprio de estudiante
@Service
public class StudentService {
	// repositorio de estudiante
	@Autowired
	private StudentRepo repo;
	// lista y entidad
	private Student students;
	private List<Student> listStudent;

	// metodos convencionales de un crud
	public Student save(Student student) {
		try {
			students = repo.save(student);
			return students;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Boolean delete(int id) {
		try {
			students = repo.findById(id).get();
			repo.delete(students);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Student> findAll(Pageable pageable) {
		try {
			listStudent = new ArrayList<Student>();
			listStudent = repo.findAll(pageable).getContent();
			return listStudent;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Student findById(int id) {
		try {
			students = repo.findById(id).get();
			return students;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
