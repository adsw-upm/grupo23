### Enunciado:

Dado un grafo representado por una interfaz `GrafoDirigido`, que contiene nodos conectados con arcos dirigidos con peso, escribe una función que devuelva una lista de todos los nodos accesibles desde un nodo inicial, en orden de distancia.
La firma de la función es: `List<String> listarAccesibles(String inicial)`.

La interfaz grafo es:

```java
import java.util.List;

public interface GrafoDirigido {

    List<ArcoDirigido> adj(String nodo);
    List<String> vertices();
    void agregarArco(String origen, String destino, float peso);
}
```

Opcional: crear una función nueva que además de devolver los nodos, devuelva la distancia a cada uno de ellos.

### Requisitos:

- Se debe utilizar la interfaz `GrafoDirigido` como base, para asegurar que la solución sea independiente de la implementación concreta del grafo.
- Se debe crear una función que reciba el grafo y el nodo de inicio. Esta función determina si existe un camino entre ellos.
