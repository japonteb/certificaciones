package com.ceiba.certificacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.certificacion.servicio.ServicioEliminarCertificacion;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorEliminarCertificacion implements ManejadorComando<Long> {

	private final ServicioEliminarCertificacion servicioEliminarCertificacion;

	public ManejadorEliminarCertificacion(ServicioEliminarCertificacion servicioEliminarCertificacion) {
		this.servicioEliminarCertificacion = servicioEliminarCertificacion;
	}

	public void ejecutar(Long idCertificacion) {
		this.servicioEliminarCertificacion.ejecutar(idCertificacion);
	}
}
