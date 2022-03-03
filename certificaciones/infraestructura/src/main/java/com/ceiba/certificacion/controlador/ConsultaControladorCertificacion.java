package com.ceiba.certificacion.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.certificacion.consulta.ManejadorListarCertificaciones;
import com.ceiba.certificacion.modelo.dto.DtoCertificacion;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/certificaciones")
@Api(tags={"Controlador consulta certificacion"})
public class ConsultaControladorCertificacion {

    private final ManejadorListarCertificaciones manejadorListarCertificaciones;

    public ConsultaControladorCertificacion(ManejadorListarCertificaciones manejadorListarCertificaciones) {
        this.manejadorListarCertificaciones = manejadorListarCertificaciones;
    }

    @GetMapping
    @ApiOperation("Listar Certificaciones")
    public List<DtoCertificacion> listar() {
        return this.manejadorListarCertificaciones.ejecutar();
    }

}
