package com.ceiba.certificacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.certificacion.comando.ComandoCertificacion;
import com.ceiba.certificacion.comando.fabrica.FabricaCertificacion;
import com.ceiba.certificacion.modelo.entidad.Certificacion;
import com.ceiba.certificacion.servicio.ServicioActualizarCertificacion;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorActualizarCertificacion implements ManejadorComando<ComandoCertificacion> {

	private final FabricaCertificacion fabricaCertificacion;
	private final ServicioActualizarCertificacion servicioActualizarCertificacion;

	public ManejadorActualizarCertificacion(FabricaCertificacion fabricaCertificacion,
			ServicioActualizarCertificacion servicioActualizarCertificacion) {
		this.fabricaCertificacion = fabricaCertificacion;
		this.servicioActualizarCertificacion = servicioActualizarCertificacion;
	}

	public void ejecutar(ComandoCertificacion comandoCertificacion) {
		Certificacion certificacion = this.fabricaCertificacion.crear(comandoCertificacion);
		this.servicioActualizarCertificacion.ejecutar(certificacion);
	}
}
