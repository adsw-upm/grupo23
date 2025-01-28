package es.upm.dit.adsw.g23.clases.tema03.bloqueos;

public class Filosofo01 {
	Palillo izq;
	Palillo dcha;
	int numero;
	int espera;
	int contador;

	public Filosofo01(int numero, Palillo izq, Palillo dcha) {
		this(numero, izq, dcha, 500);
	}
	
	public Filosofo01(int numero, Palillo izq, Palillo dcha, int espera) {
		this.numero = numero;
		this.izq = izq;
		this.dcha = dcha;
		this.espera = espera;
		this.contador = 0;
	}

	public void comer() {
		try {
			System.out.println("Filósofo " + numero + " empezando a comer por vez " + this.contador);
			izq.tomar();
			Thread.sleep(espera);
			dcha.tomar();
			Thread.sleep(espera);
			dcha.liberar();
			Thread.sleep(espera);
			izq.liberar();
			System.out.println("Filósofo " + numero + " deja de comer");
			this.contador ++;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}

	}

}
