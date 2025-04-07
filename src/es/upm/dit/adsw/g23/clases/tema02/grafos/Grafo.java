package es.upm.dit.adsw.g23.clases.tema02.grafos;

import java.util.List;

public interface Grafo {

    // Método para obtener los nodos adyacentes a nodo
    List<String> adj(String nodo);
    
    // Método para agregar un arco (de un nodo a otro).
    // Este método sólo nos hace falta para crear grafos de prueba
    void agregarArco(String origen, String destino);
}