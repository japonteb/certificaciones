package com.ceiba.cliente.modelo.dto;

import com.ceiba.cliente.modelo.enumeracion.EnumeracionTipoCliente;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoCliente {
	private Long id;
	private String nombre;
	private EnumeracionTipoCliente tipoCliente;

}
