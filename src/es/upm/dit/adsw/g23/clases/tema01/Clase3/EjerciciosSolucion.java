package es.upm.dit.adsw.g23.clases.tema01.Clase3;

import java.util.ArrayList;

public class EjerciciosSolucion {
	/**
	 * Devuelve el máximo de un array de elementos
	 * 
	 * @param numeros array con los números a comparar
	 * @return número mayor en el array
	 */
	public static int max(Integer[] numeros) {
		// TODO: Sería interesante añadir excepciones
		int m = Integer.MIN_VALUE;
		for (int numero : numeros) {
			if (numero > m) {
				m = numero;
			}
		}
		return m;
	}

	/**
	 * Devuelve el máximo de un array de elementos
	 * 
	 * @param numeros array con los números a comparar
	 * @return número mayor en el array
	 */
	public static int min(Integer[] numeros) {
		// TODO: Sería interesante añadir excepciones
		int m = Integer.MAX_VALUE;
		for (int numero : numeros) {
			if (numero < m) {
				m = numero;
			}
		}
		return m;
	}

	/**
	 * Devuelve el máximo de un array ordenado de elementos
	 * 
	 * @param numeros array ordenado con los números a comparar
	 * @return número mayor en el array
	 */
	public static Integer maxOrdenados(Integer[] numeros) {
		return numeros[numeros.length - 1];
	}

	/**
	 * Devuelve los números mayores en el array (top), hasta un máximo dado.
	 * 
	 * @param numeros array con los números a comparar
	 * @param tamano  número de elementos a devolver
	 * @return número mayor en el array
	 */
	public static Integer[] topV1(Integer[] numeros, int tamano) {
		// Algoritmo muy ineficiente. Lo analizaremos en clase.
		Integer[] top = new Integer[tamano];
		Integer[] pos_top = new Integer[tamano];

		// Recorremos los números para cada posición del top. Nos saltamos
		// los elementos que ya hayan sido seleccionados en pasadas anteriores

		// Nótese que no se puede guardar simplemente el valor de pasadas anteriores,
		// porque podría aparecer varias veces el mismo número.
		// p.e.: {0, 1, 2, 3, 3}

		for (int i = 0; i < tamano; i++) {
			int maximo = Integer.MIN_VALUE;
			int pos_maximo = -1;
			for (int j = 0; j < numeros.length; j++) {

				// comprobamos que este número no haya sido seleccionado ya
				boolean repetido = false;
				for (int k = 0; k < i; k++) {
					if (pos_top[k] == j) {
						repetido = true;
						break;
					}
				}
				if (repetido) {
					continue;
				}

				// Si el número no ha sido seleccionado antes, es un candidato a máximo
				if (numeros[j] > maximo) {
					maximo = numeros[j];
					pos_maximo = j;
				}
			}
			pos_top[i] = pos_maximo;
			top[i] = maximo;
		}
		return top;
	}

	/**
	 * Devuelve los números mayores en el array (top), hasta un máximo dado.
	 * 
	 * @param numeros array con los números a comparar
	 * @param tamano  número de elementos a devolver
	 * @return número mayor en el array
	 */
	public static Integer[] topV2(Integer[] numeros, int tamano) {
		Integer[] top = new Integer[tamano];
		for (int i = 0; i < tamano; i++) {
			top[i] = numeros[i];
		}

		for (int i = tamano; i < numeros.length; i++) {
			int pos_min = 0;
			int val_min = top[0];
			for (int j = 1; j < tamano; j++) {
				if (top[j] < val_min) {
					pos_min = j;
					val_min = top[j];
				}
			}
			if (val_min < numeros[i]) {
				top[pos_min] = numeros[i];
			}
		}
		return top;
	}

	/**
	 * Devuelve los números mayores en el array (top), hasta un máximo dado.
	 * 
	 * @param numeros array con los números a comparar
	 * @param tamano  número de elementos a devolver
	 * @return número mayor en el array
	 */
	public static Integer[] topV2_1(Integer[] numeros, int tamano) {
		// Versión alternativa a la anterior.
		Integer[] top = new Integer[tamano];
		for (int i = 0; i < tamano; i++) {
			top[i] = numeros[i];
		}

		int pos_min = -1;
		int val_min = Integer.MIN_VALUE;

		for (int i = tamano; i < numeros.length; i++) {
			// En este caso, sólo se re-calcula el menor cuando se hace un cambio del top.
			if (pos_min < 0) {
				val_min = top[0];
				pos_min = 0;
				for (int j = 1; j < tamano; j++) {
					if (top[j] < val_min) {
						pos_min = j;
						val_min = top[j];
					}
				}
			}
			if (val_min < numeros[i]) {
				top[pos_min] = numeros[i];
				// Ya no sabemos cuál es el mínimo. En la siguiente pasada habrá que
				// recalcularlo.
				pos_min = -1;
			}
		}
		return top;
	}

