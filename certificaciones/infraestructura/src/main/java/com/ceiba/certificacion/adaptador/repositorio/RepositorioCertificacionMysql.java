package com.ceiba.certificacion.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.certificacion.modelo.entidad.Certificacion;
import com.ceiba.certificacion.puerto.repositorio.RepositorioCertificacion;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioCertificacionMysql implements RepositorioCertificacion {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="certificacion", value="crear")
    private static String sqlCrearCertificacion;

    @SqlStatement(namespace="certificacion", value="actualizar")
    private static String sqlActualizarCertificacion;

    @SqlStatement(namespace="certificacion", value="eliminar")
    private static String sqlEliminarCertificacion;

    @SqlStatement(namespace="certificacion", value="existe")
    private static String sqlExisteCertificacion;

    @SqlStatement(namespace="certificacion", value="existePorId")
    private static String sqlExisteCertificacionPorId;
    
    @SqlStatement(namespace="certificacion", value="existeEnExamenesPorId")
    private static String sqlExisteCertificacionEnExamenesPorId;

    public RepositorioCertificacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Certificacion certificacion) {
        return this.customNamedParameterJdbcTemplate.crear(certificacion, sqlCrearCertificacion);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminarCertificacion, paramSource);
    }

    @Override
    public boolean existe(String nombre, String detalle) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);
        paramSource.addValue("detalle", detalle);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteCertificacion,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Certificacion certificacion) {
        this.customNamedParameterJdbcTemplate.actualizar(certificacion, sqlActualizarCertificacion);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteCertificacionPorId,paramSource, Boolean.class);
    }
    
    @Override
    public boolean existeCertificacionEnExamenesPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("certificacionId", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteCertificacionEnExamenesPorId,paramSource, Boolean.class);
    }
    
}
