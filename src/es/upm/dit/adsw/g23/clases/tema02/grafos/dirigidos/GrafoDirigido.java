package es.upm.dit.adsw.g23.clases.tema02.grafos.dirigidos;

import java.util.List;

public interface GrafoDirigido {

    // Método para obtener los nodos adyacentes a nodo
    List<ArcoDirigido> adj(String nodo);
    
    // Método para agregar un arco de un nodo a otro.
    void agregarArco(String origen, String destino, float peso);
}
