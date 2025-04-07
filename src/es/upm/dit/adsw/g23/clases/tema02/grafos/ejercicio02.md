### Enunciado

**Objetivo**: Implementa un método que encuentre todos los nodos a una distancia menor o igual a un valor \( d \) de un nodo dado \( nodo\_inicial \), donde \( d \) es un parámetro de entrada que indica la distancia máxima en términos de número de saltos (arcos) desde el nodo inicial.

Usa la siguiente definición de Grafo y de Arco:

```java
java
public interface GrafoDirigido {
    List<ArcoDirigido> adj(String nodo);
    void agregarArco(String origen, String destino, float peso);
}
public class ArcoDirigido {
    public String desde;
    public String hacia;
    public float peso;

    public ArcoDirigido(String desde, String hacia, float peso) {
        this.desde = desde;
        this.hacia = hacia;
        this.peso = peso;
    }
}
```

**Requisitos**:
1. Utiliza algún algoritmo de búsqueda para explorar el grafo y encontrar los nodos a una distancia de \( d \) o menos.
2. La distancia entre dos nodos se define como el número mínimo de arcos necesarios para llegar de un nodo a otro.
3. El parámetro \( d \) será un número entero positivo que representa la distancia máxima de saltos desde el nodo inicial.
4. Se debe devolver una lista con los nodos que están a una distancia de \( d \) o menos del nodo inicial, incluyendo al nodo inicial.

### Métodos que debes implementar:

1. **Método `nodosHastaSalto(String nodo_inicial, int d)`**:
   - Este método recibe el nodo de inicio `nodo_inicial` y un valor entero \( d \), y devuelve una lista con todos los nodos que están a una distancia menor o igual a \( d \) desde el nodo inicial.

2. **Estrategia**:
   - Implementa BFS desde el nodo inicial, manteniendo un registro de las distancias de los nodos visitados.
   - Usa una **cola** para el recorrido BFS y un **conjunto** o **mapa** para asegurarte de no visitar el mismo nodo varias veces.
   - Termina el recorrido cuando se alcance la distancia \( d \).

### Definición de la implementación en Java

```java
import java.util.*;

public class GrafoDirigidoHashMap implements GrafoDirigido {

    private Map<String, List<ArcoDirigido>> grafo;

    public GrafoDirigidoHashMap() {
        this.grafo = new HashMap<>();
    }

    // Método para obtener los nodos adyacentes a un nodo
    @Override
    public List<ArcoDirigido> adj(String nodo) {
        return grafo.getOrDefault(nodo, new ArrayList<>());
    }

    // Método para agregar un arco de un nodo a otro
    @Override
    public void agregarArco(String origen, String destino, float peso) {
        grafo.putIfAbsent(origen, new ArrayList<>());
        grafo.get(origen).add(new ArcoDirigido(origen, destino, peso));
    }
    
    public List<String> nodosHastaSalto(String nodo_inicial, int d) {
    	return new ArrayList<>();
    }
    
    // Método auxiliar para mostrar el grafo (opcional)
    public void mostrarGrafo() {
        for (String nodo : grafo.keySet()) {
            System.out.print(nodo + ": ");
            for (ArcoDirigido arco : grafo.get(nodo)) {
                System.out.print(arco.hacia + " ");
            }
            System.out.println();
        }
    }
    
}
```

### Implementación en Java

```java
    // Método para encontrar los nodos a distancia menor o igual a 'd'
    public List<String> nodosHastaSalto(String nodo_inicial, int d) {
        // Mapa para almacenar las distancias desde el nodo inicial
        Map<String, Integer> distancias = new HashMap<>();
        // Cola para BFS
        Queue<String> cola = new LinkedList<>();
        // Lista para los nodos a devolver
        List<String> nodosHastaSalto = new ArrayList<>();
        
        // Inicializamos la búsqueda
        distancias.put(nodo_inicial, 0);
        cola.offer(nodo_inicial);
        
        // Realizamos la búsqueda en anchura
        while (!cola.isEmpty()) {
            String nodo = cola.poll();
            int distanciaActual = distancias.get(nodo);
            
            // Si la distancia es mayor a 'd', no continuar
            if (distanciaActual > d) continue;

            // Agregamos el nodo a la lista de resultados
            nodosHastaSalto.add(nodo);
            
            // Recorrer los nodos adyacentes
            for (ArcoDirigido arco : adj(nodo)) {
                String vecino = arco.hacia;
                if (!distancias.containsKey(vecino)) {
                    // Si el vecino no ha sido visitado, lo agregamos
                    distancias.put(vecino, distanciaActual + 1);
                    cola.offer(vecino);
                }
            }
        }
        return nodosHastaSalto;
    }
```

### Explicación del código

1. **Clase `GrafoDirigidoHashMap`**:
   - **Método `adj(String nodo)`**: Devuelve los arcos dirigidos desde un nodo dado.
   - **Método `agregarArco(String origen, String destino, float peso)`**: Permite agregar un arco dirigido entre dos nodos con un peso específico.
   - **Método `nodosHastaSalto(String nodo_inicial, int d)`**:
     - Este método realiza un recorrido BFS desde el nodo `nodo_inicial` y encuentra todos los nodos a una distancia menor o igual a \( d \).
     - La distancia de cada nodo se mantiene en el mapa `distancias`.
     - Si la distancia de un nodo es mayor a \( d \), el recorrido se detiene para ese nodo.

2. **Clase `ArcoDirigido`**:
   - Representa un arco dirigido con atributos como el nodo de origen (`desde`), el nodo de destino (`hacia`) y el peso del arco.

### Ejemplo de uso:

```java
public class Main {
    public static void main(String[] args) {
        GrafoDirigidoHashMap grafo = new GrafoDirigidoHashMap();
        
        // Agregar arcos al grafo
        grafo.agregarArco("A", "B", 1);
        grafo.agregarArco("A", "C", 2);
        grafo.agregarArco("B", "D", 1);
        grafo.agregarArco("C", "D", 1);
        grafo.agregarArco("D", "E", 1);
        
        // Obtener nodos a distancia 3 o menos de "A"
        List<String> nodos = grafo.nodosHastaSalto("A", 3);
        
        // Mostrar los nodos encontrados
        System.out.println("Nodos a distancia 3 o menos de A: " + nodos);
    }
}
```

### Ejemplo de salida:

```
Nodos a distancia 2 o menos de A: [A, B, C, D]
```

### Modificaciones:

* Hacer una implementación recursiva y otra iterativa. Nota: La solución dada en este enunciado es iterativa.
* Implementar el método `nodosADistancia`, que en lugar de tener en cuenta el número de saltos, tenga en cuenta la distancia total del camino (e.d., la  suma de los pesos de los arcos).