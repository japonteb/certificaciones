package com.ceiba.certificacion.servicio;

import com.ceiba.certificacion.puerto.repositorio.RepositorioCertificacion;

public class ServicioEliminarCertificacion {

    private final RepositorioCertificacion repositorioCertificacion;

    public ServicioEliminarCertificacion(RepositorioCertificacion repositorioCertificacion) {
        this.repositorioCertificacion = repositorioCertificacion;
    }

    public void ejecutar(Long id) {
        this.repositorioCertificacion.eliminar(id);
    }
}
