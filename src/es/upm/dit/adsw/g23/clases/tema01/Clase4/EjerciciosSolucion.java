package es.upm.dit.adsw.g23.clases.tema01.Clase4;

import java.util.ArrayList;
import es.upm.dit.adsw.g23.clases.tema01.Clase3.*;


public class EjerciciosSolucion extends Ejercicios {

	/**
	 * Comprueba si una array de puntuaciones incluye una puntuación objetivo.
	 * 
	 * @param puntuaciones array de puntuaciones recibidas
	 * @param objetivo     a buscar
	 * @return true si se encuentra la puntuación objetivo
	 */
	public boolean incluye(Float[] notas, float objetivo) {
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
	public boolean estaOrdenado(Integer[] numeros) {
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
	public boolean incluyeOrdenadas(Float[] puntuaciones, float objetivo) {
		// Pendiente para la clase 4
		int a = 0;
		int b = puntuaciones.length - 1;
		while(a <= b) {
			int m = (a + b) / 2;
			if(puntuaciones[m] == objetivo) {
				return true;
			} else if(puntuaciones[m] < objetivo) {
				a = m + 1;
			} else {
				b = m - 1;
			}
		}
		return false;
	}

	/**
	 * Devuelve una copia ordenada del array original.
	 * 
	 * @param numeros array de números a ordenar
	 * @return array ordenado de elementos
	 */
	public Integer[] ordenar(Integer[] numeros) {
		// Pendiente para la clase 4
		return null;
	}
}
