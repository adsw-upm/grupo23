# Temario y ejercicios G23 ADSW 2023

Tabla de contenido visto en clase y problemas propuestos para ADSW

## Introducción

### Día 0

* Clase:
  * Temario 
  * Calendario de la asignatura
  * Evaluación (prácticas, laboratorios)

### Día 1

* Clase: Repaso de conceptos básicos de programación.
  * Contexto de ADSW: ADSW vs PROG vs ingeniería de software
  * Sintáxis Java
    * Control
    * Tipos básicos de datos (int, String)
    * Estructuras de datos (arrays, listas...)
  * Orientación a objetos
    * Clases (herencia)
    * Más general: encapsulamiento (datos + comportamiento)
  * Intro a uso de eclipse
* Ejercicios:
  * `01_intro/DepuracionConcordancia.java`

### Día 2

* Clase:
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
    * ~Depuración~ (lo dejamos para la siguiente clase)
    * ~Visibilidad~ (lo dejamos para la siguiente clase)
* Ejercicios:
  * Desarrollar y ampliar la calculadora vista en clase
    * Guardar registro de operaciones
    * Aceptar argumentos del usuario
    * Desarrollar un menú independiente de la calculadora
      * Acepta comandos del usuario, línea a línea
      * Al iniciar, el usuario puede elegir el tipo de calculadora a usar
    * Números complejos (avanzado)
* Lecturas recomendadas:
  * Pruebas y depuración (moodle)
  * Estructuras de datos (moodle)

### Día 3

* Clase:
  * Conceptos:
    * Pruebas y depuración
    * Orientación a objetos
      * Encapsulamiento
      * Clasificación
      * Generalización
      * ~Polimorfismo~ (a repasar con las transparencias, y lo veremos mediante ejercicios)
    * Modelado (UML **muy** básico)
      * Diagramas de clases
      * ~Diagramas de objetos~ (para el próximo día)
  * Práctico
    * Continuación calculadora
      * Depuración
      * Pruebas
    * Modelo de calculadora
* Lecturas recomendadas
  * Modelado (moodle)
  * Pruebas y depuración (moodle)
* Ejercicios:
  * Dibujar el modelo de clases para las diferentes soluciones de calculadora
  * Continuar las mejoras a calculadora de la clase anterior
  * Opcional: modelar las clases nuevas de las mejoras (p.e., el menú) y su relación con el resto.

### Día 4

* Clase:
  * Conceptos:
    * Modelado (UML **muy** básico)
      * Diagramas de clases
      * Diagramas de objetos
  * Práctico
    * Modelo de red social (instagram)
* Lecturas recomendadas
  * Modelado (moodle)
  * Pruebas y depuración (moodle)
* Ejercicios:
  * Enunciado laboratorio 0

### Día 5

* Clase:
  * Conceptos:
    * Complejidad
    * Algoritmo vs programa
    * Ejercicios:
    * Comparación de los algoritmos de Parejas (paquete `es.upm.dit.adsw.tema02.parejas` en los ejercicios)

* Lecturas recomendadas
  * Algoritmos y complejidad

* Ejercicios:
 * Java Exception Handling (HackerRank)
 * Pairs (HackerRank)

### Día 6

* Clase
  * Conceptos
    * Complejidad
      * Cálculo de la fórmula recursiva
      * Estimación a partir de `T(n)`
    * Ordenación
      * Selección
      * Inserción
      * Bonus: *por conteo*
  * Ejercicios
    * Cálculo de complejidad de los algoritmos de ordenación
* Lecturas recomendadas
  * Algoritmos y complejidad
  * Complejidad (*Análisis de Algoritmos – Complejidad. José A. Mañas*)

### Día 7

* Clase
  * Ejercicios
    * Complejidad (ver `es.upm.dit.adsw.tema02.EjemplosCalculo`)
      * Cálculo de `T(n)`
      * Varios tipos de funciones: `O(1)`, `O(n)`, `O(log(n))`, `O(n^2)`.
  * Conceptos 
    * Complejidad
      * Aproximación a "divide y vencerás". Combinación de dos arrays ordenados
    * Ordenación
      * Repaso de los tipos de ordenación
      * Burbuja
      * Introducción a la combinación en `mergesort`
* Lecturas recomendadas
  * Ordenación (burbuja, selección e inserción)

### Día 8

* Clase
  * Conceptos
    * Ordenación
      * Mergesort (divide y vencerás)
      * Quicksort (fundamentos)
    * Complejidad
      * Aplicación de "divide y vencerás". Cálculo de complejidad
* Ejercicios recomendados
  * Laboratorio y práctica
* Lecturas recomendadas
  * Ordenación (repaso de las anteriores y mergesort)

### Día 9

* Clase

* Lecturas recomendadas
  * Ordenación (repaso de las anteriores y mergesort)
  
  
  
### Conceptos que hay que repasar

* Estabilidad en ordenación


### 2023/04/12

* Clase
  * Conceptos:
    * Conceptos de grafos
      * Nodos, vértices, tipos de aristas (dirección), pesos, caminos, ciclos
    * Problemas a resolver con grafos
    * Algoritmo de Prim
    * Algoritmo de Dijkstra
* Lecturas recomendadas
  * Transparencias sobre Prim 
  * Ejemplo de aplicación de Prim
  
### 2023/04/17

* Clase
  * Conceptos
    * Repaso del modelo de grafos (Grafo, Nodo, Arista)
  * Parte práctica
    * Introducción al modelo simplificado de grafos en el paquete `tema03` (en los laboratorios/prácticas se usará un modelo diferente)
    * Razonamiento de la evolución de la clase Grafo hasta Grafov3
  * Ejercicios
    * Leer y entender el código de `metodoMisterioso` en Grafov3
    * Relacionar el código con alguno de los algoritmos vistos
* Lecturas recomendadas
  * Transparencias sobre Prim 
  * Ejemplo de aplicación de Prim

### 2023/04/19

* Clase
  * Conceptos
    * Repaso de Dijkstra
  * Práctica
    * Implementar Dijkstra con el modelo de grafos Grafov3 y sin PQ

* Ejercicios 
  * Devolver caminos y pesos en Dijkstra
  * Implementar Dijkstra con la PQ de las transparencias (fichero "Algoritmo de Dijkstra" en moodle)
  * Implementar Dijkstra con el modelo de grafos de las transparencias (fichero "Algoritmo de Dijkstra" en moodle)

* Lecturas recomendadas
  * Transparencias sobre Dijkstra
  * Ejemplo de aplicación de Dijkstra
  
### 2023/04/24

* Clase
  * Conceptos
    * Concurrencia
    * Paralelismo (`concurrencia != paralelismo`)
    * Exclusión mutua
    * Estados de una hebra
    * Hebras en Java
      * class `Thread`
      * interface `Runnable`
  * Práctica
    * `es.upm.dit.adsw.tema04.EjemploInicial`
