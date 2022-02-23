package com.ceiba.examen.servicio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.examen.modelo.entidad.Examen;
import com.ceiba.examen.puerto.repositorio.RepositorioExamen;
import com.ceiba.examen.servicio.testdatabuilder.ExamenTestDataBuilder;

class ServicioCrearExamenTest {

	@Test
	@DisplayName("Deberia lanzar una exepcion cuando se valide la existencia del examen")
	void deberiaLanzarUnaExepcionCuandoSeValideLaExistenciaDelExamen() {
		// arrange
		Examen examen = new ExamenTestDataBuilder().build();
		RepositorioExamen repositorioExamen = Mockito.mock(RepositorioExamen.class);
		Mockito.when(repositorioExamen.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(true);
		ServicioCrearExamen servicioCrearExamen = new ServicioCrearExamen(repositorioExamen);
		// act - assert
		BasePrueba.assertThrows(() -> servicioCrearExamen.ejecutar(examen), ExcepcionDuplicidad.class,
				"El examen ya está programado en el sistema");
	}

	@Test
	@DisplayName("Deberia Crear el examen de manera correcta")
	void deberiaCrearElExamenDeManeraCorrecta() {
		// arrange
		Examen examen = new ExamenTestDataBuilder().build();
		RepositorioExamen repositorioExamen = Mockito.mock(RepositorioExamen.class);
		Mockito.when(repositorioExamen.existe(Mockito.anyLong(), Mockito.anyLong())).thenReturn(false);
		Mockito.when(repositorioExamen.crear(examen)).thenReturn(10L);
		ServicioCrearExamen servicioCrearExamen = new ServicioCrearExamen(repositorioExamen);
		// act
		Long idExamen = servicioCrearExamen.ejecutar(examen);
		// - assert
		assertEquals(10L, idExamen);
		Mockito.verify(repositorioExamen, Mockito.times(1)).crear(examen);
	}

}
