package com.ceiba.cliente.entidad;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

class ClienteTest {

	@Test
	@DisplayName("Deberia crear correctamente el cliente")
	void deberiaCrearCorrectamenteElUscliente() {
		// act
		Cliente cliente = new ClienteTestDataBuilder().conId(1L).build();
		// assert
		assertEquals(1, cliente.getId());
		assertEquals("1234", cliente.getNombre());
		assertEquals(1, cliente.getTipoCliente().getCodigoTipoCliente());
	}

	@Test
	void deberiaFallarSinNombreDeCliente() {

		// Arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conNombre(null).conId(1L);
		// act-assert
		BasePrueba.assertThrows(() -> {
			clienteTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar el nombre del cliente");
	}

	@Test
	void deberiaFallarSinTipoDeCliente() {

		// Arrange
		ClienteTestDataBuilder clienteTestDataBuilder = new ClienteTestDataBuilder().conTipoCliente(null).conId(1L);
		// act-assert
		BasePrueba.assertThrows(() -> {
			clienteTestDataBuilder.build();
		}, ExcepcionValorObligatorio.class, "Se debe ingresar el tipo de cliente");
	}

}
