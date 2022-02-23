package com.ceiba.certificacion.servicio;

import com.ceiba.certificacion.modelo.entidad.Certificacion;
import com.ceiba.certificacion.puerto.repositorio.RepositorioCertificacion;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarCertificacion {

    private static final String LA_CERTIFICACION_NO_EXISTE_EN_EL_SISTEMA = "La certificación no existe en el sistema";

    private final RepositorioCertificacion repositorioCertificacion;

    public ServicioActualizarCertificacion(RepositorioCertificacion repositorioCertificacion) {
        this.repositorioCertificacion = repositorioCertificacion;
    }

    public void ejecutar(Certificacion certificacion) {
        validarExistenciaPrevia(certificacion);
        this.repositorioCertificacion.actualizar(certificacion);
    }

    private void validarExistenciaPrevia(Certificacion certificacion) {
        boolean existe = this.repositorioCertificacion.existePorId(certificacion.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(LA_CERTIFICACION_NO_EXISTE_EN_EL_SISTEMA);
        }
    }
}
