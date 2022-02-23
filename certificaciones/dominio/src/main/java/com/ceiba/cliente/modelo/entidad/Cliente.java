package com.ceiba.cliente.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import com.ceiba.cliente.modelo.enumeracion.EnumeracionTipoCliente;

import lombok.Getter;

@Getter
public class Cliente {

	private static final String SE_DEBE_INGRESAR_EL_TIPO_DE_CLIENTE = "Se debe ingresar el tipo de cliente";
	private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE = "Se debe ingresar el nombre del cliente";

	private Long id;
	private String nombre;
	private EnumeracionTipoCliente tipoCliente;

	public Cliente(Long id, String nombre, EnumeracionTipoCliente tipoCliente) {
		validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_CLIENTE);
		validarObligatorio(tipoCliente, SE_DEBE_INGRESAR_EL_TIPO_DE_CLIENTE);

		this.id = id;
		this.nombre = nombre;
		this.tipoCliente = tipoCliente;
	}

}
