package es.upm.dit.adsw.g23.clases.tema03.bloqueos;

public class Filosofo02Concurrente extends Filosofo01 implements Runnable {

	public Filosofo02Concurrente(int numero, Palillo izq, Palillo dcha) {
		super(numero, izq, dcha);
	}
	
	public Filosofo02Concurrente(int numero, Palillo izq, Palillo dcha, int espera) {
		super(numero, izq, dcha, espera);
	}

	public void run() {
		while(true) {
			comer();
		}
	}

}
