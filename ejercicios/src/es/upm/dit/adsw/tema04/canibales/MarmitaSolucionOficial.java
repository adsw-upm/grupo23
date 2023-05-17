package es.upm.dit.adsw.tema04.canibales;

/**
 * Marmita - monitor para gestionar el uso de la marmita por parte del coniero y
 * los caníbales
 * 
 * @author aalonso
 * @author jpuente
 * @author jfs
 * @version 2023.05.14
 */
public class MarmitaSolucionOficial implements MarmitaInterface {
	private final int max;
	private int n = 0; // Inicialmente la marmita está vacía
	private boolean primero = false;

	public MarmitaSolucionOficial(int capacidad) {
		this.max = capacidad;
	}

	public synchronized void comer(int id) throws InterruptedException  {

		if (n == 0) {
			System.out.println("El canibal " + id
					+ " se para. La marmita está vacía");
		}

		if (primero && n == 0) {
			notifyAll();
			primero = false;
			System.out.println("El canibal " + id + " avisa al cocinero");
		}

		while (n == 0) {
			wait();
		}


		n--;
		System.out.println("Come canibal " + id + "; quedan " + n + " raciones");
		notifyAll();
	}

	public synchronized void rellenar() throws InterruptedException {
		while (n > 0 || primero)
			wait();

		System.out.println("Rellena el cocinero ");
		n = max;
		primero = true;
		notifyAll();
	}
	
	public static void main(String[] args) {

		final int nRacionesMax = 4;
		final int tamanoTribu  = 5;
		
		MarmitaSolucionOficial marmita = new MarmitaSolucionOficial(nRacionesMax);
		
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
