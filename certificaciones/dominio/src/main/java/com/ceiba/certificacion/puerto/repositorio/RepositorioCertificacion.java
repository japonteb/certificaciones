package com.ceiba.certificacion.puerto.repositorio;

import com.ceiba.certificacion.modelo.entidad.Certificacion;

public interface RepositorioCertificacion {
    /**
     * Permite crear una certificación
     * @param certificacion
     * @return el id generado
     */
    Long crear(Certificacion certificacion);

    /**
     * Permite actualizar una certificación
     * @param certificacion
     */
    void actualizar(Certificacion certificacion);

    /**
     * Permite eliminar una certificacion
     * @param id
     */
    void eliminar(Long id);
    
    /**
     * Permite validar si existe una certificación con un nombre y un detalle
     * @param nombre
     * @param detalle
     * @return si existe o no
     */
    boolean existe(String nombre, String detalle);

    /**
     * Permite validar si existe una certificacion con un id
     * @return si existe o no
     */
    boolean existePorId(Long id);

}
