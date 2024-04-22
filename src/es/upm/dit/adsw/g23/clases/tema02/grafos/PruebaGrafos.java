package es.upm.dit.adsw.g23.clases.tema02.grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PruebaGrafos  {

	public static <Nodo> boolean conectadosDFS(DiGrafo<Nodo> grafo,
												Nodo primero,
												Nodo segundo) {
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

	public static Grafo<Integer> prim(Grafo<Integer> grafo) {
		Set<Integer> visitados = new HashSet<Integer>();
		List<Arco<Integer>> pendientes = new ArrayList<Arco<Integer>>();
		Grafo<Integer> mst = new GrafoLista<Integer>();
		
		List<Integer> nodos = grafo.V();
		Integer primero = nodos.get(0);
		for(Arco<Integer> arco: grafo.adj(primero)) {
			pendientes.add(arco);
		}
		while((!pendientes.isEmpty()) && visitados.size() < nodos.size()) {
			int pos = 0;
			double minimo = pendientes.get(0).peso;
			for(int i=1; i < pendientes.size(); i++) {
				if(pendientes.get(i).peso < minimo) {
					minimo = pendientes.get(i).peso;
					pos = i;
				}
			}
			Arco<Integer> siguiente = pendientes.remove(pos);
			Integer nuevo = siguiente.uno();
			if(visitados.contains(nuevo)) {
				nuevo = siguiente.otro(nuevo);
				if(visitados.contains(nuevo)) {
					continue;
				}
			}
			visitados.add(nuevo);
			mst.addEdge(siguiente.otro(nuevo), nuevo, siguiente.peso);
			for(Arco<Integer> arco: grafo.adj(nuevo)) {
				System.out.println(arco);
				pendientes.add(arco);
			}
		}
//		System.out.println("Pendientes:" + pendientes.size() + " visitados: " + visitados.size());
		return mst;
	}
	
	public static void pruebaBFSyDFS() {
		DiGrafo<Integer> grafo = new DiGrafoLista<Integer>();
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
		grafo.addEdge(3, 9);
		grafo.addEdge(9, 3);
		System.out.println(grafo);
		
		System.out.println("DFS");
		System.out.println("# Recursivo");
		System.out.println(conectadosDFS(grafo, 0, 2));
		System.out.println(conectadosDFS(grafo, 0, 6));
		System.out.println("# Iterativo:");
		System.out.println(conectadosDFSiterativo(grafo, 0, 4));
		System.out.println("# BFS:");
		System.out.println(conectadosBFSiterativo(grafo, 0, 4));
		System.out.println(conectadosBFSiterativo(grafo, 0, 6));

	}
	
	public static void pruebaPrim() {
		Grafo<Integer> grafo = new GrafoLista<Integer>();
		grafo.addEdge(0, 1, 5);
		grafo.addEdge(0, 3, 8);
		grafo.addEdge(0, 4, 9);
		grafo.addEdge(1, 3, 15);
		grafo.addEdge(1, 2, 12);
		grafo.addEdge(2, 5, 1);
		grafo.addEdge(2, 3, 7);
		grafo.addEdge(3, 4, 5);
		grafo.addEdge(3, 5, 9);
		grafo.addEdge(4, 5, 20);
		System.out.println("Grafo original:");
		System.out.println(grafo);
		System.out.println("Prim:");
		System.out.println(prim(grafo));
	}
	
	public static void main(String[] args) {
		pruebaPrim();
	}

}
