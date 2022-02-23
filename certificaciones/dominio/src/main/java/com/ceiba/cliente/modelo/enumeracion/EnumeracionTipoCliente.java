package com.ceiba.cliente.modelo.enumeracion;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumeracionTipoCliente {
	
	CLIENTE_TIPO_1(1,10),
	CLIENTE_TIPO_2(2,20),
	CLIENTE_TIPO_3(3,30),
	CLIENTE_TIPO_4(1,0);
	
	private int codigoTipoCliente;
	private int porcentajeDescuento;
	
	private static final String CODIGO_TIPO_DE_CLIENTE_INVALIDO = "El código del tipo de cliente es inválido";
	
	public static EnumeracionTipoCliente obtenerEnumeracionTipoClienteDeCodigo(int codigoTipoCliente) {
		for(EnumeracionTipoCliente tipoCliente : values()) {
			if(tipoCliente.codigoTipoCliente == codigoTipoCliente) {
				return tipoCliente;
			}
		}
		throw new ExcepcionValorInvalido(CODIGO_TIPO_DE_CLIENTE_INVALIDO);
	}
	
}
