package es.upm.dit.adsw.tema04;

import java.util.Calendar;
import java.util.Date;

class Noel extends Thread {
	public void run() {
		EjemploInicial_resuelto.tick();
	}
}

class Adrian extends Thread {
	public void run() {
		EjemploInicial_resuelto.sumar(100);
		System.out.println("La cuenta es: " + EjemploInicial_resuelto.CUENTA);
	}
}

public class EjemploInicial_resuelto {
	static int CUENTA = 0;
	
	public static void main(String[] args) throws InterruptedException {
		Thread noel = new Noel();
		Thread adrian = new Adrian();
		noel.start();
		adrian.start();
		noel.join();
		adrian.join();
		System.out.println("Acabó");
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
		long target = (new Date()).getTime() + millis;
		while( (new Date()).getTime() < target ) {
			continue;
		}
	}

}
