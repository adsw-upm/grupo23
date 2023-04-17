package es.upm.dit.adsw.tema03.grafov2;

import java.util.HashMap;

import es.upm.dit.adsw.tema03.grafov1.Arista;
import es.upm.dit.adsw.tema03.grafov1.Nodo;

public class Grafo {
	protected HashMap<Integer, Nodo> nodos;
	
	public Grafo() {
		this.nodos = new HashMap<>();
	}
	
	public Nodo getNodo(int id) {
		return this.nodos.get(id);
	}
	
	public Nodo crearNodo(int id) {
		if(nodos.containsKey(id)) {
			return nodos.get(id);
		}
		Nodo nuevo = new Nodo(id);
		nodos.put(id, nuevo);
		return nuevo;
	}
	
	public void conectar(int id1, int id2, int peso) {
		// TODO: incluir lógica para comprobar que no existiera ya una arista entre los nodos
		Nodo n1 = this.getNodo(id1);
		Nodo n2 = this.getNodo(id2);
		Arista a = new Arista(n1, n2, peso);
		n1.getAristas().add(a);
		n2.getAristas().add(a);
	}
	
	public void print() {
		for(Nodo nodo: nodos.values()) {
			System.out.println("Nodo(" + nodo.getId() + "): " + nodo.toString());
			for(Arista a: nodo.getAristas()) {
				System.out.println("\t" + a.toString());
			}
		}
	}
	
	public static void main(String[] args) {
		Grafo g = new Grafo();
		for(int i=0; i<6; i++) {
			g.crearNodo(i);
		}
		g.conectar(0, 1, 5);
		g.conectar(0, 3, 8);
		g.conectar(0, 4, 9);
		
		g.conectar(1, 3, 15);
		g.conectar(1, 2, 12);
		
		g.conectar(2, 3, 7);
		g.conectar(2, 5, 1);
		
		g.conectar(3, 4, 5);
		g.conectar(3, 5, 9);
		
		g.conectar(4, 5, 20);
		
		g.print();
	}
	

}
