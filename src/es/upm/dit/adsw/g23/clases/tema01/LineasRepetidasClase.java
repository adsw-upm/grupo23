package es.upm.dit.adsw.g23.clases.tema01;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Implementación (incompleta y con error) de LineasRepetidas hecha en clase
 * Se debe encontrar el fallo.
 */
public class LineasRepetidasClase {
	public static int contarRepetidas(String[] lineas) {
		int repetidas = 0;
		for(int i =0; i < lineas.length; i++) {
			String linea = lineas[i];
			for(int j=0; j<i; j++) {
				String otra = lineas[j];
				if(linea == otra) {
					repetidas += 1;
					break;
				}
			}
		}
		return repetidas;
	}

	/**
	 * Estamos usando String[] en lugar de List<String> porque es la decisión que tomamos en clase.
	 * El problema de utilizar un array es que hay que conocer su tamaño de antemano. Por ello, en esta
	 * solución lo que hacemos es primero crear una lista, y luego la convertimos en un array.
	 *
	 * En un código real, usaríamos directamente List<String>. De ahí que lo usemos en el resto de clases.
	 *
	 */
	public static String[] leerLineas(String filename) throws IOException {
		List<String> list = Files.readAllLines(Paths.get(filename), Charset.defaultCharset());
		String[] array = new String[list.size()];
		list.toArray(array);
		return array;
	}
	
	public static void main(String[] args) throws IOException {
		String[] lineas = leerLineas("data/envios.txt");
		int repetidas = contarRepetidas(lineas);
		System.out.println("Se han repetido: " + repetidas);
	}

}
