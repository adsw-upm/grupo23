package es.upm.dit.adsw.g23.clases.tema01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LineasRepetidasStream {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File("data/envios.txt"));
		Set<String> vistas = new HashSet<String>();
		while (scanner.hasNextLine()) {
			String linea = scanner.nextLine();
			if (vistas.contains(linea)){
				System.out.println("Línea repetida: " + linea);
			} else {
				vistas.add(linea);
			}
		}
		scanner.close();
	}
}
