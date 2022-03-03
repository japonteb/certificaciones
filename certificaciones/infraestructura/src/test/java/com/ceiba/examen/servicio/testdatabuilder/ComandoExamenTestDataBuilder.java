package com.ceiba.examen.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.certificacion.comando.ComandoCertificacion;
import com.ceiba.certificacion.servicio.testdatabuilder.ComandoCertificacionTestDataBuilder;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ComandoClienteTestDataBuilder;
import com.ceiba.examen.comando.ComandoExamen;

public class ComandoExamenTestDataBuilder {

	private Long id;
	private ComandoCliente comandoCliente;
	private ComandoCertificacion comandoCertificacion;
	private LocalDateTime fechaPresentacion;
	private Double precioTotal;

	public ComandoExamenTestDataBuilder() {
		comandoCliente = new ComandoClienteTestDataBuilder().conId(1L).build();
		comandoCertificacion = new ComandoCertificacionTestDataBuilder().conId(2L).build();
		fechaPresentacion = LocalDateTime.now();
		precioTotal = Double.valueOf(500);
	}

	public ComandoExamenTestDataBuilder conComandoCliente(ComandoCliente comandoCliente) {
		this.comandoCliente = comandoCliente;
		return this;
	}

	public ComandoExamenTestDataBuilder conComandoCertificacion(ComandoCertificacion comandoCertificacion) {
		this.comandoCertificacion = comandoCertificacion;
		return this;
	}

	public ComandoExamen build() {
		return new ComandoExamen(id, comandoCliente, comandoCertificacion, fechaPresentacion, precioTotal);
	}
}
