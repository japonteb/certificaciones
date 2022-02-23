package com.ceiba.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ceiba.certificacion.puerto.repositorio.RepositorioCertificacion;
import com.ceiba.certificacion.servicio.ServicioActualizarCertificacion;
import com.ceiba.certificacion.servicio.ServicioCrearCertificacion;
import com.ceiba.certificacion.servicio.ServicioEliminarCertificacion;
import com.ceiba.examen.puerto.repositorio.RepositorioExamen;
import com.ceiba.examen.servicio.ServicioCrearExamen;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;

@Configuration
public class BeanServicio {

	@Bean
	public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioCrearUsuario(repositorioUsuario);
	}

	@Bean
	public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioEliminarUsuario(repositorioUsuario);
	}

	@Bean
	public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
		return new ServicioActualizarUsuario(repositorioUsuario);
	}

	@Bean
	public ServicioCrearCertificacion servicioCrearCertificacion(RepositorioCertificacion repositorioCertificacion) {
		return new ServicioCrearCertificacion(repositorioCertificacion);
	}

	@Bean
	public ServicioEliminarCertificacion servicioEliminarCertificacion(
			RepositorioCertificacion repositorioCertificacion) {
		return new ServicioEliminarCertificacion(repositorioCertificacion);
	}

	@Bean
	public ServicioActualizarCertificacion servicioActualizarCertificacion(
			RepositorioCertificacion repositorioCertificacion) {
		return new ServicioActualizarCertificacion(repositorioCertificacion);
	}

	@Bean
	public ServicioCrearExamen servicioCrearExamen(RepositorioExamen repositorioExamen) {
		return new ServicioCrearExamen(repositorioExamen);
	}

}
