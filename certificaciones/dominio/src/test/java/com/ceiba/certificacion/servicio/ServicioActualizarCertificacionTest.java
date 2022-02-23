package com.ceiba.certificacion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.certificacion.modelo.entidad.Certificacion;
import com.ceiba.certificacion.puerto.repositorio.RepositorioCertificacion;
import com.ceiba.certificacion.servicio.testdatabuilder.CertificacionTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ServicioActualizarCertificacionTest {

    @Test
    @DisplayName("Deberia validar la existencia previa de la certificacion")
    void deberiaValidarLaExistenciaPreviaDeLaCertificacion() {
        // arrange
        Certificacion certificacion = new CertificacionTestDataBuilder().conId(1L).build();
        RepositorioCertificacion repositorioCertificacion = Mockito.mock(RepositorioCertificacion.class);
        Mockito.when(repositorioCertificacion.existePorId(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarCertificacion servicioActualizarCertificacion = new ServicioActualizarCertificacion(repositorioCertificacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCertificacion.ejecutar(certificacion), ExcepcionDuplicidad.class,"La certificación no existe en el sistema");
    }

    @Test
    @DisplayName("Deberia actualizar correctamente en el repositorio")
    void deberiaActualizarCorrectamenteEnElRepositorio() {
        // arrange
        Certificacion certificacion = new CertificacionTestDataBuilder().conId(1L).build();
        RepositorioCertificacion repositorioCertificacion = Mockito.mock(RepositorioCertificacion.class);
        Mockito.when(repositorioCertificacion.existePorId(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarCertificacion servicioActualizarCertificacion = new ServicioActualizarCertificacion(repositorioCertificacion);
        // act
        servicioActualizarCertificacion.ejecutar(certificacion);
        //assert
        Mockito.verify(repositorioCertificacion,Mockito.times(1)).actualizar(certificacion);
    }
}
