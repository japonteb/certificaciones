package com.ceiba.examen.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.examen.modelo.dto.DtoExamenCertificacion;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoExamenCertificacion implements RowMapper<DtoExamenCertificacion>, MapperResult {

	@Override
	public DtoExamenCertificacion mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long id = resultSet.getLong("id");
		String nombre = resultSet.getString("nombre");
		String detalle = resultSet.getString("detalle");
		LocalDateTime fechaPresentacion = extraerLocalDateTime(resultSet, "fecha_presentacion");
		Double precioTotal = resultSet.getDouble("precio_total");

		return new DtoExamenCertificacion(id, nombre, detalle, fechaPresentacion, precioTotal);
	}

}
