package com.ceiba.examen.entidad;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ceiba.BasePrueba;
import com.ceiba.certificacion.servicio.testdatabuilder.CertificacionTestDataBuilder;
import com.ceiba.cliente.modelo.enumeracion.EnumeracionTipoCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;
import com.ceiba.examen.modelo.entidad.Examen;
import com.ceiba.examen.servicio.testdatabuilder.ExamenTestDataBuilder;
import com.ceiba.examen.servicio.testdatabuilder.ExamenTestDataBuilder;

public class ExamenTest {

	static LocalDateTime fechaPresentacionEntreSemana;
	static LocalDateTime fechaPresentacionFinDeSemana;
	static LocalDateTime fechaPresentacionFestivo;
	static ExamenTestDataBuilder examenTestDataBuilderConCertificacionPrecio100;
	static ExamenTestDataBuilder examenTestDataBuilderConClienteTipo4ConCertificacionPrecio100;
	static ExamenTestDataBuilder examenTestDataBuilderConClienteTipo1ConCertificacionPrecio100;
	static ExamenTestDataBuilder examenTestDataBuilderConClienteTipo2ConCertificacionPrecio100;
	static ExamenTestDataBuilder examenTestDataBuilderConClienteTipo3ConCertificacionPrecio100;

	@BeforeAll
	public static void init() {

		fechaPresentacionEntreSemana = LocalDateTime.of(2022, 2, 23, 8, 00, 00);
		fechaPresentacionFinDeSemana = LocalDateTime.of(2022, 2, 26, 8, 00, 00);
		fechaPresentacionFestivo = LocalDateTime.of(2022, 12, 25, 8, 00, 00);

		examenTestDataBuilderConCertificacionPrecio100 = new ExamenTestDataBuilder()
				.conCertificacionExamen(new CertificacionTestDataBuilder().conPrecio(Double.valueOf(100)).build());

		examenTestDataBuilderConClienteTipo4ConCertificacionPrecio100 = examenTestDataBuilderConCertificacionPrecio100
				.pero().conClienteExamen(
						new ClienteTestDataBuilder().conTipoCliente(EnumeracionTipoCliente.CLIENTE_TIPO_4).build());
		examenTestDataBuilderConClienteTipo1ConCertificacionPrecio100 = examenTestDataBuilderConCertificacionPrecio100
				.pero().conClienteExamen(
						new ClienteTestDataBuilder().conTipoCliente(EnumeracionTipoCliente.CLIENTE_TIPO_1).build());
		examenTestDataBuilderConClienteTipo2ConCertificacionPrecio100 = examenTestDataBuilderConCertificacionPrecio100
				.pero().conClienteExamen(
						new ClienteTestDataBuilder().conTipoCliente(EnumeracionTipoCliente.CLIENTE_TIPO_2).build());
		examenTestDataBuilderConClienteTipo3ConCertificacionPrecio100 = examenTestDataBuilderConCertificacionPrecio100
				.pero().conClienteExamen(
						new ClienteTestDataBuilder().conTipoCliente(EnumeracionTipoCliente.CLIENTE_TIPO_3).build());
	}

	@Test
	@DisplayName("Deberia crear correctamente el examen")
	void deberiaCrearCorrectamenteLaExamen() {
		// arrange
		LocalDateTime fechaPresentacion = LocalDateTime.now();
		// act
		Examen examen = new ExamenTestDataBuilder().conFechaPresentacion(fechaPresentacion).conId(1L).build();
		// assert
		assertEquals(1, examen.getId());
		assertEquals("1234", examen.getCliente().getNombre());
		assertEquals("Java", examen.getCertificacion().getNombre());
		assertEquals(fechaPresentacion, examen.getFechaPresentacion());
	}

