package com.ceiba.examen.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.examen.modelo.entidad.Examen;
import com.ceiba.examen.puerto.repositorio.RepositorioExamen;

public class ServicioCrearExamen {

	private static final String EL_EXAMEN_YA_ESTA_PROGRAMADO_EN_EL_SISTEMA = "El examen ya está programado en el sistema";

	private final RepositorioExamen repositorioExamen;

	public ServicioCrearExamen(RepositorioExamen repositorioExamen) {
		this.repositorioExamen = repositorioExamen;
	}

	public Long ejecutar(Examen examen) {
		validarExistenciaPrevia(examen);
		
		return this.repositorioExamen.crear(examen);
	}

	private void validarExistenciaPrevia(Examen examen) {
		boolean existe = this.repositorioExamen.existe(examen.getCliente().getId(), examen.getCertificacion().getId());
		if (existe) {
			throw new ExcepcionDuplicidad(EL_EXAMEN_YA_ESTA_PROGRAMADO_EN_EL_SISTEMA);
		}
	}
}
