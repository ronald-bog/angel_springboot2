package com.example.borrar3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Period;

@SpringBootApplication
public class Borrar3Application {

	public static void main(String[] args) {
		SpringApplication.run(Borrar3Application.class, args);

		LocalDate fechaNacimiento = LocalDate.of(2001, 12, 30);

		// Calcular la edad en years
		int edad = calcularEdad(fechaNacimiento, LocalDate.now());

		// Calcular la edad clínica acción
		String edadClinica = calcularEdadClinica(fechaNacimiento, LocalDate.now());

		// Imprimir resultados
		System.out.println(edad);
		System.out.println(edadClinica);
	}
	// Método para calcular la edad en years
	public static int calcularEdad(LocalDate fechaNacimiento, LocalDate fechaActual) {
		return Period.between(fechaNacimiento, fechaActual).getYears();
	}

	// Método para calcular la edad clínica
	public static String calcularEdadClinica(LocalDate fechaNacimiento, LocalDate fechaActual) {
		Period period = Period.between(fechaNacimiento, fechaActual);
		int years = period.getYears();
		int meses = period.getMonths();
		int dias = period.getDays();

		// Construir la cadena de texto
		StringBuilder edadClinicaBuilder = new StringBuilder();
		if (years > 0) {
			edadClinicaBuilder.append(years).append(" years");
		}
		if (meses > 0) {
			if (!edadClinicaBuilder.isEmpty()) {
				edadClinicaBuilder.append(" ");
			}
			edadClinicaBuilder.append(meses).append(" meses");
		}
		if (dias > 0) {
			if (!edadClinicaBuilder.isEmpty()) {
				edadClinicaBuilder.append(" ");
			}
			edadClinicaBuilder.append(dias).append(" días");
		}

		return edadClinicaBuilder.toString();
	}
}
//prueba
