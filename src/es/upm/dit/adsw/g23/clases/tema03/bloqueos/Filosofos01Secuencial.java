package es.upm.dit.adsw.g23.clases.tema03.bloqueos;

public class Filosofos01Secuencial {

	public static void main(String[] args) throws InterruptedException {
		int numFilosofos = 5;
		Palillo[] palillos = new Palillo[numFilosofos];
		for(int i=0; i<numFilosofos; i++) {
			palillos[i] = new Palillo();
		}
		for(int i=0; i<numFilosofos; i++) {
			int izq = i;
			int dcha = (i+1) % numFilosofos;
			Filosofo01 f = new Filosofo01(i, palillos[izq], palillos[dcha]);
			f.comer();
		}
	}
}
