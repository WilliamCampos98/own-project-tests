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

import com.novellius.pojo.Direccion;

@SuppressWarnings("unchecked")
@Transactional
@Repository
public class DireccionDaoImpl implements DireccionDao {

	@Autowired
	private SessionFactory sessionFactory;
	private Direccion direccion;
	private List<Direccion> listDireccions;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Direccion saveDireccion(Direccion direccion) {
		try {
			getSession().saveOrUpdate(direccion);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return direccion;
	}



	@Override
	public List<Direccion> findAllDireccions() {
		try {
			listDireccions = new ArrayList<Direccion>();
			Query query = getSession().createQuery("from Direccion");
			listDireccions = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return listDireccions;
	}

	public Direccion findByIdDireccion(int id) {
		try {
			direccion = new Direccion();
			Criteria c = getSession().createCriteria(Direccion.class);
			c.add(Restrictions.eq("idDir", id));
			direccion = (Direccion) c.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return direccion;
	}

	public void deleteDireccion(int id) {
		try {
			direccion = new Direccion();
			direccion = findByIdDireccion(id);
			getSession().delete(direccion);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
