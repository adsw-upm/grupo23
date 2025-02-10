package es.upm.dit.adsw.g23.clases.tema01;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

public class LineasRepetidas {
	public static void main(String[] args) throws FileNotFoundException {
		String[] lineas = {"10", "20", "30", "20"};
		for(int i=0; i<lineas.length; i++) {
			for(int j=0; j<lineas.length; j++) {
				if(i == j) {
					if(lineas[i] == lineas[j]) {
						System.out.println("Línea repetida" + lineas[i]);
					}
				}
			}
		}
	}

}
