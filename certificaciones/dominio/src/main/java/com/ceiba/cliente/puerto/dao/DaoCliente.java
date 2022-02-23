package com.ceiba.cliente.puerto.dao;

import java.util.List;

import com.ceiba.cliente.modelo.dto.DtoCliente;

public interface DaoCliente {

    /**
     * Permite listar clientes
     * @return los clientes
     */
    List<DtoCliente> listar();
    
    /**
     * Permite obtener un cliente por id
     * @param id
     * @return cliente
     */
    DtoCliente obtenerCliente(Long id);
}
