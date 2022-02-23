package com.ceiba.cliente.adaptador.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.modelo.enumeracion.EnumeracionTipoCliente;
import com.ceiba.infraestructura.jdbc.MapperResult;

public class MapeoCliente implements RowMapper<DtoCliente>, MapperResult {

	@Override
	public DtoCliente mapRow(ResultSet resultSet, int rowNum) throws SQLException {

		Long id = resultSet.getLong("id");
		String nombre = resultSet.getString("nombre");
		EnumeracionTipoCliente tipoCliente = EnumeracionTipoCliente
				.obtenerEnumeracionTipoClienteDeCodigo(resultSet.getInt("tipo_cliente"));

		return new DtoCliente(id, nombre, tipoCliente);
	}

}
