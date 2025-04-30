package boletin2.ejercicio01;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio01 {

	public static final String FICHERO = "src\\boletin2\\ejercicio01\\carta.txt";

	public static void main(String[] args) {
		String linea;
		int contLineas = 0;
		int contCaracteres = 0;
		int contPalabras = 0;

		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {
			linea = br.readLine();

			while (linea != null) {
				contLineas++;
				contCaracteres = linea.length();
				for (int i = 0; i < linea.length(); i++) {
					if (linea.charAt(i) == ' ') {
						contPalabras++;
					}
				}
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("No se ha podido leer el fichero: " + e.getMessage());
		}
		
		System.out.println("\nLíneas: " + contLineas + ", Palabras: " + contPalabras + ", Caracteres: " + contCaracteres);

	}
}
