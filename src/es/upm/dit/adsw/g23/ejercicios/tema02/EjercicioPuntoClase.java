package es.upm.dit.adsw.g23.ejercicios.tema02;

import java.util.ArrayList;
import java.util.List;

public class EjercicioPuntoClase {
	public static List<Integer> ejercicio1(int number, int[] array) {
		List<Integer> coincidencias = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == number) {
				coincidencias.add(i);
			}
		}
		return coincidencias;
	}
	public static boolean ejercicio2(int k, int[] numeros) {
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 1; j < numeros.length; j++) {
				if (numeros[j - 1] > numeros[j]) {
					int t = numeros[j];
					numeros[j] = numeros[j - 1];
					numeros[j - 1] = t;
				}
			}
		}
		for(int i=0; i< numeros.length; i++) {
			if (numeros[i] == k) {
				return true;
			} else if (numeros[i] > k) {
				return false;
			}
		}
		return false;
	}
}
