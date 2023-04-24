package es.upm.dit.adsw.tema04;

import java.util.Calendar;

public class EjemploInicial {
	static int CUENTA = 0;
	
	public static void main(String[] args) {
		sumar(100);
	}
	
	public static void sumar(int hasta) {
		for(int i=0; i < hasta; i++) {
			int resultado = CUENTA + 1; 
			CUENTA = resultado;
		}
	}
	
	public static void tick() {
		esperar(1000);
		System.out.println("Tick!");
	}

	public static void esperar(int millis) {
		// Esto es una implementación altamente INEFICIENTE
		// Sólo la utilizamos para ilustrar el ejemplo sin
		// usar Thread.sleep.
	    Calendar calendar = Calendar.getInstance();
		long target = calendar.getTimeInMillis() + millis;
		while( calendar.getTimeInMillis() < target ) {
			continue;
		}
	}

}
