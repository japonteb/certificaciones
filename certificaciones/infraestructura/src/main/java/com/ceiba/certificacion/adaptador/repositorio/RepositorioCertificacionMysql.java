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
    private static String sqlCrear;

    @SqlStatement(namespace="certificacion", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="certificacion", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="certificacion", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="certificacion", value="existePorId")
    private static String sqlExistePorId;
    
    @SqlStatement(namespace="certificacion", value="existeCertificacionEnExamenesPorId")
    private static String sqlExisteCertificacionEnExamenesPorId;

    public RepositorioCertificacionMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Certificacion certificacion) {
        return this.customNamedParameterJdbcTemplate.crear(certificacion, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(String nombre, String detalle) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("nombre", nombre);
        paramSource.addValue("detalle", detalle);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public void actualizar(Certificacion certificacion) {
        this.customNamedParameterJdbcTemplate.actualizar(certificacion, sqlActualizar);
    }

    @Override
    public boolean existePorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExistePorId,paramSource, Boolean.class);
    }
    
    @Override
    public boolean existeCertificacionEnExamenesPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("certificacionId", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExisteCertificacionEnExamenesPorId,paramSource, Boolean.class);
    }
    
}
