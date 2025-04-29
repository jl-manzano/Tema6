package boletin1.datos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Datos {

	/*
	 * Diseña una aplicación que pida al usuario su nombre y edad. Estos datos deben
	 * guardarse en el fichero datos.txt. Si este fichero existe, deben añadirse al
	 * final en una nueva línea, y en caso de no existir, debe crearse.
	 */

	public static final String FICHERO = "src\\boletin1\\datos\\Datos.txt";

	public static void main(String[] args) {

		String nombre = "";
		int edad;

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Introduzca su nombre: ");
		nombre = sc.nextLine();
		System.out.println("\nIntroduzca su edad: ");
		edad = sc.nextInt();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {

			bw.write(nombre + ", " + edad + " años");
			bw.newLine();
			bw.flush();
			bw.close();
			

		} catch (IOException e) {
			System.out.println("Error: No se ha podido escribir en el fichero " + e.getMessage());
		}
		
		sc.close();

	}
}