package com.ceiba.certificacion.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.stereotype.Component;


@Component
public class ManejadorEliminarCertificacion implements ManejadorComando<Long> {

    private final ServicioEliminarUsuario servicioEliminarUsuario;

    public ManejadorEliminarCertificacion(ServicioEliminarUsuario servicioEliminarUsuario) {
        this.servicioEliminarUsuario = servicioEliminarUsuario;
    }

    public void ejecutar(Long idUsuario) {
        this.servicioEliminarUsuario.ejecutar(idUsuario);
    }
}
