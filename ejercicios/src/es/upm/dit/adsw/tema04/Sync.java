package es.upm.dit.adsw.tema04;

import java.util.List;

/**
 * Clase de ejemplo para demostrar el uso de métodos y bloques synchronized
 * @author j
 *
 */
public class Sync {
	private List<Integer> lista;
	
	public synchronized Integer getPrimero() throws InterruptedException {
		while(lista.isEmpty()) {
 			// Se libera el cerrojo de this al hacer wait
			this.wait();
		}
		return lista.remove(0);
	}
	/**
	 * Idéntico a getPrimero
	 * @return
	 * @throws InterruptedException
	 */
	public Integer getPrimero2() throws InterruptedException {
 		Integer elemento;
		synchronized(this) {
	 		while(lista.isEmpty()) {
	 			// Se libera el cerrojo de this al hacer wait
				this.wait();
			}
	 		elemento = lista.remove(0);
		}
		return elemento;
	}
	
	
	public synchronized void insertar(Integer i) {
		this.lista.add(i);
		this.notify();
	}
	
	public static void main(String[] args) throws InterruptedException {
		Sync s = new Sync();
		Integer res = null;
		while (res == null) {
			res = s.getPrimero();
		}
	}
}

