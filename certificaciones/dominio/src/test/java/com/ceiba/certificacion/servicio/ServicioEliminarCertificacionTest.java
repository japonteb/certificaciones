package com.ceiba.certificacion.servicio;

import com.ceiba.certificacion.puerto.repositorio.RepositorioCertificacion;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ServicioEliminarCertificacionTest {

    @Test
    @DisplayName("Deberia eliminar la certificacion llamando al repositorio")
    void deberiaEliminarLaCertificacionLlamandoAlRepositorio() {
        RepositorioCertificacion repositorioCertificacion = Mockito.mock(RepositorioCertificacion.class);
        ServicioEliminarCertificacion servicioEliminarCertificacion = new ServicioEliminarCertificacion(repositorioCertificacion);

        servicioEliminarCertificacion.ejecutar(1l);

        Mockito.verify(repositorioCertificacion, Mockito.times(1)).eliminar(1l);

    }

}
