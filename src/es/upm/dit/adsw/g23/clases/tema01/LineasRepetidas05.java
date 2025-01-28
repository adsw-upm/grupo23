package es.upm.dit.adsw.g23.clases.tema01;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LineasRepetidas05 extends LineasRepetidas02 {
	
	public static int contarRepetidas(List<String> lineas) {
		Set<String> vistas = new HashSet<String>();
		int repetidas = 0;
		for(String linea: lineas) {
			if(vistas.contains(linea)) {
				System.out.println("Línea repetida: " + linea);
				repetidas += 1;
				continue;
			}
			vistas.add(linea);
		}
		return repetidas;
	}
	
	public static void main(String[] args) throws IOException {
		List<String> lineas = getLineas("envios.txt");
		contarRepetidas(lineas);
	}

}
