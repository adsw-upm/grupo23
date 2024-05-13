package es.upm.dit.adsw.g23.clases.tema03.fundamentos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Hebra02 extends Thread {
	Map<String, Integer> vecesLocal = new HashMap<>();
	String parte;
	public Hebra02(String parte) {
		this.parte = parte;
	}
	public void run() {
		System.out.print(".");
		Contador01Secuencial.contar(parte, vecesLocal);
	}
}

public class Contador02Concurrente extends Contador01Secuencial {
	public static Map<String, Integer> contar(String fichero) throws IOException {
		int nHebras = 4;
		List<String> partes = separar("data/Ulysses.txt", nHebras);

		System.out.print("Contando");
		List<Hebra02> hebras = new ArrayList<>();
		for(int i=0; i<nHebras; i++) {
			Hebra02 h = new Hebra02(partes.get(i));
			h.start();
			hebras.add(h);
		}

		Map<String, Integer> veces = new HashMap<>();
		for(Hebra02 h: hebras) {
			try {
				h.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(Entry<String, Integer> entry: h.vecesLocal.entrySet()) {
				veces.put(entry.getKey(), veces.getOrDefault(entry.getKey(), 0) + entry.getValue());
			}
		}
		return veces;
	}


}
