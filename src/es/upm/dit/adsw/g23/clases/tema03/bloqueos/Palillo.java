package es.upm.dit.adsw.g23.clases.tema03.bloqueos;

public class Palillo {
	protected boolean ocupado = false;

	public synchronized void tomar() {
		while(this.ocupado) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		ocupado = true;
	}

	public synchronized void liberar() {
		assert !this.ocupado;
		ocupado = false;
		this.notify();
	}
}
