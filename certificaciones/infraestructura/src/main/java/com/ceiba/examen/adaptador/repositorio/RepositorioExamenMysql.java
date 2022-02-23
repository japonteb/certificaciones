package com.ceiba.examen.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.examen.modelo.entidad.Examen;
import com.ceiba.examen.puerto.repositorio.RepositorioExamen;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioExamenMysql implements RepositorioExamen {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="examen", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="examen", value="existe")
    private static String sqlExiste;

    public RepositorioExamenMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Examen examen) {
        return this.customNamedParameterJdbcTemplate.crear(examen, sqlCrear);
    }

    @Override
    public boolean existe(Long clienteId, Long certificacionId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("clienteId", clienteId);
        paramSource.addValue("certificacionId", certificacionId);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

}
