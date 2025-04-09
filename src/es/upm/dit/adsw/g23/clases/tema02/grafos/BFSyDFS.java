package es.upm.dit.adsw.g23.clases.tema02.grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BFSyDFS {
	
	public static void dfs(Grafo grafo, String nodo) {
		System.out.print("DFS: ");
		dfs(grafo, nodo, new HashSet<>());
		System.out.println();
	}

	
	private static void dfs(Grafo grafo,
			String nodo,
			Set<String> visitados) {
		if(visitados.contains(nodo)) {
			return;
		}
		System.out.print(nodo + " ");
		visitados.add(nodo);
		for(String siguiente: grafo.adj(nodo)) {
			dfs(grafo, siguiente, visitados);
		}
	}
	public static void dfsTambien(Grafo grafo, String nodo) {
		System.out.print("DFS también: ");

		List<String> pendientes = new ArrayList<>();
		Set<String> visitados = new HashSet<>();
		pendientes.add(nodo);
		while(!pendientes.isEmpty()) {
			String siguiente = pendientes.remove(pendientes.size()-1);
			if(visitados.contains(siguiente)) {
				continue;
			}
			visitados.add(siguiente);
			System.out.print(siguiente + " ");
			for(String vecino: grafo.adj(siguiente)) {
				pendientes.add(vecino);
			}
		}
		System.out.println();
	}
	public static void bfs(Grafo grafo, String nodo) {
		System.out.print("BFS: ");

		List<String> pendientes = new ArrayList<>();
		Set<String> visitados = new HashSet<>();
		pendientes.add(nodo);
		while(!pendientes.isEmpty()) {
			String siguiente = pendientes.remove(0);
			if(visitados.contains(siguiente)) {
				continue;
			}
			System.out.print(siguiente + " ");
			visitados.add(siguiente);
			for(String vecino: grafo.adj(siguiente)) {
				pendientes.add(vecino);
			}
		}
		System.out.println("");
	}

	
    public static void main(String[] args) {
        // Crear un grafo utilizando la implementación concreta
        Grafo grafo = new GrafoHashMap();

        // Para probar, creamos un grafo que empieza en A, se bifurca en dos 
        // ramas ( B -> D y C ->E), y luego se vuelve a juntar en F
        grafo.agregarArco("A", "B");
        grafo.agregarArco("A", "C");
        grafo.agregarArco("B", "D");
        grafo.agregarArco("C", "E");
        grafo.agregarArco("D", "F");
        grafo.agregarArco("E", "F");
        
        
        
        dfs(grafo, "A");
        bfs(grafo, "A");
        // Pregunta: ¿es DFS de verdad?, ¿por qué es diferente la salida?
        dfsTambien(grafo, "A");

    }

}
