package es.upm.dit.adsw.g23.clases.tema02.grafos.dirigidos;

public class ArcoDirigido {
	public String desde;
	public String hacia;
	public float peso;
	
	public ArcoDirigido(String desde, String hacia, float peso) {
		this.desde = desde;
		this.hacia = hacia;
		this.peso = peso;
	}
}
