package boletin1.datos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Datos {

	/*
	 * Diseña un programa que le pida cadenas de texto al usuario y que deje de
	 * pedirlas cuando el usuario introduzca “fin”. Se debe ir almacenando en un
	 * fichero cada cadena de texto introducida por el usuario, añadiendo un salto
	 * de línea al final de cada cadena.
	 */

	public static final String FICHERO = "src\\boletin1\\datos\\Datos.txt";

	public static void main(String[] args) {

		String nombre = "";

		int edad;

		Scanner sc = new Scanner(System.in);

		System.out.println("FORMULARIO\n----------");

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {

				System.out.println("\nIntroduce tu nombre: ");
				nombre = sc.nextLine();
				bw.write("Nombre: " + nombre);
				bw.newLine();
								
				System.out.println("\nIntroduce tu edad: ");
				edad = sc.nextInt();
				bw.write("Edad: " + edad);
				bw.flush();
				bw.close();
				
		} catch (IOException e) {
			System.out.println("Error: No se ha podido escribir en el fichero " + e.getMessage());
		}
		
		sc.close();
	}
}