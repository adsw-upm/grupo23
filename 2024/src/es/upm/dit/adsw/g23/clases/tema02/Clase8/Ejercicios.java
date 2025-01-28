package es.upm.dit.adsw.g23.clases.tema02.Clase8;


public class Ejercicios {    
	public static void main(String[] args) {		
		long n_muestras = 10_000;
		long start = System.currentTimeMillis();
		for(int i=0; i< n_muestras; i++) {
			ejemplo00();
		}
		
		long finish = System.currentTimeMillis();
		float timeElapsed = ((float) (finish - start) )/ n_muestras;
		System.out.printf("Tiempo: %10f\n", timeElapsed );
	}
	
    public static void ejemplo00(){
    	System.out.println("Buenos días");
    }
}