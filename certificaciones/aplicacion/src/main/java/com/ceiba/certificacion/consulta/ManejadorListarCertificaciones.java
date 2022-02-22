package com.ceiba.certificacion.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.certificacion.modelo.dto.DtoCertificacion;
import com.ceiba.certificacion.puerto.dao.DaoCertificacion;

@Component
public class ManejadorListarCertificaciones {

	private final DaoCertificacion daoCertificacion;

	public ManejadorListarCertificaciones(DaoCertificacion daoCertificacion) {
		this.daoCertificacion = daoCertificacion;
	}

	public List<DtoCertificacion> ejecutar() {
		return this.daoCertificacion.listar();
	}
}
