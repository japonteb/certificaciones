package com.ceiba.certificacion.servicio;

import com.ceiba.certificacion.puerto.repositorio.RepositorioCertificacion;
import com.ceiba.dominio.excepcion.ExcepcionIntegridadDatos;

public class ServicioEliminarCertificacion {

	private static final String LA_CERTIFICACION_ESTA_ASOCIADA_A_EXAMENES = "No se puede eliminar la certificación porque está asociada a exámenes";
	
    private final RepositorioCertificacion repositorioCertificacion;

    public ServicioEliminarCertificacion(RepositorioCertificacion repositorioCertificacion) {
        this.repositorioCertificacion = repositorioCertificacion;
    }

    public void ejecutar(Long id) {
    	validarExistenciaCertificacionEnExamenes(id);
        this.repositorioCertificacion.eliminar(id);
    }
    
    private void validarExistenciaCertificacionEnExamenes(Long id) {
        boolean existe = this.repositorioCertificacion.existeCertificacionEnExamenesPorId(id);
        if(existe) {
            throw new ExcepcionIntegridadDatos(LA_CERTIFICACION_ESTA_ASOCIADA_A_EXAMENES);
        }
    }
}
