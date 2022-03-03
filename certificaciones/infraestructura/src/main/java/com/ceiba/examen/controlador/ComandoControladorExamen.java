package com.ceiba.examen.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.examen.comando.ComandoExamen;
import com.ceiba.examen.comando.manejador.ManejadorCrearExamen;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/examenes")
@Api(tags = { "Controlador comando examen" })
public class ComandoControladorExamen {

	private final ManejadorCrearExamen manejadorCrearExamen;

	@Autowired
	public ComandoControladorExamen(ManejadorCrearExamen manejadorCrearExamen) {
		this.manejadorCrearExamen = manejadorCrearExamen;
	}

	@PostMapping
	@ApiOperation("Crear Examen")
	public void crear(@RequestBody ComandoExamen comandoExamen) {
		manejadorCrearExamen.ejecutar(comandoExamen);
	}
}
