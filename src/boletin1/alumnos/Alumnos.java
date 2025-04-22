package boletin1.alumnos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Alumnos {
	public static void main(String[] args) {
		/*
		 * Implementa un programa que lea del fichero los datos, muestre los nombres y
		 * calcule la media de la edad y de las estaturas, mostrándolas por pantalla.
		 * (Integer.parseInt, Double.parseDouble).
		 */

		String nombre = "";
		int edad;
		int sumaEdades = 0;
		int contador = 0;
		double altura;
		double sumaAlturas = 0;

		try (BufferedReader br = new BufferedReader(new FileReader("src\\boletin1\\alumnos\\Alumnos.txt"))) {

			String linea = br.readLine();

			while (linea != null) {
				String datos[] = linea.split(" ");

				nombre = datos[0];

				edad = Integer.parseInt(datos[1]);

				altura = Double.parseDouble(datos[2]);

				System.out.println("Nombre: " + nombre);

				sumaEdades += edad;

				sumaAlturas += altura;

				contador++;

				linea = br.readLine();

			}

			if (contador > 0) {
				System.out.printf("Media de edad: %.2f\n", (double) sumaEdades / contador);
				System.out.printf("Media de estatura: %.2f", sumaAlturas / contador);
			} else {
				System.out.println("No hay datos para calcular.");
			}

		} catch (IOException e) {
			System.out.println("Error al escribir en el fichero: " + e.getMessage());
		}

	}

}
