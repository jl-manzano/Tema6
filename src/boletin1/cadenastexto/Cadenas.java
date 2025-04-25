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

		String palabra = "";

		Scanner sc = new Scanner(System.in);

		System.out.println("CADENAS\n-------");

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {

			do {
				System.out.println("\nIntroduce una palabra: ");
				palabra = sc.nextLine();
				bw.write(palabra);
				bw.newLine();
			} while (!palabra.equalsIgnoreCase("fin"));

			bw.close();
		} catch (IOException e) {
			System.out.println("Error: No se ha podido escribir en el fichero " + e.getMessage());
		}
	}
}