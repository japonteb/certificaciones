package com.ceiba.cliente.comando;

import com.ceiba.cliente.modelo.enumeracion.EnumeracionTipoCliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCliente {

	private Long id;
	private String nombre;
	private EnumeracionTipoCliente tipoCliente;
}
