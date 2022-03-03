package com.ceiba.examen.comando;

import java.time.LocalDateTime;

import com.ceiba.certificacion.comando.ComandoCertificacion;
import com.ceiba.cliente.comando.ComandoCliente;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoExamen{

    private Long id;
    private ComandoCliente comandoCliente;
    private ComandoCertificacion comandoCertificacion;
    private LocalDateTime fechaPresentacion;
    private Double precioTotal;
}
