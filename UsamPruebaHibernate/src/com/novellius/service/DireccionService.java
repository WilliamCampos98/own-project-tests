package com.novellius.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novellius.dao.AdminDao;
import com.novellius.dao.DireccionDao;
import com.novellius.pojo.Administrador;
import com.novellius.pojo.Direccion;

@Service
public class DireccionService {
	@Autowired
	private DireccionDao direccionDao;

	public Direccion saveDireccion(Direccion direccion) {
		return direccionDao.saveDireccion(direccion);
	}

	public List<Direccion> findAllDireccions() {
		return direccionDao.findAllDireccions();
	}

	
	public Direccion findByIdDireccion(int id) {
		return direccionDao.findByIdDireccion(id);
	}
	
	public void deleteDireccion(int id) {
		direccionDao.deleteDireccion(id);
		}
	}