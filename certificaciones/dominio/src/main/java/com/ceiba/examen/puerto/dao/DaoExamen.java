package com.ceiba.examen.puerto.dao;

import java.util.List;

import com.ceiba.examen.modelo.dto.DtoExamenCertificacion;

public interface DaoExamen {

	/**
     * Permite obtener la lista de examenes asociados a un cliente por el id de éste
     * @param clienteId
     * @return List<DtoExamenCertificacion>
     */
    List<DtoExamenCertificacion> listarPorClienteId(Long clientId);
}
