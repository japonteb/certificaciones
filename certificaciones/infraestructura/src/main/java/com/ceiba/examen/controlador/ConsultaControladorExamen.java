package com.ceiba.examen.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.examen.consulta.ManejadorListarExamen;
import com.ceiba.examen.modelo.dto.DtoExamenCertificacion;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/examenes")
@Api(tags = { "Controlador consulta examen" })
public class ConsultaControladorExamen {

	private final ManejadorListarExamen manejadorListarExamenes;

	public ConsultaControladorExamen(ManejadorListarExamen manejadorListarExamenes) {
		this.manejadorListarExamenes = manejadorListarExamenes;
	}

	@GetMapping(value = "/cliente/{id}")
	@ApiOperation("Listar Examenes por id del cliente")
	public List<DtoExamenCertificacion> listar(@PathVariable Long id) {
		return this.manejadorListarExamenes.ejecutar(id);
	}

}
