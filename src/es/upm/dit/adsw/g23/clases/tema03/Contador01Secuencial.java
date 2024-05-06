package es.upm.dit.adsw.g23.clases.tema03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Contador01Secuencial {
	public static List<String> separar(String fichero, int npartes) throws IOException {
		 Path path = Paths.get(fichero);
		 String content = Files.readString(path);
		 int chunkSize = content.length() / npartes;
		 List<String> partes = new ArrayList<>();
	 
		 int pos = 0;
		 for(int i=0; i<npartes; i++) {
			 int end = Math.min(pos + chunkSize, content.length());
			 while(end < content.length() && content.charAt(end) != '\n') {
				 end += 1;
			 }
			 partes.add(content.substring(pos, end));
			 pos = end;
		 }
		 
		 return partes;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println();
	    Map<String, Integer> veces = contar("data/Ulysses.txt");

		System.out.println("Veces:");
		System.out.println("the: " + veces.get("the"));
		System.out.println("a: " + veces.get("a"));
		System.out.println("Ulysses: " + veces.get("ulysses"));

	}

	public static Map<String, Integer> contar(String fichero) throws IOException {
		List<String> partes = separar("data/Ulysses.txt", 4);
		for(String parte: partes) {
			System.out.println("Parte: ..." + parte.substring(parte.length()-10, parte.length()) +" Tamaño: " + parte.length());
		}
		System.out.print("Contando");
		Map<String, Integer> veces = new HashMap<>();
		for(String parte: partes) {
			System.out.print(".");
			contar(parte, veces);
		}
		return veces;
	}

	protected static void contar(String parte, Map<String, Integer> veces) {
		for(String palabra: parte.split("\\W+")) {
			palabra = palabra.toLowerCase();
			veces.put(palabra, veces.getOrDefault(palabra, 0) + 1);
		}
	}

}
