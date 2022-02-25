package com.ceiba.utilidad;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class UtilidadesFecha {

	private UtilidadesFecha() {
	    throw new IllegalStateException("Clase de utilidades de fecha");
	}
	
	public static final Set<LocalDate> FESTIVOS;

	static {
		Set<LocalDate> festivosTemporal = new HashSet<>();

		festivosTemporal.add(LocalDate.of(2022, 1, 1));
		festivosTemporal.add(LocalDate.of(2022, 1, 10));
		festivosTemporal.add(LocalDate.of(2022, 3, 21));
		festivosTemporal.add(LocalDate.of(2022, 4, 14));
		festivosTemporal.add(LocalDate.of(2022, 4, 15));
		festivosTemporal.add(LocalDate.of(2022, 5, 1));
		festivosTemporal.add(LocalDate.of(2022, 5, 30));
		festivosTemporal.add(LocalDate.of(2022, 6, 20));
		festivosTemporal.add(LocalDate.of(2022, 6, 27));
		festivosTemporal.add(LocalDate.of(2022, 7, 4));
		festivosTemporal.add(LocalDate.of(2022, 7, 20));
		festivosTemporal.add(LocalDate.of(2022, 8, 7));
		festivosTemporal.add(LocalDate.of(2022, 8, 15));
		festivosTemporal.add(LocalDate.of(2022, 10, 17));
		festivosTemporal.add(LocalDate.of(2022, 11, 7));
		festivosTemporal.add(LocalDate.of(2022, 11, 14));
		festivosTemporal.add(LocalDate.of(2022, 12, 8));
		festivosTemporal.add(LocalDate.of(2022, 12, 25));

		FESTIVOS = Collections.unmodifiableSet(festivosTemporal);
	}

	public static boolean esFestivo(LocalDate fecha) {
		return FESTIVOS.contains(fecha);
	}

	public static boolean esFinDeSemana(LocalDate fecha) {
		return (fecha.getDayOfWeek().equals(DayOfWeek.SATURDAY)
				|| fecha.getDayOfWeek().equals(DayOfWeek.SUNDAY));
		
	}

}
