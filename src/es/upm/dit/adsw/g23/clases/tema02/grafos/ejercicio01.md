### Enunciado:

Dado un grafo representado por una interfaz `Grafo`, que contiene nodos conectados con aristas, escribe una función que determine si hay un camino entre dos nodos del grafo.


### Requisitos:

- Se debe utilizar la interfaz `Grafo` como base, para asegurar que la solución sea independiente de la implementación concreta del grafo.
- Se debe crear una función que reciba los nodos de inicio y destino, y determine si existe un camino entre ellos.


### Solución

#### Paso 1: Definir la interfaz `Grafo`

La interfaz `Grafo` puede ser.

```java
import java.util.List;

public interface Grafo {

    // Método para obtener los nodos adyacentes a nodo
    List<String> adj(String nodo);
    
    // Método para agregar un arco (de un nodo a otro).
    // Este método sólo nos hace falta para crear grafos de prueba
    void agregarArco(String origen, String destino);
}
```


#### Paso 2: Definir la función que necesitamos

Implementando una función (`static`) dentro de una clase adicional:

```java
public class CaminoEntreNodos {
    public static boolean hayCamino(Grafo grafo, String origen, String destino) {
        return false;
    }
```

Si `Grafo` fuera una clase en lugar de una interfaz, podríamos implementar esta funcionalidad como un método de la clase:

```java
public class Grafo {
    public boolean hayCamino(String origen, String destino) {
        return false;
    }
```


#### Paso 3: Implementar la función

Usaremos un enfoque de búsqueda recursiva para verificar si hay un camino entre dos nodos del grafo.

```java
import java.util.*;

public class CaminoEntreNodos {

    // Función que verifica si hay un camino entre los nodos `origen` y `destino`
    public static boolean hayCamino(Grafo grafo, String origen, String destino) {
        // Necesitamos recordar qué nodos hemos visitado para evitar ciclos.
        Set<String> visitados = new HashSet<>();
        return buscar(grafo, origen, destino, visitados);
    }

    private static boolean buscar(Grafo grafo, String nodoActual, String destino, Set<String> visitados) {
        // Si ya se alcanzó el destino, retornamos true
        if (nodoActual.equals(destino)) {
            return true;
        }

        // Marcar el nodo actual como visitado
        visitados.add(nodoActual);

        // Recorrer los arcos del nodo actual
        for (String siguiente : grafo.adj(nodoActual)) {
            // Si el destino del arco no ha sido visitado, explorar recursivamente
            if (!visitados.contains(siguiente) && buscar(grafo, siguiente, destino, visitados)) {
                return true;
            }
        }

        // Si no se encuentra el destino en los arcos, retornar false
        return false;
    }

}
```

#### Paso 4 (opcional): Implementar la interfaz `Grafo` usando `HashMap`

Para poder lanzar nuestro código y poder 
Ahora, implementamos la interfaz `Grafo` en una clase concreta llamada `GrafoHashMap`.

```java
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
```

### Explicación:

1. **Interfaz `Grafo`**: La interfaz tiene los métodos `agregarArco` (para agregar arcos entre nodos) y `obtenerArcos` (para obtener los arcos salientes de un nodo). El grafo es dirigido.

2. **Implementación de `Grafo` (`GrafoHashMap`)**: Usa un `HashMap` para almacenar los nodos y sus arcos. En este caso, solo se almacenan los destinos de los arcos, sin importar los pesos.

3. **Clase `Edge`**: Representa un arco entre dos nodos, donde solo se almacena el nodo destino.

4. **Función `hayCamino`**: Esta función toma el grafo, el nodo de origen y el nodo de destino, y determina si existe un camino entre ellos usando búsqueda recursiva. Para evitar ciclos, se usa un conjunto `visitados`.

5. **Método `buscar`**: Es una función recursiva que explora el grafo desde el nodo actual, marcando los nodos visitados, y buscando el destino en los arcos salientes del nodo actual.

### Ejemplo de ejecución:

Con el grafo definido en el método `main`:

```
A -> B, C
B -> C, D
C -> D
E -> F
```

Las salidas de las comprobaciones serán:

```
¿Existe un camino entre A y D? true
¿Existe un camino entre A y E? false
```

### Ventajas de este enfoque:
- **Independencia de la implementación**: La interfaz `Grafo` permite que la solución funcione con cualquier implementación concreta de grafo.
- **Flexibilidad**: Se puede adaptar el algoritmo para usar BFS en lugar de DFS, o implementar otro tipo de búsqueda según se desee.