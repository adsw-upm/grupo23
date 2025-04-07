package es.upm.dit.adsw.g23.clases.tema02.grafos.dirigidos;

import java.util.*;

public class GrafoDirigidoHashMap implements GrafoDirigido {
    private Map<String, List<ArcoDirigido>> grafo;

    public GrafoDirigidoHashMap() {
        grafo = new HashMap<>();
    }

    @Override
    public void agregarArco(String origen, String destino, float peso) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.get(origen).add(new ArcoDirigido(origen, destino, peso));
    }

    @Override
    public List<ArcoDirigido> adj(String nodo) {
        return grafo.getOrDefault(nodo, new ArrayList<>());
    }
    
    public static void main(String[] args) {
        // Crear un grafo utilizando la implementación concreta
        GrafoDirigido grafo = new GrafoDirigidoHashMap();

        // Añadir arcos al grafo
        grafo.agregarArco("A", "B", 1);
        grafo.agregarArco("A", "C", 2);
        grafo.agregarArco("B", "C", 3);
        grafo.agregarArco("B", "D", 4);
        grafo.agregarArco("C", "D", 5);
        
        grafo.agregarArco("E", "F", 6);

        // Verificar si existe un camino entre los nodos "A" y "D"
        boolean resultado = CaminoEntreNodos.hayCamino(grafo, "A", "D");
        System.out.println("¿Existe un camino entre A y D? " + resultado);  // Debería ser true

        // Verificar si existe un camino entre los nodos "A" y "E"
        resultado = CaminoEntreNodos.hayCamino(grafo, "A", "E");
        System.out.println("¿Existe un camino entre A y E? " + resultado);  // Debería ser false
    }

}
