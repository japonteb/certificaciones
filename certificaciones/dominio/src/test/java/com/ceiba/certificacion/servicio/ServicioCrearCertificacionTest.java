package com.ceiba.certificacion.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.certificacion.modelo.entidad.Certificacion;
import com.ceiba.certificacion.puerto.repositorio.RepositorioCertificacion;
import com.ceiba.certificacion.servicio.testdatabuilder.CertificacionTestDataBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicioCrearCertificacionTest {

    @Test
    @DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de la certificación")
    void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDeLaCertificacion() {
        // arrange
        Certificacion certificacion = new CertificacionTestDataBuilder().build();
        RepositorioCertificacion repositorioCertificacion = Mockito.mock(RepositorioCertificacion.class);
        Mockito.when(repositorioCertificacion.existe(Mockito.anyString(),Mockito.anyString())).thenReturn(true);
        ServicioCrearCertificacion servicioCrearCertificacion = new ServicioCrearCertificacion(repositorioCertificacion);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCertificacion.ejecutar(certificacion), ExcepcionDuplicidad.class,"La certificación ya existe en el sistema");
    }

    @Test
    @DisplayName("Deberia Crear la certificación de manera correcta")
    void deberiaCrearLaCertificacionDeManeraCorrecta() {
        // arrange
        Certificacion certificacion = new CertificacionTestDataBuilder().build();
        RepositorioCertificacion repositorioCertificacion = Mockito.mock(RepositorioCertificacion.class);
        Mockito.when(repositorioCertificacion.existe(Mockito.anyString(),Mockito.anyString())).thenReturn(false);
        Mockito.when(repositorioCertificacion.crear(certificacion)).thenReturn(10L);
        ServicioCrearCertificacion servicioCrearCertificacion = new ServicioCrearCertificacion(repositorioCertificacion);
        // act
        Long idCertificacion = servicioCrearCertificacion.ejecutar(certificacion);
        //- assert
        assertEquals(10L,idCertificacion);
        Mockito.verify(repositorioCertificacion, Mockito.times(1)).crear(certificacion);
    }
}
