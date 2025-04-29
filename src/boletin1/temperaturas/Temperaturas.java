package boletin1.temperaturas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Temperaturas {

	public static final String FICHERO = "src\\boletin1\\temperaturas\\Temperaturas.txt";
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion;
		
		do {
			menu();
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch(opcion) {
			case 1 -> {
				System.out.println("\nREGISTRAR TEMPERATURA\n");
				registrarTemp();
			}
			case 2 -> {
				System.out.println("\nREGISTRO DE TEMPERATURAS");
				mostrarRegistro();
			}
			case 3 -> System.out.println("\nSALIENDO ...");
			default -> System.out.println("\nOpción no válida");
			}
			
		} while(opcion != 3);
		
	}

	public static void mostrarRegistro() {

		String cadena = "";

		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO))) {

			cadena = br.readLine();

			while (cadena != null) {
				System.out.println(cadena);
				cadena = br.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("No se ha podido leer el fichero: " + e.getMessage());
		}

	}

	public static void registrarTemp() {
		String fecha;
		int min;
		int max;

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {
			
			BufferedReader br = new BufferedReader(new FileReader(FICHERO));
			
			if (br.readLine() == null ) {
				bw.write("Fecha, Temperatura máxima, Temperatura mínima");
				bw.newLine();
				br.close();
			}
			
			System.out.println("\nIntroduzca la fecha (año-mes-dia): ");
			fecha = sc.nextLine();

			System.out.println("\nIntroduzca la temperatura máxima: ");
			max = sc.nextInt();
			
			System.out.println("\nIntroduzca la temperatura mínima: ");
			min = sc.nextInt();

			bw.write(fecha + "," + max + "," + min);
			bw.newLine();
			bw.flush();


		} catch (IOException e) {
			System.out.println("No se ha podido leer el fichero: " + e.getMessage());
		}

	}
	
	public static void menu() {
		System.out.println("\nTEMPERATURAS\n===========\n");
		System.out.println("Introduzca una opción:");
		System.out.println("1. Registra nueva temperatura.");
		System.out.println("2. Mostrar historial de registros.");
		System.out.println("3. Salir.");

	}

}
