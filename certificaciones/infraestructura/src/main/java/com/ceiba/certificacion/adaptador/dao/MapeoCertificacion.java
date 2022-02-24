package com.ceiba.certificacion.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.certificacion.modelo.dto.DtoCertificacion;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoCertificacion implements RowMapper<DtoCertificacion>, MapperResult {

	@Override
	public DtoCertificacion mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long id = resultSet.getLong("id");
		String nombre = resultSet.getString("nombre");
		String detalle = resultSet.getString("detalle");
		Integer duracion = resultSet.getInt("duracion");
		Double precio = resultSet.getDouble("precio");

		return new DtoCertificacion(id, nombre, detalle, duracion, precio);
	}

}
