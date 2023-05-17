package es.upm.dit.adsw.tema04.canibales;

/**
 * Marmita - Versión en la que todos los caníbales esperan. El primero en avisar no tiene preferencia.
 * 
 * En esta versión, sólo un caníbal avisa al cocinero. Se evita despertar al resto demasiadas veces.
 * 
 * 
 * @author aalonso
 * @author jpuente
 * @author jfs
 * @version 2023.05.14
 */
public class MarmitaTodosEsperan2 implements MarmitaInterface {
	private final int max;
	private int n = 0;
	private boolean avisado = false;
	
	public MarmitaTodosEsperan2(int capacidad) {
		this.max = capacidad;
	}

	public synchronized void comer(int id) throws InterruptedException {

		if (n == 0) {
			System.out.println("El canibal " + id
					+ " se para. La marmita está vacía");

			while(n==0) {
			// Se despierta al cocinero (y al resto, que pueden estar esperando)
				if(!avisado) {
					avisado = true;
					notifyAll();
					System.out.println("El canibal " + id + " avisa al cocinero");
				}
				wait();
			}
		}

		n--;
		System.out.println("Come canibal " + id + "; quedan " + n + " raciones");
	}

	public synchronized void rellenar() throws InterruptedException {
		while (n > 0)
			wait();

		System.out.println("Rellena el cocinero ");
		n = max;
		avisado = false;
		notifyAll();
	}
	
	public static void main(String[] args) {

		final int nRacionesMax = 4;
		final int tamanoTribu  = 5;
		
		MarmitaTodosEsperan2 marmita = new MarmitaTodosEsperan2(nRacionesMax);
		
		Cocinero cocinero = new Cocinero (marmita);
		cocinero.start();
		
		Canibal[] canibales  = new Canibal[tamanoTribu];		
		for (int i = 0; i < tamanoTribu; i++){
			try{
				Thread.sleep(1000);
				canibales[i] = new Canibal(marmita, i);
				canibales[i].start();
			}catch(InterruptedException ie){}
		}
	}

}
