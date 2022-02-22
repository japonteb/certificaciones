package com.ceiba.certificacion.puerto.dao;

import java.util.List;

import com.ceiba.certificacion.modelo.dto.DtoCertificacion;

public interface DaoCertificacion {

    /**
     * Permite listar las certificaciones
     * @return las certificaciones
     */
    List<DtoCertificacion> listar();
}
