package com.ceiba.certificacion.servicio.testdatabuilder;

import java.util.UUID;

import com.ceiba.certificacion.comando.ComandoCertificacion;

public class ComandoCertificacionTestDataBuilder {

	private Long id;
	private String nombre;
	private String detalle;
	private Integer duracion;
	private Double precio;

	public ComandoCertificacionTestDataBuilder() {
		nombre = UUID.randomUUID().toString();
		detalle = "1234";
		duracion = 123;
		precio = Double.valueOf(1000000);

	}

	public ComandoCertificacionTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}
	
	public ComandoCertificacionTestDataBuilder conNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public ComandoCertificacion build() {
		return new ComandoCertificacion(id, nombre, detalle, duracion, precio);
	}
}
