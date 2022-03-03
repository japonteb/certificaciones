package com.ceiba.certificacion.servicio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.certificacion.puerto.repositorio.RepositorioCertificacion;
import com.ceiba.dominio.excepcion.ExcepcionIntegridadDatos;

class ServicioEliminarCertificacionTest {

	@Test
	@DisplayName("Deberia eliminar la certificacion llamando al repositorio")
	void deberiaEliminarLaCertificacionLlamandoAlRepositorio() {
		RepositorioCertificacion repositorioCertificacion = Mockito.mock(RepositorioCertificacion.class);
		ServicioEliminarCertificacion servicioEliminarCertificacion = new ServicioEliminarCertificacion(
				repositorioCertificacion);

		servicioEliminarCertificacion.ejecutar(1L);

		Mockito.verify(repositorioCertificacion, Mockito.times(1)).eliminar(1l);

	}

	@Test
	@DisplayName("Deberia lanzar una exepcion cuando se valide la existencia de la certificación")
	void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciavalidarDeCertificacionEnExamenes() {
		// arrange
		Long certificacionId = 1L;
		RepositorioCertificacion repositorioCertificacion = Mockito.mock(RepositorioCertificacion.class);
		Mockito.when(repositorioCertificacion.existeCertificacionEnExamenesPorId(Mockito.anyLong())).thenReturn(true);
		ServicioEliminarCertificacion servicioEliminarCertificacion = new ServicioEliminarCertificacion(
				repositorioCertificacion);
		// act - assert
		BasePrueba.assertThrows(() -> servicioEliminarCertificacion.ejecutar(certificacionId),
				ExcepcionIntegridadDatos.class,
				"No se puede eliminar la certificación porque está asociada a exámenes");
	}

}
