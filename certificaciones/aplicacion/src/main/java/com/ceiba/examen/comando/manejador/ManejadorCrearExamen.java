package com.ceiba.examen.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.certificacion.modelo.entidad.Certificacion;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.modelo.enumeracion.EnumeracionTipoCliente;
import com.ceiba.examen.comando.ComandoExamen;
import com.ceiba.examen.comando.fabrica.FabricaExamen;
import com.ceiba.examen.modelo.entidad.Examen;
import com.ceiba.examen.servicio.ServicioCrearExamen;
import com.ceiba.manejador.ManejadorComandoRespuesta;

@Component
public class ManejadorCrearExamen implements ManejadorComandoRespuesta<ComandoExamen, ComandoRespuesta<Long>> {

	private final FabricaExamen fabricaExamen;
	private final ServicioCrearExamen servicioCrearExamen;

	public ManejadorCrearExamen(FabricaExamen fabricaExamen, ServicioCrearExamen servicioCrearExamen) {
		this.fabricaExamen = fabricaExamen;
		this.servicioCrearExamen = servicioCrearExamen;
	}

	public ComandoRespuesta<Long> ejecutar(ComandoExamen comandoExamen) {
		
    	Cliente cliente = new Cliente(1L, "1234", EnumeracionTipoCliente.CLIENTE_TIPO_1);
    	Certificacion certificacion = new Certificacion(1L, "test nombre", "test detalle", 120, Double.valueOf(100));
    	
		Examen examen = this.fabricaExamen.crear(comandoExamen, cliente, certificacion);
		return new ComandoRespuesta<>(this.servicioCrearExamen.ejecutar(examen));
	}
}
