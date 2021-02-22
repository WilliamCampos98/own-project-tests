package com.boot.client.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.boot.client.ClientSubject;
import com.boot.client.ClientResponseObject;
import com.boot.client.ClientStudent;

@FeignClient(name = "STUDENT-API",path="/studentApi",url = "${app.user.url}")
public interface SubjectService {

	@GetMapping(value = "/allSubjects")
	public List<ClientSubject> findAll();

	@GetMapping(value = "/allStudents")
	public List<ClientStudent> findAllStudents();

	@PostMapping(value = "/save")
	public ClientStudent save(@RequestBody ClientStudent student);

	@PutMapping(value = "/update")
	public ClientResponseObject update(@RequestBody ClientStudent student);

	@DeleteMapping(value = "/delete/{id}")
	public ClientResponseObject delete(@PathVariable("id") Integer id);

	@GetMapping(value = "/find/{id}")
	public ClientResponseObject findById(@PathVariable("id") Integer id);

	@GetMapping(value = "/all")
	public ClientResponseObject findAllStudent();
}
