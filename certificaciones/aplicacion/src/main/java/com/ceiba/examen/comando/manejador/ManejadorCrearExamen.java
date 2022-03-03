package com.ceiba.examen.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.certificacion.comando.fabrica.FabricaCertificacion;
import com.ceiba.certificacion.modelo.entidad.Certificacion;
import com.ceiba.cliente.comando.fabrica.FabricaCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.examen.comando.ComandoExamen;
import com.ceiba.examen.comando.fabrica.FabricaExamen;
import com.ceiba.examen.modelo.entidad.Examen;
import com.ceiba.examen.servicio.ServicioCrearExamen;
import com.ceiba.manejador.ManejadorComando;

@Component
public class ManejadorCrearExamen implements ManejadorComando<ComandoExamen> {

	private final FabricaExamen fabricaExamen;
	private final FabricaCliente fabricaCliente;
	private final FabricaCertificacion fabricaCertificacion;
	private final ServicioCrearExamen servicioCrearExamen;

	public ManejadorCrearExamen(FabricaExamen fabricaExamen, FabricaCliente fabricaCliente, FabricaCertificacion fabricaCertificacion, ServicioCrearExamen servicioCrearExamen) {
		this.fabricaExamen = fabricaExamen; 
		this.fabricaCliente = fabricaCliente;
		this.fabricaCertificacion = fabricaCertificacion;
		this.servicioCrearExamen = servicioCrearExamen;
	}

	public void ejecutar(ComandoExamen comandoExamen) {
		
    	Cliente cliente = this.fabricaCliente.crear(comandoExamen.getComandoCliente());
    	Certificacion certificacion = this.fabricaCertificacion.crear(comandoExamen.getComandoCertificacion());
		
		Examen examen = this.fabricaExamen.crear(comandoExamen, cliente, certificacion);
		this.servicioCrearExamen.ejecutar(examen);
	}
}
