package es.upm.dit.adsw.g23.clases.tema03.bloqueos;

public class PalilloSinBloqueo extends Palillo {
	public synchronized boolean tomarSinBloqueo() {
		if(this.ocupado) {
			return false;
		}
		ocupado = true;
		return true;
	}
}
