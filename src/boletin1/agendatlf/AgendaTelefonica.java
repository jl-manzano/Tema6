package boletin1.agendatlf;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AgendaTelefonica {

	public static final String FICHERO = "src\\boletin1\\agendatlf\\AgendaTelefonica.txt";

	public static void main(String[] args) {
		TreeMap<String, Integer> agenda = new TreeMap<>();

		int opcion;

		String nombre = "";
		int tlf;

		Scanner sc = new Scanner(System.in);
		
		do {
			
			mostrarMenu();
			opcion = sc.nextInt();
			sc.nextLine();
			
			switch (opcion) {
			case 1 -> {
				System.out.println("\nAÑADIR EN LA AGENDA\n-------------------");
				System.out.println("\nIntroduzca el nombre de la persona a añadir en la agenda:");
				nombre = sc.nextLine();
				System.out.println("\nIntroduzca su numero de teléfono:");
				tlf = sc.nextInt();
				sc.nextLine();

				if (agenda.size() == 20) {
					System.out.println("\nLa agenda ya está llena (20 contactos).");
				} else if (agenda.containsKey(nombre)) {
					System.out.println("\nEse nombre ya está en la agenda, no es posible añadirlo.");
				} else {
					agenda.put(nombre, tlf);
					System.out.println("\nContacto añadido con éxito.");
				}
			}
			case 2 -> {
				System.out.println("\nBUSCAR EN LA AGENDA\n-------------------\n");
				System.out.println("Introduce el nombre que quiere buscar:");
				nombre = sc.nextLine();

				Integer tlfBuscar = agenda.get(nombre);

				if (tlfBuscar != null) {
					System.out.println("\nTeléfono de " + nombre + ": " + tlfBuscar);
				} else {
					System.out.println("Nombre no encontrado en la agenda telefónica.");
				}

			}
			case 3 -> {
				System.out.println("\nMOSTRAR TODOS\n------------");
				for (Map.Entry<String, Integer> contacto : agenda.entrySet()) {
					System.out.println(contacto.getKey() + ": " + contacto.getValue());
				}
			}
			case 4 -> {
				System.out.println("\nSALIENDO...");
			}
			
			default -> System.out.println("\nOpción no válida");
			
			}
						
		} while(opcion != 4);
		
		guardarEnAgenda(agenda);
		
		sc.close();
		
	}

	public static void guardarEnAgenda(TreeMap<String, Integer> agenda) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO, true))) {
			for (Map.Entry<String, Integer> contacto : agenda.entrySet()) {
				bw.write(contacto.getKey() + ": " + contacto.getValue());
				bw.newLine();
			}

			bw.flush();

		} catch (IOException e) {
			System.out.println("No se ha podido leer el fichero: " + e.getMessage());
		}

	}

	static void mostrarMenu() {
		System.out.println("\nAGENDA TELEFÓNICA\n=================");
		System.out.println("Elige una opción:");
		System.out.println("1. Nuevo contacto.");
		System.out.println("2. Buscar por nombre.");
		System.out.println("3. Mostrar todos.");
		System.out.println("4. Salir.");
	}
}
