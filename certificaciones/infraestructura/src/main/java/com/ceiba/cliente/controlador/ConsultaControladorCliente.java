package com.ceiba.cliente.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.cliente.consulta.ManejadorListarClientePorId;
import com.ceiba.cliente.consulta.ManejadorListarClientes;
import com.ceiba.cliente.modelo.dto.DtoCliente;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/clientes")
@Api(tags = { "Controlador consulta cliente" })
public class ConsultaControladorCliente {

	private final ManejadorListarClientes manejadorListarClientes;
	private final ManejadorListarClientePorId manejadorListarClientePorId;

	public ConsultaControladorCliente(ManejadorListarClientes manejadorListarClientes,
			ManejadorListarClientePorId manejadorListarClientePorId) {
		this.manejadorListarClientes = manejadorListarClientes;
		this.manejadorListarClientePorId = manejadorListarClientePorId;
	}

	@GetMapping
	@ApiOperation("Listar Clientes")
	public List<DtoCliente> listar() {
		return this.manejadorListarClientes.ejecutar();
	}

	@GetMapping(value = "/{id}")
	@ApiOperation("Obtener cliente por id")
	public void obtenerClientePorId(@PathVariable Long id) {
		manejadorListarClientePorId.ejecutar(id);
	}

}
