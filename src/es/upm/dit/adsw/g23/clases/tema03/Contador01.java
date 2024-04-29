package es.upm.dit.adsw.g23.clases.tema03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Contador01 {
	public static List<String> separar(String fichero, int npartes) throws IOException {
		 Path path = Paths.get(fichero);
		 String content = Files.readString(path);
		 int chunkSize = content.length() / npartes;
		 List<String> partes = new ArrayList<>();
	 
		 int pos = 0;
		 for(int i=0; i<npartes; i++) {
			 System.out.println(pos);
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
		List<String> partes = separar("data/Ulysses.txt", 4);
		for(String parte: partes) {
			System.out.println("Parte: ..." + parte.substring(parte.length()-10, parte.length()) +" Tamaño: " + parte.length());
		}
	}

}
