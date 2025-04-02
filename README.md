# Temario y ejercicios G23 ADSW 2025

Tabla de contenido visto en clase y problemas propuestos para ADSW.

El código del repositorio se divide en dos paquetes principales:
- `es.upm.dit.adsw.g23.clases`, que incluye el código utilizado durante las clases. Posiblemente haya partes incompletas o que no funcionen correctamente.
- `es.upm.dit.adsw.g23.ejercicios`, donde se incluye código incompleto. 

## Clases

### Día 0 (29 enero)

* Introducción de la asignatura
  * Contenido
  * Evaluación
  * Dinámica y organización de las clases
  * Cuestionario de inicio de la asignatura
* Conceptos
  * Algoritmo vs programa
* Problemas en clase
  * Encontrar líneas duplicadas en un fichero
* Ejercicios en casa
  * Instalar Java
  * Instalar Eclipse
  * Acceder a Hackerrank

### Día 1 (31 enero)

* Conceptos: Repaso Java
  * Orientación a objetos (en Java)
* Ejercicios
  * Encontrar líneas duplicadas en un fichero
* Ejercicios en casa:
  * Encontrar líneas duplicadas a partir de un fichero
  * Arreglar la implementación de [LineasRepetidasClase](./src/es/upm/dit/adsw/g23/clases/tema01/LineasRepetidasClase.java).

### Día 2 (3 febrero)

* Conceptos: Repaso Java
  * Estructuras de datos básicas (arrays, listas, conjuntos, diccionarios)
  * Pruebas unitarias (junit)
* Ejercicios
  * Encontrar líneas duplicadas en un fichero (varias implementaciones)
  * Pruebas básicas usando eclipse y junit
* Ejercicios en casa:
  * Encontrar fallos y arreglar `LineasRepetidas.java`
  * Desarrollar un método que acepte una lista de números enteros y devuelva otra lista con los mismos números, pero ordenados de mayor a menor.
  * Encontrar líneas duplicadas a partir de un fichero:
    * Usando sólo una lista (List)
    * Usando una lista y un conjunto (Set)
    * Usando una lista y un diccionario (Map)
  * Analizar los programas de clase y de ejercicios para líneas repetidas:
    * Intentar evaluar informalmente su eficiencia. ¿Hay alguno (claramente) mejor?, ¿por qué?
  * Opcional:
    * Encontrar líneas duplicadas a partir de un fichero:
        * Usando sólo un conjunto
        * Usar una clase común para las implementaciones anteriores (encontrar usando lista, conjunto, diccionario...)
        * Usar un interfaz común para las implementaciones anteriores (encontrar usando lista, conjunto, diccionario...)
    * Contar cuántas veces se repite cada línea, y devolver la palabra que más se repite (si hay empate, cualquiera de ellas)
        * Usando un diccionario
        * Usando dos listas
        * Usando una lista
        * Devolver tanto la palabra como el número de veces que se repite
    * Intentar encontrar optimizaciones en todos los algoritmos implementados. ¿Hay algo que se pueda hacer con menos operaciones?

### Día 3 (10 febrero)

* Ejercicios
  * Desarrollar un método que acepte una lista de números enteros y devuelva otra lista con los mismos números, pero ordenados de mayor a menor.
    * Con una nueva lista (selección)
      * Sin repetición
      * Con repetición
    * Reutilizando la lista (selección, inserción, burbuja)
* Ejercicios en casa:
  * Implementar los algoritmos vistos en clase
    * Desarrollar pruebas generales
    * Probar las implementaciones con las pruebas
  * Comparar el tiempo de ejecución de las implementaciones (benchmarking)
* Repasar transparencias:
  * Estructuras de datos
  * Depuración

### Día 4 (12 febrero)

* Conceptos
  * Complejidad (I)
* Ejercicios
  * Describir qué hacen los 4 algoritmos implementados en `CodigoClase.java`
* Ejercicios en casa:
  * Intentar estimar la complejidad de los 4 algoritmos vistos

### Día 5 (17 febrero)

* Conceptos
  * Complejidad (II)
  * Orden de complejidad
* Ejercicios
  * [tema02.EjemplosCalculo.java](./src/es/upm/dit/adsw/g23/clases/tema02/CalculoComplejidad.java)
* Ejercicios en casa:
  * Completar los ejercicios de [tema02.EjemplosCalculo.java](./src/es/upm/dit/adsw/g23/ejercicios/tema02/EjemplosCalculo.java)

### Día 6 (19 febrero)

Laboratorio 1.

### Día 7 (24 febrero)

* Conceptos
  * Complejidad (III)
  * Repaso de todos los conceptos
