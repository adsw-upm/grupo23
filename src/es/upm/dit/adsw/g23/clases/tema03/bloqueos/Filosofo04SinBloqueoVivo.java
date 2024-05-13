package es.upm.dit.adsw.g23.clases.tema03.bloqueos;
import java.util.concurrent.ThreadLocalRandom;

public class Filosofo04SinBloqueoVivo extends Filosofo03SinInterbloqueo {

	public Filosofo04SinBloqueoVivo(int numero, PalilloSinBloqueo izq, PalilloSinBloqueo dcha) {
		super(numero, izq, dcha);
	}
	
	public Filosofo04SinBloqueoVivo(int numero, PalilloSinBloqueo izq, PalilloSinBloqueo dcha, int espera) {
		super(numero, izq, dcha, espera);
	}
	
	public void comer() {
		try {
			System.out.println("Filósofo " + numero + " empezando a comer por vez " + this.contador);
			izq.tomar();
			Thread.sleep(espera);
			if(!dcha.tomarSinBloqueo()) {
				System.out.println("Filósofo " + numero + ", palillo derecho bloqueado. Liberando el izquierdo");
				izq.liberar();
				int randomNum = ThreadLocalRandom.current().nextInt(0, espera * 5);
				System.out.println("Filósofo " + numero + ", reintentando en " + randomNum);	
				Thread.sleep(randomNum);
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

}
