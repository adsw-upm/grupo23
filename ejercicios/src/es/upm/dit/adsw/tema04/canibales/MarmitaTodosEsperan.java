package es.upm.dit.adsw.tema04.canibales;

/**
 * Marmita - Versión en la que todos los caníbales esperan. El primero en avisar no tiene preferencia.
 * 
 * Se cumple que no se despierta al cocinero innecesariamente.
 * 
 * @author aalonso
 * @author jpuente
 * @author jfs
 * @version 2023.05.14
 */
public class MarmitaTodosEsperan implements MarmitaInterface {
	private final int max;
	private int n = 0;

	public MarmitaTodosEsperan(int capacidad) {
		this.max = capacidad;
	}

	public synchronized void comer(int id) throws InterruptedException {

		if (n == 0) {
			System.out.println("El canibal " + id
					+ " se para. La marmita está vacía");
			while (n == 0) {
				// Se despierta al cocinero (y al resto, que pueden estar esperando)
				//Esto crea un bucle infinito en que los caníbales se despiertan entre ellos todo el rato
				notifyAll();
				System.out.println("El canibal " + id + " avisa al cocinero (y al resto)");
				wait();
			}
		}

		n--;
		System.out.println("Come canibal " + id + "; quedan " + n + " raciones");
	}

	public synchronized void rellenar() throws InterruptedException {
		while (n > 0) {
			wait();
		}

		System.out.println("Rellena el cocinero ");
		n = max;
		notifyAll();
	}
	
	public static void main(String[] args) {

		final int nRacionesMax = 4;
		final int tamanoTribu  = 5;
		
		MarmitaTodosEsperan marmita = new MarmitaTodosEsperan(nRacionesMax);
		
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
