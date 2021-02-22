package com.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.entities.Users;
import com.boot.repo.UserRepo;

//service de repositorio de usuario
@Service
public class UserService {
	// Repositorio de usuario
	@Autowired
	private UserRepo repo;
	// lista y entidades
	private List<Users> listUsuarios;
	private Users usuario;

	// metodos convencionales de crud
	public Users saveUsuario(Users user) {
		try {
			usuario = new Users();
			usuario = repo.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return usuario;
	}

	public Users findById(int id) {
		try {
			usuario = repo.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return usuario;
	}

	public Boolean deleteUsuario(Integer id) {
		try {
			usuario = new Users();
			usuario = repo.findById(id).get();
			repo.delete(usuario);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Users> findAll() {
		try {
			listUsuarios = new ArrayList<>();
			listUsuarios = repo.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return listUsuarios;
	}
}
