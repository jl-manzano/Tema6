package boletin1.enteros;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Enteros {
	public static void main(String[] args) {

		/*
		 * Implementar un programa que acceda a Enteros.txt con un
		 * objeto Scanner a través de un flujo de entrada, lea los números y calcule la
		 * suma y la media aritmética, mostrando los resultados por pantalla.
		 */

		int num;
		int suma = 0;
		int cont = 0;

		try (Scanner sc = new Scanner(new FileReader("src\\boletin1\\enteros\\Enteros.txt"))) {
			while (sc.hasNextInt()) {
				num = sc.nextInt();
				suma += num;
				cont++;
			}

			System.out.println("Suma: " + suma);
			System.out.printf("Media: %.2f", (double) suma / cont);

		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero: " + e.getMessage());
		}

	}
}
