package com.ceiba.certificacion.entidad;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ceiba.BasePrueba;
import com.ceiba.certificacion.modelo.entidad.Certificacion;
import com.ceiba.certificacion.servicio.testdatabuilder.CertificacionTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

class CertificacionTest {

	@Test
	@DisplayName("Deberia crear correctamente la certificacion")
	void deberiaCrearCorrectamenteLaCertificacion() {
		// act
		Certificacion certificacion = new CertificacionTestDataBuilder().conId(1L).build();
		// assert
		assertEquals(1, certificacion.getId());
		assertEquals("Java", certificacion.getNombre());
		assertEquals("Java EE y Servicios Web", certificacion.getDetalle());
		assertEquals(Integer.valueOf(120), certificacion.getDuracion());
		assertEquals(Double.valueOf(1000000), certificacion.getPrecio());
	}

	@Test
	void deberiaFallarSinNombreDeCertificacion() {

		// Arrange
		CertificacionTestDataBuilder certificacionTestDataBuilder = new CertificacionTestDataBuilder().conNombre(null)
				.conId(1L);
		// act-assert
		BasePrueba.assertThrows(() -> {
			certificacionTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar el nombre de la certificación");
	}

	@Test
	void deberiaFallarSinDetalle() {

		// Arrange
		CertificacionTestDataBuilder certificacionTestDataBuilder = new CertificacionTestDataBuilder().conDetalle(null)
				.conId(1L);
		// act-assert
		BasePrueba.assertThrows(() -> {
			certificacionTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar el detalle de la certificación");
	}

	@Test
	void deberiaFallarSinDuracion() {

		// Arrange
		CertificacionTestDataBuilder certificacionTestDataBuilder = new CertificacionTestDataBuilder().conDuracion(null)
				.conId(1L);
		// act-assert
		BasePrueba.assertThrows(() -> {
			certificacionTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar la duración en horas de la certificación");
	}

	@Test
	void deberiaFallarSinPrecio() {

		// Arrange
		CertificacionTestDataBuilder certificacionTestDataBuilder = new CertificacionTestDataBuilder().conPrecio(null)
				.conId(1L);
		// act-assert
		BasePrueba.assertThrows(() -> {
			certificacionTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar el precio de la certificación");
	}

	@Test
	void deberiaFallarConPrecioCero() {

		// Arrange
		CertificacionTestDataBuilder certificacionTestDataBuilder = new CertificacionTestDataBuilder()
				.conPrecio(Double.valueOf(0)).conId(1L);
		// act-assert
		BasePrueba.assertThrows(() -> {
			certificacionTestDataBuilder.build();
		}, ExcepcionValorInvalido.class, "El precio de la certificación debe ser mayor a cero");
	}

	@Test
	void deberiaFallarConPrecioNegativo() {

		// Arrange
		CertificacionTestDataBuilder certificacionTestDataBuilder = new CertificacionTestDataBuilder()
				.conPrecio(Double.valueOf(-10)).conId(1L);
		// act-assert
		BasePrueba.assertThrows(() -> {
			certificacionTestDataBuilder.build();
		}, ExcepcionValorInvalido.class, "El precio de la certificación debe ser mayor a cero");
	}

}
