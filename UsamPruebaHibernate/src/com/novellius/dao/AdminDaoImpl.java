package com.novellius.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.novellius.pojo.Administrador;

@SuppressWarnings("unchecked")
@Transactional
@Repository
public class AdminDaoImpl implements AdminDao {

	private List<Administrador> listAdmin;
	private Administrador administrador;
	@Autowired
	private SessionFactory session;

	public Session getSession() {
		return session.getCurrentSession();
	}

	@Override
	public Administrador save(Administrador admin) {
		try {
			getSession().save(admin);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return admin;
	}

	@Override
	public Administrador update(Administrador admin) {
		try {
			/*
			 * metodo de update, agregado existe un metodo llamado saveOrUpdate sí, el
			 * objeto no existe lo creara
			 */
			getSession().saveOrUpdate(admin);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return admin;
	}

	@Override
	public List<Administrador> findAll() {
		try {
			/*
			 * lenguaje HQL es lenguaje sql simplificado de hibernate su equivalencia es:
			 * select * from administradores
			 */
			listAdmin = new ArrayList<Administrador>();
			Query query = getSession().createQuery("from Administrador");
			listAdmin = query.list();
		} catch (Exception e) {
			return null;
		}
		return listAdmin;
	}

	@Override
	public List<Administrador> findByNombre(String nombre) {
		try {
			/*
			 * lenguaje HQL en esta consulta lleno la lista por nombre similares al
			 * parametro que le pase al query de criteria
			 */
			listAdmin = new ArrayList<Administrador>();
			Criteria c = getSession().createCriteria(Administrador.class);
			c.add(Restrictions.like("nombre", "%" + nombre + "%"));
			listAdmin = c.list();
		} catch (Exception e) {
			return null;
		}
		return listAdmin;
	}

	@Override
	public Administrador findById(int id) {
		try {
			/*
			 * criteria de hibernate me devuelve una entidad de tipo admin es nuestro find
			 * by id de jpa
			 */
			administrador = new Administrador();
			Criteria c = getSession().createCriteria(Administrador.class);
			c.add(Restrictions.eq("idAd", id));
			administrador = (Administrador) c.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return administrador;
	}

	@Override
	public void delete(int id) {
		try {
			/*
			 * Hibernate trabaja con entidades no con id asi que es necesario consultar
			 * primero para posteriormente borrar
			 */
			administrador = new Administrador();
			administrador = findById(id);
			getSession().delete(administrador);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
