package es.upm.dit.adsw.g23.clases.tema01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineasRepetidas04 extends LineasRepetidas02 {
	
	public static void main(String[] args) throws IOException {
		List<String> lineas = getLineas("envios.txt");
		List<String> vistas = new ArrayList<String>();
		for(String linea: lineas) {
			for(String vista: vistas) {
				if(linea.equals(vista)) {
					System.out.println("Línea repetida: " + linea);
					continue;
				}
			}
			vistas.add(linea);
		}
	}

}
