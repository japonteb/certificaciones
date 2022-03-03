package com.ceiba.examen.modelo.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoExamenCertificacion {
	 private Long id;
	 private String nombre;
	 private String detalle;
	 private LocalDateTime fechaPresentacion;
	 private Double precioTotal;
}
