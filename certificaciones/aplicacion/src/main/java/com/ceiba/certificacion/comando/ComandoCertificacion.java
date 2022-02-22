package com.ceiba.certificacion.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCertificacion {

	private Long id;
	private String nombre;
	private String detalle;
	private Integer duracion;
	private Double precio;
}