	/**
	 * Devuelve los números mayores en el array ordenado (top), hasta un máximo
	 * dado.
	 * 
	 * @param numeros array ordenado con los números a comparar
	 * @param tamano  número de elementos a devolver
	 * @return número mayor en el array
	 */
	public static Integer[] topOrdenados(Integer[] numeros, int tamano) {
		Integer[] top = new Integer[tamano];
		for (int i = 0; i < tamano; i++) {
			top[i] = numeros[numeros.length - 1 - i];
		}
		return top;
		// Alternativamente, mirar el método Array.copyOfRange
	}

	/**
	 * Calcula la nota media para un alumno, dadas las notas en varios apartados.
	 * Para el cálculo de la nota, se elimina la calificación mínima.
	 * 
	 * @param notas
	 * @return
	 */

	public static int media(Integer[] notas) {
		int suma = 0;
		int minima = Integer.MAX_VALUE;
		for (Integer nota : notas) {
			suma += nota;
			if (nota < minima) {
				minima = nota;
			}
		}
		return (suma - minima) / (notas.length - 1);
	}

	/**
	 * Calcula la puntuación media para un atleta, dadas las notas de varios jueces.
	 * Se deben ignorar la puntuación más alta y la más baja.
	 * 
	 * @param puntuaciones
	 * @return
	 */
	public static int mediaSinExtremosV1(Integer[] puntuaciones) {
		// Este código no funciona bien. Comprueba los tests e intenta arreglarlo.
		// Nuestra definición de media incluye eliminar la menor
		int sumaSinMinimo = media(puntuaciones) * (puntuaciones.length-1);
		int maximo = max(puntuaciones);
		return (sumaSinMinimo - maximo) / (puntuaciones.length - 2);
	}

	/**
	 * Calcula la puntuación media para un atleta, dadas las notas de varios jueces.
	 * Se deben ignorar la puntuación más alta y la más baja.
	 * 
	 * @param puntuaciones
	 * @return
	 */
	public static int mediaSinExtremosV2(Integer[] puntuaciones) {
		// En este caso, en lugar de recorrer el array varias veces para encontrar
		// máximo y mínimo,
		// vamos a calcular todo de una sola pasada.
		int suma = 0;
		int minima = Integer.MAX_VALUE;
		int maxima = Integer.MIN_VALUE;
		for (Integer puntuacion : puntuaciones) {
			suma += puntuacion;
			if (puntuacion < minima) {
				minima = puntuacion;
			}
			if (puntuacion > maxima) {
				maxima = puntuacion;
			}
		}
		return (suma - minima - maxima) / (puntuaciones.length - 2);
	}

	/**
	 * Comprueba si una array de puntuaciones incluye una puntuación objetivo.
	 * 
	 * @param puntuaciones array de puntuaciones recibidas
	 * @param objetivo     a buscar
	 * @return true si se encuentra la puntuación objetivo
	 */
	public static boolean incluye(Float[] notas, float objetivo) {
		for (Float nota : notas) {
			if (nota == objetivo) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Comprueba si un array de elementos está ordenado (orden ascendente).
	 * 
	 * @param numeros
	 * @return
	 */
	public static boolean estaOrdenado(Integer[] numeros) {
		for (int i = 1; i < numeros.length; i++) {
			if (numeros[i] < numeros[i - 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Comprueba si una lista de puntuaciones **ordenadas** incluye una puntuación
	 * objetivo.
	 * 
	 * @param puntuaciones array ordenado de puntuaciones recibidas
	 * @param objetivo     a buscar
	 * @return true si se encuentra la puntuación objetivo
	 */
	public static boolean incluyeOrdenadas(Float[] puntuaciones, float objetivo) {
		// Pendiente para la clase 4
		return false;
	}

	/**
	 * Devuelve una copia ordenada del array original.
	 * 
	 * @param numeros array de números a ordenar
	 * @return array ordenado de elementos
	 */
	public static Integer[] ordenar(Integer[] numeros) {
		// Pendiente para la clase 4
		return null;
	}
}
