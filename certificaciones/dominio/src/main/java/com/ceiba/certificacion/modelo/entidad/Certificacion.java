package com.ceiba.certificacion.modelo.entidad;


import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;
import static com.ceiba.dominio.ValidadorArgumento.validarPositivo;

import lombok.Getter;

@Getter
public class Certificacion {

    private static final String EL_PRECIO_DEBE_SER_MAYOR_A_CERO = "El precio de la certificación debe ser mayor a cero";
    private static final String SE_DEBE_INGRESAR_LA_DURACION = "Se debe ingresar la duración en horas de la certificación";
    private static final String SE_DEBE_INGRESAR_EL_PRECIO = "Se debe ingresar el precio de la certificación";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_CERTIFICACION = "Se debe ingresar el nombre de la certificación";
    private static final String SE_DEBE_INGRESAR_EL_DETALLE_DE_CERTIFICACION = "Se debe ingresar el detalle de la certificación";

    
    private Long id;
    private String nombre;
    private String detalle;
    private Integer duracion;
    private Double precio;

    public Certificacion(Long id,String nombre, String detalle,Integer duracion, Double precio) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_CERTIFICACION);
        validarObligatorio(detalle, SE_DEBE_INGRESAR_EL_DETALLE_DE_CERTIFICACION);
        validarObligatorio(precio, SE_DEBE_INGRESAR_EL_PRECIO);
        validarObligatorio(duracion, SE_DEBE_INGRESAR_LA_DURACION);
        validarPositivo(precio, EL_PRECIO_DEBE_SER_MAYOR_A_CERO);
        

        this.id = id;
        this.nombre = nombre;
        this.detalle = detalle;
        this.duracion = duracion;
        this.precio = precio;
    }

}
