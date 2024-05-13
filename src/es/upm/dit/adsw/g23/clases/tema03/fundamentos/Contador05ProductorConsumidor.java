package es.upm.dit.adsw.g23.clases.tema03.fundamentos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class Contador05ProductorConsumidor extends Contador01Secuencial {
	public static Map<String, Integer> contar(String fichero) throws IOException {
		int nHebras = 4;
		Buffer buffer = new Buffer();
		List<Thread> hebras = new ArrayList<>();
		Monitor monitor = new Monitor();

		for(int i=0; i<nHebras; i++) {
			Thread h = new Consumidor(buffer, monitor);
			h.start();
			hebras.add(h);
		}
		Thread productor = new Productor(fichero, buffer);
		productor.start();
		
		for(Thread h: hebras) {
			try {
				h.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return monitor.valores();
	}
}


class Productor extends Thread {
	String fichero;
	Buffer buffer;
	static final int nPartes = 100;
	static final int espera = 0;
	public Productor(String fichero, Buffer buffer) {
		this.fichero = fichero;
		this.buffer = buffer;
	}
	public void run() {
		try {
			for(String parte: Contador01Secuencial.separar("data/Ulysses.txt", nPartes)) {
				buffer.put(parte);
				try {
					Thread.sleep(espera);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		buffer.close();
	}

}

class Consumidor extends Thread {
	Monitor veces;
	Buffer partes;
	public Consumidor(Buffer partes, Monitor veces) {
		this.partes = partes;
		this.veces = veces;
	}
	public void run() {
		System.out.print(".");
		Map<String, Integer> vecesLocal;
		while(true) {
			String parte;
			try {
				parte = partes.pop();
			} catch (InterruptedException e) {
				break;
			}
			if(parte == null) {
				break;
			}
			vecesLocal = new HashMap<>();
			Contador01Secuencial.contar(parte, vecesLocal);
			for(Entry<String, Integer> entry: vecesLocal.entrySet()) {
				veces.aumentar(entry.getKey(), entry.getValue());
			}	
		}
	}

}

class Buffer {
	private List<String> partes;
	private boolean terminado;
	public Buffer() {
		this.partes = new ArrayList<>();
		this.terminado = false;
	}
	
	public synchronized String pop() throws InterruptedException {
		while(this.partes.isEmpty()) {
			if(this.terminado) {
				return null;
			}
			this.wait();
		}
		return this.partes.remove(0);
	}
	
	public synchronized void put(String parte) {
		this.partes.add(parte);
		this.notify();
	}
	
	public synchronized void close() {
		this.terminado = true;
		this.notifyAll();
	}
}