package es.upm.dit.adsw.g23.clases.tema02.grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PruebaGrafos<Nodo>  {

	public static <Nodo> boolean conectadosDFS(DiGrafo<Nodo> grafo, Nodo primero, Nodo segundo) {
		return conectadosDFSrecursivo(grafo, primero, segundo, new HashSet<Nodo>());
	}
	
	public static <Nodo> boolean conectadosDFSrecursivo(DiGrafo<Nodo> grafo, Nodo primero, Nodo segundo, HashSet<Nodo> visitados) {
		if(primero == segundo) {
			return true;
		}
		if(visitados.contains(primero)) {
			return false;
		}
		addAndPrint(visitados, primero);
		for(DiArco<Nodo> arco: grafo.adj(primero)) {
			if(conectadosDFSrecursivo(grafo, arco.hacia, segundo, visitados)) {
				return true;
			}
		}
		return false;

	}
	public static <Nodo> void addAndPrint(HashSet<Nodo> visitados, Nodo nodo) {
		System.out.print("Visitados: ");
		for(Nodo n: visitados) {
			System.out.print(n + ", ");
		}
		visitados.add(nodo);
		System.out.println(nodo);

	}
	public static <Nodo> boolean conectadosDFSiterativo(DiGrafo<Nodo> grafo, Nodo primero, Nodo segundo) {
		HashSet<Nodo> visitados = new HashSet<>();
		List<Nodo> siguientes = new ArrayList<>();
		
		siguientes.add(primero);
		while(!siguientes.isEmpty()) {
			Nodo siguiente = siguientes.remove(siguientes.size()-1);
			if(segundo == siguiente) {
				return true;
			}
			if(visitados.contains(siguiente)) {
				continue;
			}
			addAndPrint(visitados, siguiente);
			for(DiArco<Nodo> conectado: grafo.adj(siguiente)) {
				siguientes.add(conectado.hacia);
			}
		}
		return false;
	}
	
	public static <Nodo> boolean conectadosBFSiterativo(DiGrafo<Nodo> grafo, Nodo primero, Nodo segundo) {
		HashSet<Nodo> visitados = new HashSet<>();
		List<Nodo> siguientes = new ArrayList<>();
		
		siguientes.add(primero);
		while(!siguientes.isEmpty()) {
			Nodo siguiente = siguientes.remove(0);
			if(segundo == siguiente) {
				return true;
			}
			if(visitados.contains(siguiente)) {
				continue;
			}
			addAndPrint(visitados, siguiente);
			for(DiArco<Nodo> conectado: grafo.adj(siguiente)) {
				siguientes.add(conectado.hacia);
			}
		}
		return false;
	}

	
	public static void main(String[] args) {
		DiGrafo<Integer> grafo = new DiGrafoLista();
		grafo.addEdge(0,  1);
		grafo.addEdge(1, 0);
		grafo.addEdge(1, 2);
		grafo.addEdge(2, 1);
		grafo.addEdge(0, 3);
		grafo.addEdge(3, 0);
		grafo.addEdge(3, 4);
		grafo.addEdge(4, 3);
		grafo.addEdge(0, 5);
		grafo.addEdge(5, 0);
		
		
		grafo.addEdge(6, 7);
		grafo.addEdge(7, 6);
		System.out.println(grafo);
		
		System.out.println("DFS");
		System.out.println("# Recursivo");
		System.out.println(conectadosDFS(grafo, 0, 4));
		System.out.println(conectadosDFS(grafo, 0, 6));
		System.out.println("# Iterativo:");
		System.out.println(conectadosDFSiterativo(grafo, 0, 4));
		System.out.println(conectadosDFSiterativo(grafo, 0, 6));
		System.out.println("# BFS:");
		System.out.println(conectadosBFSiterativo(grafo, 0, 4));
		System.out.println(conectadosBFSiterativo(grafo, 0, 6));

	}

}