	@Test
	void deberiaFallarSinClienteDeExamen() {

		// Arrange
		ExamenTestDataBuilder examenTestDataBuilder = new ExamenTestDataBuilder().conClienteExamen(null).conId(1L);
		// act-assert
		BasePrueba.assertThrows(() -> {
			examenTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar el cliente que va a presentar el examen");
	}

	@Test
	void deberiaFallarSinCertificacionDeExamen() {

		// Arrange
		ExamenTestDataBuilder examenTestDataBuilder = new ExamenTestDataBuilder().conCertificacionExamen(null)
				.conId(1L);
		// act-assert
		BasePrueba.assertThrows(() -> {
			examenTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar la certificación del examen");
	}

	@Test
	void deberiaFallarSinFechaPresentacion() {

		// Arrange
		ExamenTestDataBuilder examenTestDataBuilder = new ExamenTestDataBuilder().conFechaPresentacion(null).conId(1L);
		// act-assert
		BasePrueba.assertThrows(() -> {
			examenTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar la fecha de presentación del examen");
	}

	@Test
	void deberiaCalcularPrecioSinDescuentoClienteTipo4DiaEntreSemana() {

		// Arrange - act
		Examen examen = examenTestDataBuilderConClienteTipo4ConCertificacionPrecio100
				.conFechaPresentacion(fechaPresentacionEntreSemana).build();
		// assert
		assertEquals(Double.valueOf(100), examen.getPrecioTotal());

	}

	@Test
	void deberiaCalcularPrecioSinDescuentoClienteTipo4FinDeSemana() {

		// Arrange - act
		Examen examen = examenTestDataBuilderConClienteTipo4ConCertificacionPrecio100
				.conFechaPresentacion(fechaPresentacionFinDeSemana).build();
		// assert
		assertEquals(Double.valueOf(200), examen.getPrecioTotal());
	}

	@Test
	void deberiaCalcularPrecioSinDescuentoClienteTipo4Festivo() {

		// Arrange - act
		Examen examen = examenTestDataBuilderConClienteTipo4ConCertificacionPrecio100
				.conFechaPresentacion(fechaPresentacionFestivo).build();
		// assert
		assertEquals(Double.valueOf(300), examen.getPrecioTotal());
	}

	@Test
	void deberiaCalcularPrecioConDescuentoClienteTipo1DiaEntreSemana() {

		// Arrange - act
		Examen examen = examenTestDataBuilderConClienteTipo1ConCertificacionPrecio100
				.conFechaPresentacion(fechaPresentacionEntreSemana).build();
		// assert
		assertEquals(Double.valueOf(90), examen.getPrecioTotal());
	}

	@Test
	void deberiaCalcularPrecioConDescuentoClienteTipo1FinDeSemana() {

		// Arrange - act
		Examen examen = examenTestDataBuilderConClienteTipo1ConCertificacionPrecio100
				.conFechaPresentacion(fechaPresentacionFinDeSemana).build();
		// assert
		assertEquals(Double.valueOf(180), examen.getPrecioTotal());
	}

	@Test
	void deberiaCalcularPrecioConDescuentoClienteTipo1Festivo() {

		// Arrange - act
		Examen examen = examenTestDataBuilderConClienteTipo1ConCertificacionPrecio100
				.conFechaPresentacion(fechaPresentacionFestivo).build();
		// assert
		assertEquals(Double.valueOf(270), examen.getPrecioTotal());
	}

	@Test
	void deberiaCalcularPrecioConDescuentoClienteTipo2DiaEntreSemana() {

		// Arrange - act
		Examen examen = examenTestDataBuilderConClienteTipo2ConCertificacionPrecio100
				.conFechaPresentacion(fechaPresentacionEntreSemana).build();
		// assert
		assertEquals(Double.valueOf(80), examen.getPrecioTotal());
	}

	@Test
	void deberiaCalcularPrecioConDescuentoClienteTipo2FinDeSemana() {

		// Arrange - act
		Examen examen = examenTestDataBuilderConClienteTipo2ConCertificacionPrecio100
				.conFechaPresentacion(fechaPresentacionFinDeSemana).build();
		// assert
		assertEquals(Double.valueOf(160), examen.getPrecioTotal());
	}

	@Test
	void deberiaCalcularPrecioConDescuentoClienteTipo2Festivo() {

		// Arrange - act
		Examen examen = examenTestDataBuilderConClienteTipo2ConCertificacionPrecio100
				.conFechaPresentacion(fechaPresentacionFestivo).build();
		// assert
		assertEquals(Double.valueOf(240), examen.getPrecioTotal());
	}

	@Test
	void deberiaCalcularPrecioConDescuentoClienteTipo3DiaEntreSemana() {

		// Arrange - act
		Examen examen = examenTestDataBuilderConClienteTipo3ConCertificacionPrecio100
				.conFechaPresentacion(fechaPresentacionEntreSemana).build();
		// assert
		assertEquals(Double.valueOf(70), examen.getPrecioTotal());
	}

	@Test
	void deberiaCalcularPrecioConDescuentoClienteTipo3FinDeSemana() {

		// Arrange - act
		Examen examen = examenTestDataBuilderConClienteTipo3ConCertificacionPrecio100
				.conFechaPresentacion(fechaPresentacionFinDeSemana).build();
		// assert
		assertEquals(Double.valueOf(140), examen.getPrecioTotal());
	}

	@Test
	void deberiaCalcularPrecioConDescuentoClienteTipo3Festivo() {

		// Arrange - act
		Examen examen = examenTestDataBuilderConClienteTipo3ConCertificacionPrecio100
				.conFechaPresentacion(fechaPresentacionFestivo).build();
		// assert
		assertEquals(Double.valueOf(210), examen.getPrecioTotal());
	}

}
