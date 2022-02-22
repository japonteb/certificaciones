package com.ceiba.certificacion.comando.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.ComandoRespuesta;
import com.ceiba.certificacion.comando.ComandoCertificacion;
import com.ceiba.certificacion.comando.fabrica.FabricaCertificacion;
import com.ceiba.certificacion.modelo.entidad.Certificacion;
import com.ceiba.certificacion.servicio.ServicioCrearCertificacion;
import com.ceiba.manejador.ManejadorComandoRespuesta;

@Component
public class ManejadorCrearCertificacion implements ManejadorComandoRespuesta<ComandoCertificacion, ComandoRespuesta<Long>> {

    private final FabricaCertificacion fabricaCertificacion;
    private final ServicioCrearCertificacion servicioCrearCertificacion;

    public ManejadorCrearCertificacion(FabricaCertificacion fabricaCertificacion, ServicioCrearCertificacion servicioCrearCertificacion) {
        this.fabricaCertificacion = fabricaCertificacion;
        this.servicioCrearCertificacion = servicioCrearCertificacion;
    }

    public ComandoRespuesta<Long> ejecutar(ComandoCertificacion comandoCertificacion) {
        Certificacion certificacion = this.fabricaCertificacion.crear(comandoCertificacion);
		return new ComandoRespuesta<>(this.servicioCrearCertificacion.ejecutar(certificacion));
    }
}
