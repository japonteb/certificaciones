package com.ceiba.certificacion.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.certificacion.comando.ComandoCertificacion;
import com.ceiba.certificacion.comando.manejador.ManejadorActualizarCertificacion;
import com.ceiba.certificacion.comando.manejador.ManejadorCrearCertificacion;
import com.ceiba.certificacion.comando.manejador.ManejadorEliminarCertificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/certificaciones")
@Api(tags = { "Controlador comando certificacion"})
public class ComandoControladorCertificacion {

    private final ManejadorCrearCertificacion manejadorCrearCertificacion;
	private final ManejadorEliminarCertificacion manejadorEliminarCertificacion;
	private final ManejadorActualizarCertificacion manejadorActualizarCertificacion;

    @Autowired
    public ComandoControladorCertificacion(ManejadorCrearCertificacion manejadorCrearCertificacion,
									 ManejadorEliminarCertificacion manejadorEliminarCertificacion,
									 ManejadorActualizarCertificacion manejadorActualizarCertificacion) {
        this.manejadorCrearCertificacion = manejadorCrearCertificacion;
		this.manejadorEliminarCertificacion = manejadorEliminarCertificacion;
		this.manejadorActualizarCertificacion = manejadorActualizarCertificacion;
    }

    @PostMapping
    @ApiOperation("Crear Certificacion")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCertificacion comandoCertificacion) {
        return manejadorCrearCertificacion.ejecutar(comandoCertificacion);
    }

    @DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Certificacion")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarCertificacion.ejecutar(id);
	}

	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Certificacion")
	public void actualizar(@RequestBody ComandoCertificacion comandoCertificacion,@PathVariable Long id) {
		comandoCertificacion.setId(id);
		manejadorActualizarCertificacion.ejecutar(comandoCertificacion);
	}
}
