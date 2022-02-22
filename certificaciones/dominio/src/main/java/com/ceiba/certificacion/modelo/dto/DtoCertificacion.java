package com.ceiba.certificacion.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoCertificacion {
	 private Long id;
	 private String nombre;
	 private String detalle;
	 private Integer duracion;
	 private Double precio;
}
