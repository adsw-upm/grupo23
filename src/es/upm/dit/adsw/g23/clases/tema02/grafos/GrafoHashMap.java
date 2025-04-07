package es.upm.dit.adsw.g23.clases.tema02.grafos;

import java.util.*;

public class GrafoHashMap implements Grafo {
    private Map<String, List<String>> grafo;

    public GrafoHashMap() {
        grafo = new HashMap<>();
    }

    @Override
    public void agregarArco(String origen, String destino) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.get(origen).add(destino);
    }

    @Override
    public List<String> adj(String nodo) {
        return grafo.getOrDefault(nodo, new ArrayList<>());
    }
    public static void main(String[] args) {
        // Crear un grafo utilizando la implementación concreta
        Grafo grafo = new GrafoHashMap();

        // Añadir arcos al grafo
        grafo.agregarArco("A", "B");
        grafo.agregarArco("A", "C");
        grafo.agregarArco("B", "C");
        grafo.agregarArco("B", "D");
        grafo.agregarArco("C", "D");
        
        grafo.agregarArco("E", "F");

        // Verificar si existe un camino entre los nodos "A" y "D"
        boolean resultado = CaminoEntreNodos.hayCamino(grafo, "A", "D");
        System.out.println("¿Existe un camino entre A y D? " + resultado);  // Debería ser true

        // Verificar si existe un camino entre los nodos "A" y "E"
        resultado = CaminoEntreNodos.hayCamino(grafo, "A", "E");
        System.out.println("¿Existe un camino entre A y E? " + resultado);  // Debería ser false
    }

}
