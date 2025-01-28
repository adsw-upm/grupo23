package es.upm.dit.adsw.g23.clases.tema03.bloqueos;

public class Filosofo03SinInterbloqueo extends Filosofo02Concurrente {
	PalilloSinBloqueo izq;
	PalilloSinBloqueo dcha;

	public Filosofo03SinInterbloqueo(int numero, PalilloSinBloqueo izq, PalilloSinBloqueo dcha) {
		super(numero, izq, dcha);
		this.izq = izq;
		this.dcha = dcha;
	}
	
	public Filosofo03SinInterbloqueo(int numero, PalilloSinBloqueo izq, PalilloSinBloqueo dcha, int espera) {
		super(numero, izq, dcha, espera);
		this.izq = izq;
		this.dcha = dcha;
	}

	public void comer() {
		try {
			System.out.println("Filósofo " + numero + " empezando a comer por vez " + this.contador);
			izq.tomar();
			Thread.sleep(espera);
			if(!dcha.tomarSinBloqueo()) {
				System.out.println("Filósofo " + numero + ", palillo derecho bloqueado. Liberando el izquierdo");
				izq.liberar();
				return;
			};
			Thread.sleep(espera);
			dcha.liberar();
			Thread.sleep(espera);
			izq.liberar();
			System.out.println("Filósofo " + numero + " deja de comer");
			this.contador++;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}

	}
	
	public void run() {
		while(true) {
			comer();
		}
	}

}
