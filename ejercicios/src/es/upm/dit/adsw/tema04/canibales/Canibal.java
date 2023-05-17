package es.upm.dit.adsw.tema04.canibales;

import java.util.Random;

/**
 * Caníbal
 * 
 * @author aalonso
 * @author jpuente
 * @version 2014.03.21
 */
public class Canibal extends Thread {

	private MarmitaInterface marmita;
	private int id;

	private Random random = new Random();

	public Canibal(MarmitaInterface marmita, int id) {
		this.marmita = marmita;
		this.id = id;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(random.nextInt(3000));
				marmita.comer(id);
			} catch (InterruptedException ie) {
				return;
			}
		}
	}

}
