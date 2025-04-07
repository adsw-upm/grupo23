package es.upm.dit.adsw.g23.clases.tema02.grafos.dirigidos;
import java.util.*;

public class CaminoEntreNodos {

    // Función que verifica si hay un camino entre los nodos `origen` y `destino`
    public static boolean hayCamino(GrafoDirigido grafo, String origen, String destino) {
        // Necesitamos recordar qué nodos hemos visitado para evitar ciclos.
        Set<String> visitados = new HashSet<>();
        return buscar(grafo, origen, destino, visitados);
    }

    private static boolean buscar(GrafoDirigido grafo, String nodoActual, String destino, Set<String> visitados) {
        // Si ya se alcanzó el destino, retornamos true
        if (nodoActual.equals(destino)) {
            return true;
        }

        // Marcar el nodo actual como visitado
        visitados.add(nodoActual);

        // Recorrer los arcos del nodo actual
        for (ArcoDirigido siguiente : grafo.adj(nodoActual)) {
            // Si el destino del arco no ha sido visitado, explorar recursivamente
            if (!visitados.contains(siguiente.hacia)) {
            	if(buscar(grafo, siguiente.hacia, destino, visitados)) {
            		return true;
            	}
            }
        }

        // Si no se encuentra el destino en los arcos, retornar false
        return false;
    }

}