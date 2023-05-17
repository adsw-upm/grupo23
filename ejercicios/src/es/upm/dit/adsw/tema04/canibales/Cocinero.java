package es.upm.dit.adsw.tema04.canibales;

import java.util.Random;

/**
 * Cocinero
 * 
 * @author aalonso
 * @author jpuente
 * @version 2014.03.21
 */
public class Cocinero extends Thread {

	private MarmitaInterface marmita;

	private Random random = new Random();

	public Cocinero(MarmitaInterface marmita) {
		this.marmita = marmita;
	}

	public void run() {
		try {
			while (true) {
					marmita.rellenar();
					Thread.sleep(random.nextInt(1000));
			}
		} catch (InterruptedException ie) {
			return;
		}

	}
	
}
