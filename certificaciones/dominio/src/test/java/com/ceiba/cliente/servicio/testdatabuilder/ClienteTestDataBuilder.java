package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.enumeracion.EnumeracionTipoCliente;

public class ClienteTestDataBuilder {

	private Long id;
	private String nombreCliente;
	private EnumeracionTipoCliente tipoCliente;

	public ClienteTestDataBuilder() {
		id = 1L;
		nombreCliente = "1234";
		tipoCliente = EnumeracionTipoCliente.CLIENTE_TIPO_1;
	}

	public ClienteTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public ClienteTestDataBuilder conNombre(String nombreCliente) {
		this.nombreCliente = nombreCliente;
		return this;
	}
	
	public ClienteTestDataBuilder conTipoCliente(EnumeracionTipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
		return this;
	}

	public Cliente build() {
		return new Cliente(id, nombreCliente, tipoCliente);
	}
}
