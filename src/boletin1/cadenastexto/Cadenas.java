package boletin1.cadenastexto;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cadenas {

	/*
	 * Diseña un programa que le pida cadenas de texto al usuario y que deje de
	 * pedirlas cuando el usuario introduzca “fin”. Se debe ir almacenando en un
	 * fichero cada cadena de texto introducida por el usuario, añadiendo un salto
	 * de línea al final de cada cadena.
	 */

	public static final String FICHERO = "src\\boletin1\\cadenastexto\\Cadenas.txt";

	public static void main(String[] args) {

		String cadena = "";

		Scanner sc = new Scanner(System.in);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {

			System.out.println("Introduzca una cadena de texto: ");
			cadena = sc.nextLine();

			while (!cadena.equalsIgnoreCase("fin")) {
				bw.write(cadena);
				bw.newLine();

				System.out.println("\nIntroduzca una cadena de texto: ");
				cadena = sc.nextLine();
			}
			
			bw.flush();
			bw.close();
			sc.close();

		} catch (IOException e) {
			System.out.println("Error: No se ha podido escribir en el fichero " + e.getMessage());
		}

	}
}