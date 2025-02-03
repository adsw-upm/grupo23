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

### Día 2 (3 enero)

* Conceptos: Repaso Java
  * Estructuras de datos básicas (arrays, listas, conjuntos, diccionarios)
  * Pruebas unitarias (junit)
* Ejercicios
  * Encontrar líneas duplicadas en un fichero (varias implementaciones)
  * Pruebas básicas usando eclipse y junit
* Ejercicios en casa:
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
