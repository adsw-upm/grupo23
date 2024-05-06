# Temario y ejercicios G23 ADSW 2024

Tabla de contenido visto en clase y problemas propuestos para ADSW.

El código del repositorio se divide en dos paquetes principales:
- `es.upm.dit.adsw.g23.clases`, que incluye el código utilizado durante las clases. Posiblemente haya partes incompletas o que no funcionen completamente.
- `es.upm.dit.adsw.g23.ejercicios`, donde se incluye código incompleto. 

## Clases

Descripción general del contenido de cada clase como referencia para el estudio.
Cada día incluye los conceptos vistos y los ejercicios prácticos realizados, así como ejercicios y punteros a material para el estudio.

**Nota**: Puede tomarse como referencia, pero puede haber algún error u omisiones.

### Día 0 (29 enero)

* Clase:
  * Temario 
  * Calendario de la asignatura
  * Evaluación (prácticas, laboratorios)

### Día 1 (31 enero)

* Clase: Repaso de conceptos básicos de programación.
  * Contexto de ADSW: ADSW vs PROG vs ingeniería de software
  * Práctico: desarrollo de Calculadora a diferentes niveles:
    * Sin métodos
    * Sin clases
    * Con métodos
    * Con excepciones
    * Con herencia
  * Conceptos:
    * Orientación a objetos (métodos, clases, objetos)
    * Herencia básica
    * Excepciones (motivación, creación y declaración en la firma)
    * Depuración (lo dejamos para la siguiente clase)
    * Sintáxis Java
      * Control
      * Tipos básicos de datos (int, float, boolean, String)
      * Estructuras de datos (arrays, listas, maps...)
  * Orientación a objetos
    * Clases (herencia)
    * Interfaces
    * Más general: encapsulamiento (datos + comportamiento)
  * Intro a uso de eclipse
* Ejercicios:
  * Ampliar calculadora
    * Ejecutar línea a línea
  * HackerRank:
    * E1 Recorrido de Arrays
    * E1 Listas
* Lecturas recomendadsa:
  * Transparencias en moodle:
    * Modelado orientado a objetos
    * Estructuras de datos en Java

### Día 2 (5 Febrero)

* Clase: Continuación de la clase anterior
* Ejercicios:
  * Desarrollar la calculadora desde un proyecto vacío
  * Hackerrank:
    * E4 Listas


### Día 3 (7 Febrero)

* Clase: Problemas de introducción a ordenación
  * Práctico:
    * Descarga de este repositorio en eclipse
    * Desarrollo de pruebas para la calculadora
    * Ejercicios Clase3
  * Conceptos:
    * Pruebas y depuración
    * Introducción a la intuición del orden de complejidad
    * Introducción a algoritmos básicos de ordenación
* Ejercicios:
  * Básicos
    * Descarga del repositorio 
    * Completar los ejercicios hechos en clase sin mirar la solución
  * Avanzados
    * Completar la calculadora para que permita introducir operaciones línea a línea
    * `es.upm.dit.adsw.tema01.EjeciciosAvanzadosClase3`
* Lecturas recomendadas
  * Moodle: Pruebas y depuración en Java

### Día 4 (12 Febrero)

* Clase: Problemas de ordenación
  * Práctico:
    * Repaso soluciones Clase 3
    * Ejercicios Clase4: búsqueda binaria y una opción de ordenación
  * Conceptos:
    * Pruebas y depuración
    * Conceptos básicos de complejidad
    * Algoritmos básicos de ordenación
    
* Lecturas recomendadas
  * Moodle: Pruebas y depuración en Java
  * Moodle: Estructuras de datos en Java
  * Moodle: Algoritmos de ordenación

### Día 5 (15 Febrero)

Laboratorio 0

Lecturas recomendadas: ver la clase anterior

### Día 6 (19 Febrero)

* Clase: Problemas de ordenación
  * Práctico:
    * Ordenación sobre el papel (I)
  * Conceptos:
    * Algoritmos de ordenación: inserción, selección, burbuja y merge sort
    
* Lecturas recomendadas
  * Moodle: Algoritmos de ordenación

### Día 7 (20 Febrero)

* Clase: Problemas de ordenación
  * Práctico:
    * Ordenación sobre el papel (II)
    * Implementaciones de todos los algoritmos
  * Conceptos:
    * Algoritmos de ordenación: quicksort 
    * Ordenación de cualquier tipo de elemento
