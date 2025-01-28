package es.upm.dit.adsw.g23.clases.tema02.grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class DiGrafoLista<Nodo> implements DiGrafo<Nodo> {
	HashMap<Nodo, HashSet<DiArco<Nodo>>> enlaces;
	
	public DiGrafoLista() {
		this.enlaces = new HashMap<>();
	}

	@Override
	public void addEdge(Nodo desde, Nodo hacia, double peso) {
		HashSet<DiArco<Nodo>> nodos = enlaces.get(desde);
		if(nodos == null) {
			nodos = new HashSet<DiArco<Nodo>>();
			enlaces.put(desde, nodos);
		}
		DiArco<Nodo> e = new DiArco(desde, hacia, peso);
		nodos.add(e);
	}
	@Override
	public void addEdge(Nodo desde, Nodo hacia) {
		addEdge(desde, hacia, 1.0);
	}

	@Override
	public Iterable<DiArco<Nodo>> adj(Nodo v) {
		ArrayList<DiArco<Nodo>> arcos = new ArrayList<>();
		return enlaces.get(v);
	}

	@Override
	public int degree(Nodo v) {
		HashSet<DiArco<Nodo>> arcos = enlaces.get(v);
		if(arcos == null) {
			return 0;
		}
		return arcos.size();
	}
	
	@Override
	public Iterable<DiArco<Nodo>> edges() {
		ArrayList<DiArco<Nodo>> todos = new ArrayList<>();
		for(HashSet<DiArco<Nodo>> locales: this.enlaces.values()) {
			todos.addAll(locales);
		}
		return todos;
	}

	@Override
	public int E() {
		int total = 0;
		for(HashSet<DiArco<Nodo>> locales: this.enlaces.values()) {
			total += locales.size();
		}
		return total;
	}



	@SuppressWarnings("unchecked")
	@Override
	public Nodo[] V() {
		Nodo[] array = (Nodo[]) this.enlaces.values().toArray();
		return array;
	}
	public String toString() {
		String salida = new String();
		for(Entry<Nodo, HashSet<DiArco<Nodo>>> entry: this.enlaces.entrySet()) {
			salida += entry.getKey() + " -> ";
			for(DiArco arco: entry.getValue()) {
				salida += arco.hacia + "[" + arco.peso + "] ";
			}
			salida += "\n";
		}
		return salida;
	}
}
