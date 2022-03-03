package com.ceiba.cliente.servicio.testdatabuilder;

import java.util.UUID;

import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.enumeracion.EnumeracionTipoCliente;

public class ComandoClienteTestDataBuilder {

	private Long id;
	private String nombre;
	private EnumeracionTipoCliente tipoCliente;
	

	public ComandoClienteTestDataBuilder() {
		nombre = UUID.randomUUID().toString();
		tipoCliente = EnumeracionTipoCliente.CLIENTE_TIPO_1;
	}

	public ComandoClienteTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}
	
	public ComandoClienteTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ComandoCliente build() {
		return new ComandoCliente(id, nombre, tipoCliente);
	}
}
