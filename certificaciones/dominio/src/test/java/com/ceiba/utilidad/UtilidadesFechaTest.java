package com.ceiba.utilidad;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.enumeracion.EnumeracionTipoCliente;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

class UtilidadesFechaTest {

	@Test
	@DisplayName("Deberia devolver que no es festivo")
	void deberiaDevolverQueNoEsFestivo() {
		// arrange
		LocalDate fecha = LocalDate.of(2022, 2, 23);

		// assert
		assertFalse(UtilidadesFecha.esFestivo(fecha));

	}

	@Test
	@DisplayName("Deberia devolver que sí es festivo")
	void deberiaDevolverQueSiEsFestivo() {
		// arrange
		LocalDate fecha = LocalDate.of(2022, 12, 25);

		// assert
		assertTrue(UtilidadesFecha.esFestivo(fecha));

	}

	@Test
	@DisplayName("Deberia devolver que no es fin de semana")
	void deberiaDevolverQueNoEsFinDeSemana() {
		// arrange
		LocalDate fecha = LocalDate.of(2017, 12, 22);

		// assert
		assertFalse(UtilidadesFecha.esFinDeSemana(fecha));

	}

	@Test
	@DisplayName("Deberia devolver que sí es fin de semana para un sábado")
	void deberiaDevolverQueSiEsFinDeSemanaParaUnSabado() {
		// arrange
		LocalDate fecha = LocalDate.of(2017, 12, 23);

		// assert
		assertTrue(UtilidadesFecha.esFinDeSemana(fecha));

	}

	@Test
	@DisplayName("Deberia devolver que sí es fin de semana para un domingo")
	void deberiaDevolverQueSiEsFinDeSemanaParaUnDomingo() {
		// arrange
		LocalDate fecha = LocalDate.of(2017, 12, 24);

		// assert
		assertTrue(UtilidadesFecha.esFinDeSemana(fecha));

	}

}
