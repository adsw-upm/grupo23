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

public class LineasRepetidas02 {
	public static List<String> getLineas(String filename) throws IOException {
		List<String> list = Files.readAllLines(Paths.get(filename), Charset.defaultCharset() );
		return list;
	}
	
	public static void main(String[] args) throws IOException {
		List<String> lineas = getLineas("envios.txt");
		for(int i =0; i<lineas.size(); i++) {
			for(int j=0; j<lineas.size(); j++) {
				if(i != j) {
					if(lineas.get(i).equals(lineas.get(j))) {
						System.out.println("Línea repetida: " + lineas.get(i));
					}
				}
			}
		}
	}

}