* Ejercicios
  * [EjercicioPuntoClase.java](./src/es/upm/dit/adsw/g23/ejercicios/tema02/EjercicioPuntoClase.java)

### Día 8 (26 febrero)

* Conceptos
  * Ordenación (I)
      * Bubble sort (repaso)
      * Insertion sort (repaso)
      * Selection sort (repaso)
      * Merge sort
      * Quicksort
* Ejercicios
  * Implementar todos los algoritmos vistos
  * Usar [visualgo](https://visualgo.net/en/sorting) para visualizar los algoritmos de ordenación vistos en clase

### Día 9 (3 marzo)

* Conceptos
  * Ordenación (II)
      * Bubble sort (complejidad)
      * Insertion sort (complejidad)
      * Selection sort (complejidad)
      * Quick sort (complejidad)
      * ~~Merge sort~~ (falta de tiempo)
* Ejercicios
  * Implementar todos los algoritmos vistos
  * Estimar la complejidad de los algoritmos vistos
    * Razonar caso mejor, peor y medio

### Día 10 (5 marzo)

* Conceptos
  * Ordenación (III)
      * Repaso + complejidad de los ya vistos
      * Quicksort (repaso rápido + complejidad)
  * Diccionarios (I)
      * Qué es un diccionario - la interfaz Diccionario
      * Diccionario con array
      * Diccionario con array ordenado
      * Árboles binarios de búsqueda
* Ejercicios
  * Implementar todos los algoritmos vistos

### Día 11 (10 marzo)

* Conceptos
  * Diccionarios (II)
    * Diccionario con array (repaso + complejidad)
    * Diccionario con array ordenado (repaso + complejidad)
    * Árboles binarios de búsqueda (repaso + complejidad)
* Ejercicios
  * Implementar todos los algoritmos vistos
  * Estimar la complejidad
    * De cada método (get, put, remove)
    * En cada alternativa vista (array, array ordenado, árbol)
    * En caso mejor, peor, medio

### Día 12 (12 marzo)

Laboratorio 2.

### Día 13 (17 marzo)

* Conceptos
  * Diccionarios (III)
    * Repaso
    * Tablas hash
* Ejercicios
  * Implementar todos los algoritmos restantes (hashmap)
  * Estimar la complejidad de los algoritmos restantes
  * Ejercicios examen
      * 2019-P1r: Pregunta 2: ListaEnlazadaOrdenada
      * 2017-P1: Pregunta 2: BST en array
      * 2012-F1:  Ejercicio 1: Algoritmos
      * 2018-F2:  1.2: Complejidad
      * 2015-F2:  Pregunta 1: Complejidad
      * 2016-P1r: Pregunta 1: Algoritmos
      * 2016-F2  Pregunta 2 P2: Algoritmos
      * 20220623-P1-sol: Pregunta 1: Algoritmos
      * 20210608-P1R: Pregunta 1
      * 2018-F2: Pregunta 2
      * 20210707-F1: Pregunta 2 : complejidad
      * 20210608-F1: Pregunta 2

### Día 14 (19 marzo)

* Resolución de ejercicios de examen
   - [x] 2012-F1:  Ejercicio 1: Algoritmos
   - [x] 2012-F1:  Ejercicio 2: Ordenación
   - [x] 2019-P1r: Pregunta 2: ListaEnlazadaOrdenada

### Día 15 (2 abril)

![](seguimiento.png)

URL: https://short.upm.es/xbguu

* HackerRank:
    * [Java](https://www.hackerrank.com/domains/java)
        * [Stdin/out](https://www.hackerrank.com/challenges/java-stdin-and-stdout-1/problem)
        * [Java ArrayList](https://www.hackerrank.com/challenges/java-arraylist)
    * [Algoritmos](https://www.hackerrank.com/domains/algorithms)
        * [Grading students](https://www.hackerrank.com/challenges/grading/problem)
    * [Estructuras de Datos](https://www.hackerrank.com/domains/data-structures)
        * [Insert node in a singly linked list](https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem?isFullScreen=true)
        * [Reverse a linked list](https://www.hackerrank.com/challenges/reverse-a-linked-list/problem)

* Exercism:
    * [Binary Search Tree (medio) - Ejemplo en clase](https://exercism.org/tracks/java/exercises/binary-search-tree)
    * [RNA (fácil)](https://exercism.org/tracks/java/exercises/rna-transcription)
    * [Linked List (medio)](https://exercism.org/tracks/java/exercises/linked-list)
    * [Flatten Array (medio)](https://exercism.org/tracks/java/exercises/flatten-array)
    * [Conway's Game of Life (medio)](https://exercism.org/tracks/java/exercises/game-of-life)
* Advent of Code
   * [2024](https://adventofcode.com/2024)
