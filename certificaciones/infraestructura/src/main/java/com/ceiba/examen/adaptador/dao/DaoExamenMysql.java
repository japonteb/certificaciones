package com.ceiba.examen.adaptador.dao;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import com.ceiba.examen.modelo.dto.DtoExamenCertificacion;
import com.ceiba.examen.puerto.dao.DaoExamen;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

@Component
public class DaoExamenMysql implements DaoExamen {

	private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

	@SqlStatement(namespace = "examen", value = "listarPorClienteId")
	private static String sqlListarExamenPorClienteId;

	public DaoExamenMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
		this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
	}

	@Override
	public List<DtoExamenCertificacion> listarPorClienteId(Long clientId) {
		
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("clienteId", clientId);
        
		return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarExamenPorClienteId,
				paramSource, new MapeoExamenCertificacion());
	}

}
