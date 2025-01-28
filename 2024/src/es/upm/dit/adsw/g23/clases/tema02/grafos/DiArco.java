package es.upm.dit.adsw.g23.clases.tema02.grafos;

public class DiArco<T> {
	T desde;
	T hacia;
	double peso;
	
	public DiArco(T desde, T hacia) {
		this(desde, hacia, 1.0);
	}
	
	public DiArco(T desde, T hacia, double peso) {
		this.desde = desde;
		this.hacia = hacia;
		this.peso = peso;
	}
}
