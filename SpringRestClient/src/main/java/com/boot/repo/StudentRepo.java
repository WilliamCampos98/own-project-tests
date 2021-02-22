package com.boot.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entities.Student;

//interfaz de entidad con las herencia de jpaRepository<Aqui se indica la entidad, Aqui el tipo de llave primaria>
@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

	public abstract Page<Student> findAll(Pageable pageable);
}
