package com.ceiba.certificacion.servicio.testdatabuilder;

import com.ceiba.certificacion.modelo.entidad.Certificacion;

public class CertificacionTestDataBuilder {

	private Long id;
	private String nombreCertificacion;
	private String detalleCertificacion;
	private Integer duracionCertificacion;
	private Double precioCertificacion;

	public CertificacionTestDataBuilder() {
		id=1L;
		nombreCertificacion = "Java";
		detalleCertificacion = "Java EE y Servicios Web";
		duracionCertificacion = 120;
		precioCertificacion = Double.valueOf(1000000);
	}

	public CertificacionTestDataBuilder conId(Long id) {
		this.id = id;
		return this;
	}

	public CertificacionTestDataBuilder conNombre(String nombreCertificacion) {
		this.nombreCertificacion = nombreCertificacion;
		return this;
	}

	public CertificacionTestDataBuilder conDetalle(String detalle) {
		this.detalleCertificacion = detalle;
		return this;
	}

	public CertificacionTestDataBuilder conDuracion(Integer duracion) {
		this.duracionCertificacion = duracion;
		return this;
	}

	public CertificacionTestDataBuilder conPrecio(Double precio) {
		this.precioCertificacion = precio;
		return this;
	}

	public Certificacion build() {
		return new Certificacion(id, nombreCertificacion, detalleCertificacion, duracionCertificacion,
				precioCertificacion);
	}
}