* Lecturas recomendadas
  * Moodle: Algoritmos de ordenación

### Día 8 (21 Febrero)

* Clase: Complejidad (I)
  * Práctico:
    * Análisis de código y de complejidad de casos simples
  * Conceptos:
    * Complejidad algorítmica
* Lecturas recomendadas
  * Moodle: Complejidad

### Día 9 (26 Febrero)

* Clase: Complejidad (II)
  * Práctico:
    * Análisis de código y de complejidad sobre ejemplos de código
  * Conceptos:
    * Complejidad algorítmica
* Lecturas recomendadas
  * Moodle: Complejidad
* Ejercicios
  * Análisis de código y cálculo de complejidad (`tema02.EjerciciosCalculo`)

### Día 10 (27 Febrero)

* Clase: Complejidad (III)
  * Práctico:
    * Análisis de código y complejidad en algoritmos de ordenación
  * Conceptos:
    * Complejidad en ordenación
* Lecturas recomendadas
  * Moodle: Algoritmos de ordenación
* Ejercicios:
  * Completar análisis de los algoritmos restantes
  * Encontrar fallo en solución Clase 7

### Día 11 (27 Febrero)

Laboratorio 1

### Día 12 (4 marzo)

* Clase: Diccionarios (I)
  * Conceptos:
    * Diccionarios (Interfaz)
    * Implementación de diccionario con un array
    * Implementación de diccionario con arrays ordenados
* Ejercicios:
  * Implementar `DiccionarioArray` y `DiccionarioArrayOrdenado`

### Día 13 (6 marzo)

* Clase: Diccionarios (II)
  * Conceptos:
    * Implementación de diccionario con árboles binarios
    * Implementación de diccionario con tablas Hash
* Ejercicios:
  * Implementar `DiccionarioArbol` y `DiccionarioHash`

### Día 14 (11 marzo)

* Clase de problemas de examen

### Día 15 (13 marzo)

* Laboratorio 2
* Clase adicional de problemas de examen


### Día 16 (3 abril)

* Clase: Grafos (I)
  * Conceptos
      * Modelado de grafos
      * Aplicaciones de grafos
      * Terminología y categorización
      * Análisis de complejidad de dos posibles implementaciones: lista de arcos y matriz de adyacencia
      * Algoritmos sencillos (BFS, DFS)
* Ejercicios
  * Implementar la clase `Grafo` (Grafo no dirigido)
    * Implementar la clase `Arco` (arco no dirigido)

### Día 17 (8 abril)

* Clase: Grafos (II)
  * Conceptos:
    * BFS y DFS en profundidad
    * Implementación de BFS y DFS
    * Detección de componentes conexas
* Ejercicios:
  * Implementar componentes conexas

### Día 18 (15 abril)

* Clase: Grafos (III)
  * Conceptos:
    * BFS y DFS en profundidad
    * Implementación de BFS y DFS iterativa
    * Conceptos básicos del algoritmo de Prim
* Ejercicios:
  * Implementar Prim

### Día 19 (17 abril)

* Clase: Grafos (IV)
  * Conceptos:
    * Prim en profundidad
        * Análisis de complejidad
        * Listas vs colas de prioridad
    * El algoritmo de Dijkstra
        * Introducción
        * Problemas que resuelve
        * Diferencias con Prim
        * Limitaciones
* Ejercicios:
  * Implementar Dijkstra (con modelo de prácticas y con el modelo de este repositorio)

### Día 20 (22 abril)

* Clase: Grafos (V)
  * Ejercicios:
    * Implementación del algoritmo de Dijkstra
    * Problemas de examen
* Ejercicios
  * Repasar problemas de grafos

### Día 20 (24 abril)

* Clase: Concurrencia (I)
  * Conceptos:
    * Concurrencia
    * Procesos y hebras
    * Paralelismo


### Día 21 (29 abril)

* Clase: Concurrencia (II)
  * Ejercicios:
    * Conteo de palabras en ficheros
      * Sin sincronización
      * Con cerrojos
      * Con synchronized
      * Con un monitor

### Día 22 (6 mayo)

* Clase: COncurrencia (III)
  * Conceptos:
    * Sincronización condicional
    * `wait` y `notify` / `notifyAll`
    * Patrón productor / consumidor
  * Repaso:
    * Contador
  * Ejercicios:
    * Contador productor / consumidor
