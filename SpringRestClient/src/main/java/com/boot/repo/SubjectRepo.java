package com.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.entities.Subject;

//interfaz de entidad con las herencia de jpaRepository<Aqui se indica la entidad, Aqui el tipo de llave primaria>
@Repository
public interface SubjectRepo extends JpaRepository<Subject, Integer> {

}
