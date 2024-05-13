package es.upm.dit.adsw.g23.clases.tema03.bloqueos;

public class Filosofos02Concurrente {

	public static void main(String[] args) throws InterruptedException {
		int numFilosofos = 2;
		int numPalillos = numFilosofos;
		Palillo[] palillos = new Palillo[numPalillos];
		for(int i=0; i<numPalillos; i++) {
			palillos[i] = new Palillo();
		}
		Thread[] hebras = new Thread[numFilosofos];
		for(int i=0; i<numFilosofos; i++) {
			int izq = i;
			int dcha = (i+1) % numPalillos;
			Thread f = new Thread(new Filosofo02Concurrente(i, palillos[izq], palillos[dcha]));
			hebras[i] = f;
			f.start();
		}
		for(int i=0; i<numFilosofos; i++) {
			hebras[i].join();
		}
	}
}
