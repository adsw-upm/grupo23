package es.upm.dit.adsw.tema03.grafov1;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
	int id;
	private List<Arista> aristas;
	
	public Nodo(int id) {
		this.id = id;
		this.aristas = new ArrayList<>();
	}

	public List<Arista> getAristas() {
		return aristas;
	}
	
	public String toString() {
		return Integer.toString(id);
	}
	
	public int getId() {
		return this.id;
	}
	
}
