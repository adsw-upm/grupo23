package es.upm.dit.adsw.g23.clases.tema01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineasRepetidas03 extends LineasRepetidas02 {
	// No necesitamos declarar este método, porque lo heredamos de LineasRepetidas02
	//public static List<String> getLineas(String filename) throws IOException ...
	
	public static void main(String[] args) throws IOException {
		List<String> lineas = getLineas("envios.txt");
		List<String> vistas = new ArrayList<String>();
		for(int i =0; i<lineas.size(); i++) {
			for(int j=0; j<vistas.size(); j++) {
				if(lineas.get(i).equals(vistas.get(j))) {
					System.out.println("Línea repetida: " + lineas.get(i));
				}
			}
			vistas.add(lineas.get(i));
		}
	}

}
