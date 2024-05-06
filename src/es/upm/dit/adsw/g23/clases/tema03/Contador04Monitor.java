package es.upm.dit.adsw.g23.clases.tema03;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Hebra04 extends Thread {
	Monitor veces;
	String parte;
	public Hebra04(String parte, Monitor veces) {
		this.parte = parte;
		this.veces = veces;
	}
	public void run() {
		System.out.print(".");
		Map<String, Integer> vecesLocal = new HashMap<>();
		Contador01Secuencial.contar(parte, vecesLocal);
		for(Entry<String, Integer> entry: vecesLocal.entrySet()) {
				veces.aumentar(entry.getKey(), entry.getValue());
		}	
	}
}

class Monitor {
	private Map<String, Integer> veces;
	
	public Monitor() {
		this.veces = new HashMap<>();
	}
	
	public synchronized void aumentar(String clave, Integer valor) {
		this.veces.put(clave, valor + this.veces.getOrDefault(clave, 0));
	}
	
	public Map<String, Integer> valores() {
		return new HashMap<String, Integer>(this.veces);
	}
}

public class Contador04Monitor extends Contador01Secuencial {
	public static Map<String, Integer> contar(String fichero) throws IOException {
		int nHebras = 4;
		List<String> partes = separar("data/Ulysses.txt", nHebras);
		Monitor monitor = new Monitor();
		System.out.print("Contando");
		List<Hebra04> hebras = new ArrayList<>();
		for(int i=0; i<nHebras; i++) {
			Hebra04 h = new Hebra04(partes.get(i), monitor);
			h.start();
			hebras.add(h);
		}

		for(Hebra04 h: hebras) {
			try {
				h.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return monitor.valores();
	}
}
