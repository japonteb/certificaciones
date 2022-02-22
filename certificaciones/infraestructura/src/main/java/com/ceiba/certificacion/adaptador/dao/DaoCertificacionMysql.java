package com.ceiba.certificacion.adaptador.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.certificacion.modelo.dto.DtoCertificacion;
import com.ceiba.certificacion.puerto.dao.DaoCertificacion;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DaoCertificacionMysql implements DaoCertificacion {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "certificacion", value = "listar")
	private static String sqlListar;

	public DaoCertificacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public List<DtoCertificacion> listar() {
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,
				new MapeoCertificacion());
	}
}
