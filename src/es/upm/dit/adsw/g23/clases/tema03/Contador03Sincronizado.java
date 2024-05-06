package es.upm.dit.adsw.g23.clases.tema03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Hebra03 extends Thread {
	Map<String, Integer> veces = new HashMap<>();
	String parte;
	public Hebra03(String parte, Map<String, Integer> veces) {
		this.parte = parte;
		this.veces = veces;
	}
	public void run() {
		System.out.print(".");
		Map<String, Integer> vecesLocal = new HashMap<>();
		Contador01Secuencial.contar(parte, vecesLocal);
		synchronized(veces) {
			for(Entry<String, Integer> entry: vecesLocal.entrySet()) {
					veces.put(entry.getKey(), veces.getOrDefault(entry.getKey(), 0) + entry.getValue());
			}	
		}
	}
}

public class Contador03Sincronizado extends Contador01Secuencial {
	public static Map<String, Integer> contar(String fichero) throws IOException {
		int nHebras = 4;
		List<String> partes = separar("data/Ulysses.txt", nHebras);
		Map<String, Integer> veces = new HashMap<>();

		System.out.print("Contando");
		List<Hebra03> hebras = new ArrayList<>();
		for(int i=0; i<nHebras; i++) {
			Hebra03 h = new Hebra03(partes.get(i), veces);
			h.start();
			hebras.add(h);
		}

		for(Hebra03 h: hebras) {
			try {
				h.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return veces;
	}
}
