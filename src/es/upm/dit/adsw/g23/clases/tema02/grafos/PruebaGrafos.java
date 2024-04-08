package es.upm.dit.adsw.g23.clases.tema02.grafos;

import java.util.HashSet;

public class PruebaGrafos<Nodo>  {

	public static <Nodo> boolean conectadosDFS(DiGrafo<Nodo> grafo, Nodo primero, Nodo segundo) {
		return conectadosDFS(grafo, primero, segundo, new HashSet<Nodo>());
	}
	
	public static <Nodo> boolean conectadosDFS(DiGrafo<Nodo> grafo, Nodo primero, Nodo segundo, HashSet<Nodo> visitados) {
		if(primero == segundo) {
			return true;
		}
		if(visitados.contains(primero)) {
			return false;
		}
		visitados.add(primero);
		for(DiArco<Nodo> arco: grafo.adj(primero)) {
			if(conectadosDFS(grafo, arco.hacia, segundo, visitados)) {
				return true;
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
		grafo.addEdge(2, 3);
		grafo.addEdge(3, 2);
		
		
		grafo.addEdge(4, 5);
		System.out.println(grafo);
		
		System.out.println(conectadosDFS(grafo, 0, 3));
		System.out.println(conectadosDFS(grafo, 0, 4));
	}

}
