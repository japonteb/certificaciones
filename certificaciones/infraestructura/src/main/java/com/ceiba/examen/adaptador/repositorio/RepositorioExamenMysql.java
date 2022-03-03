package com.ceiba.examen.adaptador.repositorio;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import com.ceiba.examen.modelo.entidad.Examen;
import com.ceiba.examen.puerto.repositorio.RepositorioExamen;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

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
    public void crear(Examen examen) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("clienteId", examen.getCliente().getId());
        paramSource.addValue("certificacionId", examen.getCertificacion().getId());
        paramSource.addValue("fechaPresentacion", examen.getFechaPresentacion());
        paramSource.addValue("precioTotal", examen.getPrecioTotal());
        
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlCrear, paramSource);
        
    }

    @Override
    public boolean existe(Long clienteId, Long certificacionId) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("clienteId", clienteId);
        paramSource.addValue("certificacionId", certificacionId);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

}
