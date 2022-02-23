package com.ceiba.examen.modelo.dto;

import java.time.LocalDateTime;

import com.ceiba.certificacion.modelo.dto.DtoCertificacion;
import com.ceiba.cliente.modelo.dto.DtoCliente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoExamen {
	 private Long id;
	 private DtoCertificacion dtoCertificacion;
	 private DtoCliente dtoCliente;
	 private LocalDateTime fechaPresentacion;
	 private Double precioTotal;
}
