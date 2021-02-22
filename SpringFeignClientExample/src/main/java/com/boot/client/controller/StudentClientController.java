package com.boot.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.client.ClientResponseObject;
import com.boot.client.ClientStudent;
import com.boot.client.ClientSubject;
import com.boot.client.service.SubjectService;

@RestController
@RequestMapping("/studentClient")
public class StudentClientController {

	@Autowired
	private SubjectService service;

	@GetMapping(value = "/allSubjects", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClientSubject> findAll() {
		try {
			return service.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClientStudent> findAllStudents() {
		try {
			return service.findAllStudents();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PostMapping(value = "/saveStudent", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ClientStudent save(@RequestHeader(value = "Authorization", required = false) String token,
			@RequestBody ClientStudent students) {
		try {
			System.out.println(token);
			return service.save(students);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping(value = "/findByid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientResponseObject findById(@PathVariable("id") Integer ids) {
		try {
			System.out.println("Mira el id" + ids);
			return service.findById(ids);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@DeleteMapping(value = "/deleteByid/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ClientResponseObject deleteById(@PathVariable("id") Integer id) {
		try {
			return service.delete(id);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClientResponseObject allStudents() {
		try {
			return service.findAllStudent();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ClientResponseObject update(@RequestBody ClientStudent clientStudent) {
		try {
			return service.update(clientStudent);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
