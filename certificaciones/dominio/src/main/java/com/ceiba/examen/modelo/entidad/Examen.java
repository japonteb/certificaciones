package com.ceiba.examen.modelo.entidad;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

import java.time.LocalDateTime;

import com.ceiba.certificacion.modelo.entidad.Certificacion;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.utilidad.UtilidadesFecha;

import lombok.Getter;

@Getter
public class Examen {

	private static final String SE_DEBE_INGRESAR_LA_FECHA_DE_PRESENTACION_DEL_EXAMEN = "Se debe ingresar la fecha de presentación del examen";
	private static final String SE_DEBE_INGRESAR_EL_CLIENTE_DEL_EXAMEN = "Se debe ingresar el cliente que va a presentar el examen";
	private static final String SE_DEBE_INGRESAR_LA_CERTIFICACION_DEL_EXAMEN = "Se debe ingresar la certificación del examen";

	private Long id;
	private Cliente cliente;
	private Certificacion certificacion;
	private LocalDateTime fechaPresentacion;
	private Double precioTotal;

	public Examen(Long id, Cliente cliente, Certificacion certificacion, LocalDateTime fechaPresentacion) {
		validarObligatorio(cliente, SE_DEBE_INGRESAR_EL_CLIENTE_DEL_EXAMEN);
		validarObligatorio(certificacion, SE_DEBE_INGRESAR_LA_CERTIFICACION_DEL_EXAMEN);
		validarObligatorio(fechaPresentacion, SE_DEBE_INGRESAR_LA_FECHA_DE_PRESENTACION_DEL_EXAMEN);

		this.id = id;
		this.cliente = cliente;
		this.certificacion = certificacion;
		this.fechaPresentacion = fechaPresentacion;
		this.precioTotal = this.calcularPrecioTotal();
	}

	private Double calcularPrecioTotal() {

		Double precio = this.certificacion.getPrecio();
		if (UtilidadesFecha.esFestivo(this.fechaPresentacion.toLocalDate())) {
			precio = precio * 3;
		} else if (UtilidadesFecha.esFinDeSemana(this.fechaPresentacion.toLocalDate())) {
			precio = precio * 2;
		}

		precio = ((100 - this.cliente.getTipoCliente().getPorcentajeDescuento()) * precio) / 100;

		return precio;
	}

}
