package com.ceiba.examen.consulta;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ceiba.examen.modelo.dto.DtoExamenCertificacion;
import com.ceiba.examen.puerto.dao.DaoExamen;

@Component
public class ManejadorListarExamen {

	private final DaoExamen daoExamen;

	public ManejadorListarExamen(DaoExamen daoExamen) {
		this.daoExamen = daoExamen;
	}

	public List<DtoExamenCertificacion> ejecutar(Long idCliente) {
		return this.daoExamen.listarPorClienteId(idCliente);
	}
}
