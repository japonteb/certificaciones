package com.ceiba.cliente.consulta;

import org.springframework.stereotype.Component;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;

@Component
public class ManejadorListarClientePorId {

	private final DaoCliente daoCliente;

	public ManejadorListarClientePorId(DaoCliente daoCliente) {
		this.daoCliente = daoCliente;
	}

	public DtoCliente ejecutar(Long idCliente) {
		return this.daoCliente.obtenerCliente(idCliente);
	}
}
