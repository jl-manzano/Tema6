package boletin1.enterosorden;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class EnterosOrdenados {

	public static final String FICHERO1 = "src\\boletin1\\enterosorden\\enterosDes.txt";
	public static final String FICHERO2 = "src\\boletin1\\enterosorden\\enterosOrden.txt";

	public static void main(String[] args) {
		ArrayList<Integer> numOrd = new ArrayList<Integer>();

		try (BufferedReader br = new BufferedReader(new FileReader(FICHERO1))) {
			String numero = br.readLine();

			while (numero != null) {
				numOrd.add(Integer.parseInt(numero));
				numero = br.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("No se ha encontrado el fichero: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("No se ha podido leer el fichero: " + e.getMessage());
		}

		Collections.sort(numOrd);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHERO2, true))) {
			for (int numero : numOrd) {
				bw.write(String.valueOf(numero));
				bw.newLine();
			}

			bw.flush();

		} catch (IOException e) {
			System.out.println("Error: No se ha podido escribir en el fichero " + e.getMessage());
		}

	}
}
