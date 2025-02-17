# Análisis del código y complejidad

## Ejemplo 01

```java
/**
 * Busca un elemento en el array y devuelve su índice, o -1 si no se encuentra el elemento.
 * @param number
 * @param array
 * @return índice del elemento encontrado, o -1
 */
```

<details>
  <summary>Orden de complejidad:</summary>
`T(n) = O(n)`
</details>

## Ejemplo 02

```java
/**
 * Busca un elemento en el array. Devuelve todas las posiciones en las que se encuentra.
 * @param number
 * @param array
 * @return Lista con todas las posiciones en las que se ha encontrado
 */

```

<details>
  <summary>Orden de complejidad:</summary>
`T(n) = O(n)`
</details>

## Ejemplo 03

```java
/**
 * Compara el último elemento del array con el primero
 * @param array
 * @return 1 si el último elemento es mayor, 0 si son iguales, o -1 si el primero es mayor
 */
```

<details>
  <summary>Orden de complejidad:</summary>
 `T(n) = k => O(1)`
</details>

## Ejemplo 04

```java
	
/**
 * Comprueba si el último elemento de un array es mayor que alguno de los primeros cuatro elementos.
 * @param array
 * @return true si algún elemento del comienzo es mayor
 */
```

<details>
  <summary>Orden de complejidad:</summary>
  `T(n) = 4 * k => O(1)`
</details>


## Ejemplo 05

```java
	
/**
 * Comprueba si el último elemento de un array es mayor que alguno de los b primeros elementos.
 * @param array
 * @param b Número de elementos a comparar
 * @return
 */
```

<details>
  <summary>Orden de complejidad:</summary>
  `T(n, b) = n * b * k`
  `b<<n => O(n)`
  `n<<b => O(k)`
</details>
## Ejemplo 06

```
/**
 * Calcula la suma de todos los elementos de un array
 * @param array
 * @return
 */
```

<details>
  <summary>Orden de complejidad:</summary>
 `T(n) = k * n => O(n)`
</details>


## Ejemplo 07

```java
/**
 * Busca el elemento mínimo de un array 
 * @param array
 * @return
 */
```
	
<details>
  <summary>Orden de complejidad:</summary>
 `T(n) = T_s(n) + O(1) = T_s(n)`. Tendríamos que consultar la documentación para el método `Arrays.sort`.

 Sabemos que el mejor algoritmo en el mejor caso será `O(n)`. El mejor algoritmo en el caso medio será `O(n*log(n))`.
</details>

## Ejemplo 08

```java
/**
 * Compara dos arrays del mismo tamaño elemento a elemento
 * @param arr1
 * @param arr2
 * @return Número de posiciones en las que arr1 tiene un elemento mayor que arr2
 */
```
<details>
  <summary>Orden de complejidad:</summary>
 `T(a, b) = O(min(a,b)) => O(n)`, siendo `n` el tamaño del menor de ambos
</details>



## Ejemplo 09

```java
/**
 * Cuenta el número de elementos en un array mayores que un cierto elemento de referencia.
 * @param arr
 * @param pivot Posición de referencia en el array
 * @return
 */
```
	
<details>
  <summary>Orden de complejidad:</summary>
 `T(n) = k * n => O(n)`
</details>


## Ejemplo 10

```java
/**
 * Cuenta cuántos elementos de arr1 están presentes en arr2
 * @param arr1
 * @param arr2
 * @return
 */
```

<details>
  <summary>Orden de complejidad:</summary>
 `T(a, b) = k * a * b => O(a*b), si a~=b ==n => O(n^2)`
</details>

## Ejemplo 11

```java
/**
 * Junta el contenido de dos arrays ordenados. El resultado está ordenado.
 * @param arr1
 * @param arr2
 * @return
 */
```

<details>
  <summary>Orden de complejidad:</summary>
  Si `a < b`:
 `T(a, b) = k_1 * solape(arr1, arr2) + k_2 * resto ~= k_1 * 2*a + (b-a) * k_2 => O(a+b)`
</details>


