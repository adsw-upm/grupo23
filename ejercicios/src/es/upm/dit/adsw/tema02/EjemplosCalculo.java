package es.upm.dit.adsw.tema02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Ejemplos de funciones para estimación de complejidad.
 * 
 * Se deben realizar en orden, y con estos pasos:
 *  1. Leer el código sin leer los comentarios
 *  2. Entender el algoritmo
 *  3. Explicar el algoritmo en lenguaje natural
 *  4. Realizar varios pasos con un ejemplo
 *  	p.e., array = {0, 1, 2, 5,}
 *  
 *  5. Leer la documentación. Comprobar si coincide con lo esperado.
 *  6. Estimar el orden de complejidad por intuición 
 *  7. Calcular el orden de complejidad de forma sistemática:
 *  
 *     p.e.:
 *         T(n) = O(1) + ...
 *         
 *         T(n) = O(n * ...)
 *     
 *  8. Comprobar si el cálculo coincide con el del paso 6
 *
 * 
 * El código de estos ejercicios utiliza nombres de funciones y variables poco 
 * descriptivos para ayudar a practicar los pasos 2 y 3. 
 */
public class EjemplosCalculo {
	/**
	 * Busca un elemento en el array y devuelve su índice, o -1 si no se encuentra el elemento.
	 * @param number
	 * @param array
	 * @return
	 */
	public static int ej01(int number, int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Busca un elemento en el array. Devuelve todas las posiciones en las que se encuentra.
	 * @param number
	 * @param array
	 * @return
	 */
	public static List<Integer> ej02(int number, int[] array) {
		List<Integer> posiciones = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				posiciones.add(i);
			}
		}
		return posiciones;
	}
	
	/**
	 * Compara el último elemento del array con el primero
	 * @param array
	 * @return
	 */
	public static int ej03(int[] array) {
		if (array[array.length -1 ] > array[0]) {
			return 1;
		}else if (array[array.length -1 ] < array[0]) {
			return -1;
		} else {
			return 0;
		}
	}
	
	/**
	 * Comprueba si el último elemento de un array es mayor que alguno de los primeros cuatro elementos.
	 * @param array
	 * @return
	 */
	public static boolean ej04(int[] array) {
		for(int i=0; i<4; i++) {
			if (array[array.length -1 ] > array[i]) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Comprueba si el último elemento de un array es mayor que alguno de los b primeros elementos.
	 * @param array
	 * @param b Número de elementos a comparar
	 * @return
	 */
	public static boolean ej05(int[] array, int b) {
		for(int i=0; i<b; i++) {
			if (array[array.length -1 ] > array[i]) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Calcula la suma de todos los elementos de un array
	 * @param array
	 * @return
	 */
	public static int ej06(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}
	
	/**
	 * Busca el elemento mínimo de un array 
	 * @param array
	 * @return
	 */
	public static int ej07(int[] array) {
		Arrays.sort(array);
		return array[0];
	}
	
	/**
	 * Compara dos arrays del mismo tamaño elemento a elemento
	 * @param arr1
	 * @param arr2
	 * @return Número de posiciones en las que arr1 tiene un elemento mayor que arr2
	 */
	public static int ej08(int[] arr1, int[] arr2) throws Exception {
		int count = 0;
		if(arr1.length != arr2.length) {
			throw new Exception();
		}
		for(int i=0; i< arr1.length; i++) {
			if(arr1[i] > arr2[i]) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Cuenta el número de elementos en un array mayores que un cierto elemento de referencia.
	 * @param arr
	 * @param pivot Posición de referencia en el array
	 * @return
	 */
	public static int ej09(int[] arr, int pivot) {
		int count = 0;
		for(int i=1; i < arr.length; i++) {
			if(arr[i] > arr[pivot]) {
				count++;
			}
		}
		return count;
	}
	
	/**
	 * Cuenta cuántos elementos de arr1 están presentes en arr2
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static int ej10(int[] arr1, int[] arr2) {
		int count = 0;
		for(int i=0; i<arr1.length; i++) {
			for(int j=0; j<arr2.length; j++) {
				if(arr1[i] == arr2[j]) {
					count++;
					break;
				}
			}
		}
		return count;
	}

	/**
	 * Junta el contenido de dos arrays ordenados. El resultado está ordenado.
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public static int[] ej11(int[] arr1, int[] arr2) {
		int[] out = new int[arr1.length + arr2.length];
		int i = 0;
		int j = 0;
		int count = 0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i] > arr2[j]) {
				out[count++] = arr1[i++];
			} else {
				out[count++] = arr2[j++];
			}
		}
		while(i<arr1.length) {
			out[count++] = arr1[i++]; 
		}
		while(j<arr2.length) {
			out[count++] = arr2[j++]; 
		}
		return out;
	}

}

// Ej01: T(n) = O(n)
// Ej02: T(n) = O(n)
// Ej03: T(n) = O(1)
// Ej04: T(n) = O(1)
// Ej05: 
//    b<n => T(n, b) = O(b) -> O(n)
//    b >= n => T(n, b) = O(n)
// Ej06: T(n) = O(n)
// Ej07: T(n) = T_s(n) + O(1) = T_s(n). Sabemos que el mejor algoritmo en el mejor caso será O(n)
// Ej08: T(a, b) = O(min(a,b)) -> O(n), siendo n el tamaño del menor de ambos
// Ej09: T(n) = O(n)
// Ej10: T(a, b) = O(a*b), si a~=b=n => T(n) =
// Ej11: T(a, b) = O(max(a, b)), T(n) = O(n) 