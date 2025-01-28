package es.upm.dit.adsw.g23.clases.tema03.bloqueos;

public class Filosofos03SinInterbloqueo {

	public static void main(String[] args) throws InterruptedException {
		int numFilosofos = 2;
		PalilloSinBloqueo[] palillos = new PalilloSinBloqueo[numFilosofos];
		for(int i=0; i<numFilosofos; i++) {
			palillos[i] = new PalilloSinBloqueo();
		}
		Thread[] hebras = new Thread[numFilosofos];
		for(int i=0; i<numFilosofos; i++) {
			int izq = i;
			int dcha = (i+1) % numFilosofos;
			Thread f = new Thread(new Filosofo03SinInterbloqueo(i, palillos[izq], palillos[dcha]));
			hebras[i] = f;
			f.start();
		}
		for(int i=0; i<numFilosofos; i++) {
			hebras[i].join();
		}
	}
}
