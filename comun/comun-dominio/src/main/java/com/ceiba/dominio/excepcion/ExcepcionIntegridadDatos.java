package com.ceiba.dominio.excepcion;

public class ExcepcionIntegridadDatos extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ExcepcionIntegridadDatos(String mensaje) {
        super(mensaje);
    }
}
