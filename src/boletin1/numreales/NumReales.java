package boletin1.numreales;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class NumReales {
	public static void main(String[] args) {
		/*
		 * Crea con un editor el fichero de texto NumerosReales.txt en un paquete dentro
		 * del proyecto. Escribe en él una serie de números reales separados por
		 * espacios simples. Implementar un programa que acceda a NumerosReales.txt, lea
		 * los números y calcule la suma y la media aritmética, mostrando los resultados
		 * por pantalla.
		 */

		double num;
		double suma = 0;
		int cont = 0;

		try (Scanner sc = new Scanner(new FileReader("src\\boletin1\\numreales\\NumReales.txt"))) {
			while (sc.hasNextDouble()) {
				num = sc.nextDouble();
				suma += num;
				cont++;
			}
			
			System.out.println("Suma: " + suma);
			System.out.println("Media: " + (suma / cont));
			
		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero: " + e.getMessage());
		}

	}
}
