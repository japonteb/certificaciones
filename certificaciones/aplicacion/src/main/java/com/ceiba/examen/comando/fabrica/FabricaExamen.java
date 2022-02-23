package com.ceiba.examen.comando.fabrica;

import org.springframework.stereotype.Component;

import com.ceiba.certificacion.modelo.entidad.Certificacion;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.examen.comando.ComandoExamen;
import com.ceiba.examen.modelo.entidad.Examen;

@Component
public class FabricaExamen {

	public Examen crear(ComandoExamen comandoExamen, Cliente cliente, Certificacion certificacion) {

		return new Examen(comandoExamen.getId(), cliente, certificacion, comandoExamen.getFechaPresentacion());
	}

}
