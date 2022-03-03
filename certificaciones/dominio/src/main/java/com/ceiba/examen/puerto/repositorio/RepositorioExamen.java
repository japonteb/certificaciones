package com.ceiba.examen.puerto.repositorio;

import com.ceiba.examen.modelo.entidad.Examen;

public interface RepositorioExamen {
    /**
     * Permite crear un examen
     * @param examen
     * @return el id generado
     */
    void crear(Examen examen);

    /**
     * Permite validar si existe un examen para un cliente y una certificaci[on
     * @param clienteId
     * @param certificacionId
     * @return si existe o no
     */
    boolean existe(Long clienteId, Long certificacionId);

}
