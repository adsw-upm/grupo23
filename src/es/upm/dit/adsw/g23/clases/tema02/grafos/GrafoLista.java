package es.upm.dit.adsw.g23.clases.tema02.grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

public class GrafoLista<Nodo extends Comparable<? super Nodo>> implements Grafo<Nodo> {
	HashMap<Nodo, HashSet<Arco<Nodo>>> enlaces;
	
	public GrafoLista() {
		this.enlaces = new HashMap<>();
	}

	@Override
	public void addEdge(Nodo desde, Nodo hacia, double peso) {
		HashSet<Arco<Nodo>> nodos = enlaces.get(desde);
		if(nodos == null) {
			nodos = new HashSet<Arco<Nodo>>();
			enlaces.put(desde, nodos);
		}
		Arco<Nodo> e = new Arco<Nodo>(desde, hacia, peso);
		nodos.add(e);
		// Añadir en la otra dirección
		nodos = enlaces.get(hacia);
		if(nodos == null) {
			nodos = new HashSet<Arco<Nodo>>();
			enlaces.put(hacia, nodos);
		}
		e = new Arco<Nodo>(hacia, desde, peso);
		nodos.add(e);
	}
	@Override
	public void addEdge(Nodo desde, Nodo hacia) {
		addEdge(desde, hacia, 1.0);
	}

	@Override
	public Iterable<Arco<Nodo>> adj(Nodo v) {
		return enlaces.get(v);
	}

	@Override
	public int degree(Nodo v) {
		HashSet<Arco<Nodo>> arcos = enlaces.get(v);
		if(arcos == null) {
			return 0;
		}
		return arcos.size();
	}
	
	@Override
	public Iterable<Arco<Nodo>> edges() {
		ArrayList<Arco<Nodo>> todos = new ArrayList<>();
		for(HashSet<Arco<Nodo>> locales: this.enlaces.values()) {
			todos.addAll(locales);
		}
		return todos;
	}

	@Override
	public int E() {
		int total = 0;
		for(HashSet<Arco<Nodo>> locales: this.enlaces.values()) {
			total += locales.size();
		}
		return total / 2;
	}



	@Override
	public List<Nodo> V() {
		return new ArrayList<Nodo>(this.enlaces.keySet());
		
	}
	
	public String toString() {
		String salida = new String();
		for(Entry<Nodo, HashSet<Arco<Nodo>>> entry: this.enlaces.entrySet()) {
			Nodo uno = entry.getKey();
			salida += uno + " -> ";
			for(Arco<Nodo> arco: entry.getValue()) {
				salida += arco.otro(uno) + "[" + arco.peso + "] ";
			}
			salida += "\n";
		}
		return salida;
	}
}
