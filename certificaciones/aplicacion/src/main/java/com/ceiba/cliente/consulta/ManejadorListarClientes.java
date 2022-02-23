package com.ceiba.cliente.consulta;

import java.util.List;

import com.ceiba.cliente.puerto.dao.DaoCliente;
import org.springframework.stereotype.Component;

import com.ceiba.cliente.modelo.dto.DtoCliente;

@Component
public class ManejadorListarClientes {

    private final DaoCliente daoCliente;

    public ManejadorListarClientes(DaoCliente daoCliente){
        this.daoCliente = daoCliente;
    }

    public List<DtoCliente> ejecutar(){ return this.daoCliente.listar(); }
}
