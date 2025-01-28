package es.upm.dit.adsw.g23.ejercicios.tema02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Ejemplos de funciones para estimación de complejidad.
 * 
 * Se deben realizar en orden, y con estos pasos:
 *  1. Leer el código
 *  2. Entender el algoritmo
 *  3. Explicar el algoritmo en lenguaje natural
 *  4. Realizar varios pasos con un ejemplo
 *  	p.e., array = {0, 1, 2, 5,}
 *  
 *  5. Incluir el código para problar el ejemplo en `main` y usar el depurador para
 *  comprobar los resultados.
 *  6. Estimar el orden de complejidad por intuición 
 *  7. Calcular el orden de complejidad de forma sistemática:
 *  
 *     p.e.:
 *         T(n) = O(1) + ...
 *         
 *         T(n) = O(n * ...)
 *     
 *  8. Abrir el fichero `EjemplosCalculoSolucion.md`
 *  9. Leer la documentación en la solución. Comprobar si coincide con lo esperado.
 *  10. La solución sobre el orden de complejidad está el final fichero.
 * 
 * El código de estos ejercicios utiliza nombres de funciones y variables poco 
 * descriptivos para ayudar a practicar los pasos 2 y 3. 
 */
public class EjemplosCalculo {
	public static void main(String[] args) {
		// 
		int[] array1 = new int[]{1, 2, 3, 4, 5, 4, 3, 2};
		ej01(5, array1); 
		ej02(2, array1);
		ej03(array1);
		ej04(array1);
	}

	/**
	 * Sin documentación, para practicar a leer código
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
	 * Sin documentación, para practicar a leer código
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
	 * Sin documentación, para practicar a leer código
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
	 * Sin documentación, para practicar a leer código
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
	 * Sin documentación, para practicar a leer código
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
	 * Sin documentación, para practicar a leer código
	 */
	public static int ej06(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		return sum;
	}
	
	/**
	 * Sin documentación, para practicar a leer código
	 */
	public static int ej07(int[] array) {
		Arrays.sort(array);
		return array[0];
	}
	
	/**
	 * Sin documentación, para practicar a leer código
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
	 * Sin documentación, para practicar a leer código
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
	 * Sin documentación, para practicar a leer código
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
	 * Sin documentación, para practicar a leer código
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
