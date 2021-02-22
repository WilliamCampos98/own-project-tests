package com.novellius.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.novellius.dao.AdminDao;
import com.novellius.pojo.Administrador;

@Service
public class AdminService {

	@Autowired
	private AdminDao adminDao;

	public Administrador save(Administrador admin) {

		admin.setFechaCreacion(new Timestamp(new Date().getTime()));

		return adminDao.save(admin);
	}

	public List<Administrador> findAll() {

		return adminDao.findAll();
	}

	public Administrador findByid(int id) {

		return adminDao.findById(id);
	}

	public Administrador update(Administrador admin) {

		return adminDao.update(admin);
	}

	public void delete(int id) {
		adminDao.delete(id);
	}

}
