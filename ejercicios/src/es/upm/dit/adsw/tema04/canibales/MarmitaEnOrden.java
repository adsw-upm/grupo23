package es.upm.dit.adsw.tema04.canibales;

import java.util.ArrayList;
import java.util.List;

/**
 * Marmita - Los caníbales consumen de la marmita en orden de llegada.
 * 
 * Se cumple que no se despierta al cocinero innecesariamente.
 * 
 * @author aalonso
 * @author jpuente
 * @author jfs
 * @version 2023.05.14
 */
public class MarmitaEnOrden implements MarmitaInterface {
	private final int max;
	private int n = 0; // Inicialmente la marmita está vacía
	private int wakes = 0;
	private boolean avisadoCocinero;
	private boolean haComidoElPrimero;
	private List<Integer> cola;

	public MarmitaEnOrden(int capacidad) {
		this.max = capacidad;
		this.cola = new ArrayList<Integer>();
	}

	public synchronized void comer(int id) {
		
		this.cola.add(id);

		if (n == 0) {
			System.out.println("El canibal " + id
					+ " se para. La marmita está vacía");
		}

		while(this.cola.get(0) != id) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			if(n==0) {
				System.out.println("El canibal " + id + " avisa al cocinero");
				// Aquí no podría ser Notify, porque puede haber más caníbales esperando.
				notifyAll();
			}
			while (n == 0) {
				wait();
			}
		} catch (Exception e) {
			System.out.println(e.toString());
			return;
		}
	
		this.cola.remove(0);
		// Tenemos que avisar al resto de caníbales que pueden ser los siguientes en la cola
		this.notifyAll();
		n--;
		System.out.println("Come canibal " + id + "; quedan " + n + " raciones");
	}

	public synchronized void rellenar() {
		try {
			while (n > 0)
				wait();
		} catch (InterruptedException ie) {
			return;
		}

		System.out.println("Rellena el cocinero ");
		n = max;
		notifyAll();
	}
	
	public static void main(String[] args) {

		final int nRacionesMax = 4;
		final int tamanoTribu  = 5;
		
		MarmitaEnOrden marmita = new MarmitaEnOrden(nRacionesMax);
		
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
