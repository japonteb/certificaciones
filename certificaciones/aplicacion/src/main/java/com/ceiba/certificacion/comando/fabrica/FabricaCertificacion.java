package com.ceiba.certificacion.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.certificacion.comando.ComandoCertificacion;
import com.ceiba.certificacion.modelo.entidad.Certificacion;

@Component
public class FabricaCertificacion {

	public Certificacion crear(ComandoCertificacion comandoCertificacion) {
		return new Certificacion(comandoCertificacion.getId(), comandoCertificacion.getNombre(),
				comandoCertificacion.getDetalle(), comandoCertificacion.getDuracion(),
				comandoCertificacion.getPrecio());
	}

}
