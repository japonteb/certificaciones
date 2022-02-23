package com.ceiba.examen.servicio.testdatabuilder;

import java.time.LocalDateTime;

import com.ceiba.certificacion.modelo.entidad.Certificacion;
import com.ceiba.certificacion.servicio.testdatabuilder.CertificacionTestDataBuilder;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.examen.modelo.entidad.Examen;

public class ExamenTestDataBuilder {

	private Long id;
	private Cliente clienteExamen;
	private Certificacion certificacionExamen;
	private LocalDateTime fechaPresentacion;

	public ExamenTestDataBuilder() {

		id = 1L;
		clienteExamen = new ClienteTestDataBuilder().build();
		certificacionExamen = new CertificacionTestDataBuilder().build();

		fechaPresentacion = LocalDateTime.now();
	}

	private ExamenTestDataBuilder(ExamenTestDataBuilder copia) {
		this.id = copia.id;
		this.clienteExamen = copia.clienteExamen;
		this.certificacionExamen = copia.certificacionExamen;
		this.fechaPresentacion = copia.fechaPresentacion;
	}

	public ExamenTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public ExamenTestDataBuilder conClienteExamen(Cliente clienteExamen) {
		this.clienteExamen = clienteExamen;
		return this;
	}

	public ExamenTestDataBuilder conCertificacionExamen(Certificacion certificacionExamen) {
		this.certificacionExamen = certificacionExamen;
		return this;
	}

	public ExamenTestDataBuilder conFechaPresentacion(LocalDateTime fechaPresentacion) {
		this.fechaPresentacion = fechaPresentacion;
		return this;
	}

	public Examen build() {
		return new Examen(id, clienteExamen, certificacionExamen, fechaPresentacion);
	}

	public ExamenTestDataBuilder pero() {
		return new ExamenTestDataBuilder(this);
	}
}
