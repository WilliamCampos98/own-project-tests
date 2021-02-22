package com.novellius.dao;

import java.util.List;

import com.novellius.pojo.Direccion;

public interface DireccionDao {

	public Direccion saveDireccion(Direccion direccion);

	public List<Direccion> findAllDireccions();

	public Direccion findByIdDireccion(int id);

	public void deleteDireccion(int id);
}
