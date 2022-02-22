package com.ceiba.certificacion.servicio;

import com.ceiba.certificacion.modelo.entidad.Certificacion;
import com.ceiba.certificacion.puerto.repositorio.RepositorioCertificacion;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioCrearCertificacion {

    private static final String LA_CERTIFICACION_YA_EXISTE_EN_EL_SISTEMA = "La certificación ya existe en el sistema";

    private final RepositorioCertificacion repositorioCertificacion;

    public ServicioCrearCertificacion(RepositorioCertificacion repositorioCertificacion) {
        this.repositorioCertificacion = repositorioCertificacion;
    }

    public Long ejecutar(Certificacion certificacion) {
        validarExistenciaPrevia(certificacion);
        return this.repositorioCertificacion.crear(certificacion);
    }

    private void validarExistenciaPrevia(Certificacion certificacion) {
        boolean existe = this.repositorioCertificacion.existe(certificacion.getNombre(), certificacion.getDetalle());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_CERTIFICACION_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
