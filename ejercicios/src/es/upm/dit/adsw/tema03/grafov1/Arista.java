package es.upm.dit.adsw.tema03.grafov1;

public class Arista {
	Nodo n1;
	Nodo n2;
	int peso;
	
	public Arista(Nodo n1, Nodo n2, int peso) {
		this.n1 = n1;
		this.n2 = n2;
		this.peso = peso;
	}
	
	public String toString() {
		return n1 + " <-[" + peso + "]-> " + n2;
	}
	
	public int getPeso() {
		return this.peso;
	}
	
	public Nodo getN1() {
		return n1;
	}
	
	public Nodo getN2() {
		return n2;
	}
}
