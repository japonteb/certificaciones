package com.ceiba.examen.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.examen.comando.ComandoExamen;

public class ComandoExamenTestDataBuilder {

	private Long id;
	private Long clienteId;
	private Long certificacionId;
	private LocalDateTime fechaPresentacion;
	private Double precioTotal;

	public ComandoExamenTestDataBuilder() {
		clienteId = 1L;
		certificacionId = 1L;
		fechaPresentacion = LocalDateTime.now();
		precioTotal = Double.valueOf(500);
	}

	public ComandoExamenTestDataBuilder conClienteId(Long clienteId) {
		this.clienteId = clienteId;
		return this;
	}

	public ComandoExamenTestDataBuilder conCertificacionId(Long certificacionId) {
		this.certificacionId = certificacionId;
		return this;
	}

	public ComandoExamen build() {
		return new ComandoExamen(id, clienteId, certificacionId, fechaPresentacion, precioTotal);
	}
}
