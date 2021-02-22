package com.novellius.pojo;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class AdminRowMapper implements RowMapper<Administrador>{

	@Override
	public Administrador mapRow(ResultSet rs, int rowNum) throws SQLException {
		Administrador admin = new Administrador();
		
		admin.setIdAd(rs.getInt("idAd"));
		admin.setCargo(rs.getString("cargo"));
		admin.setFechaCreacion(rs.getTimestamp("fechaCreacion"));
		admin.setNombre(rs.getString("nombre"));
		
		return admin;
	}

}
