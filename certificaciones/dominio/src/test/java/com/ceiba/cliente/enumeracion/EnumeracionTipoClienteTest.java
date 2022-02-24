package com.ceiba.cliente.enumeracion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.enumeracion.EnumeracionTipoCliente;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

class EnumeracionTipoClienteTest {

	@Test
	@DisplayName("Deberia retornar el valor correcto de la enumeración por código")
	void deberiaObtenerEnumeracionTipoClientePorCodigoTipoCliente() {
		// arrange
		int codigoTipoCliente = 1;
		
		// act - assert
		assertEquals(EnumeracionTipoCliente.CLIENTE_TIPO_1, EnumeracionTipoCliente.obtenerEnumeracionTipoClienteDeCodigo(codigoTipoCliente));
		
	}
	
	@Test
	void deberiaFallarConCodigoTipoClienteInvalido() {

		// arrange
		int codigoTipoCliente = -1;
		// act-assert
		BasePrueba.assertThrows(() -> {
			EnumeracionTipoCliente.obtenerEnumeracionTipoClienteDeCodigo(codigoTipoCliente);
		}, ExcepcionValorInvalido.class, "El código del tipo de cliente es inválido");
	}

}
