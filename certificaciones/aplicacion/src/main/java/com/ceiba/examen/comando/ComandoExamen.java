package com.ceiba.examen.comando;

import java.time.LocalDateTime;

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
    private Long clienteId;
    private Long certificacionId;
    private LocalDateTime fechaPresentacion;
    private Double precioTotal;
}
