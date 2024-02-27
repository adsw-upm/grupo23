package es.upm.dit.adsw.g23.clases.tema02.Clase8;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Medida {
    static Logger logger = Logger.getLogger("");
	static Random generator = new Random(0);


	public static void main(String[] args) {
		logger.setLevel(Level.INFO);
		long n_muestras = 10;
		for(int i: new int[] {100, 1_000, 10_000, 100_000,
							    1_000_000, 10_000_000, 100_000_000,
							    1_000_000_000}) {
			long start = System.currentTimeMillis();
			
			for(int j=0; j<n_muestras; j++) {
				EjerciciosComplejidad.ejemplo06(i);
			}
			
			long finish = System.currentTimeMillis();
			float timeElapsed = (float) (finish - start);
			System.out.printf("Tiempo medio para n=%,15d -> %10fµs\n", i, timeElapsed / (n_muestras / 1000f));
		}
	}	
	
	public static int[] aleatorio(int tamano) {
		int []arr = new int[tamano];
		for(int j=0; j<tamano; j++) {
			arr[j] = generator.nextInt(1000);
		}
		return arr;
	}
}