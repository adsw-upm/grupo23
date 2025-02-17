package es.upm.dit.adsw.g23.clases.tema02;

/**
 * Código usado en la clase del 17 de febrero
 */
public class CalculoComplejidad {
	public static boolean buscar1(int k, int[] numeros) {
		boolean encontrado = false;
		for(int i=0; i< numeros.length; i++) {
			if (numeros[i] == k) {
				encontrado = true;
			}
		}
		return encontrado;
	}
	public static boolean buscar2(int k, int[] numeros) {
		for(int i=0; i< numeros.length; i++) {
			if (numeros[i] == k) {
				return true;
			}
		}
		return false;
	}
	
	public static int repetidos1(int[] numeros) {
		int repetidos = 0;
		for(int i=0; i< numeros.length; i++) {
			for (int j=0; j< numeros.length; j++) {
				if (i == j) {
					continue;
				}
				if(numeros[i] == numeros[j]) {
					repetidos += 1;
				}
			}
		}
		return repetidos / 2;
	}

	public static int repetidos2(int[] numeros) {
		int repetidos = 0;
		for(int i=0; i< numeros.length; i++) {
			for (int j=0; j < i; j++) {
				if(numeros[i] == numeros[j]) {
					repetidos += 1;
				}
			}
		}
		return repetidos;
	}

	public static int repetidos3(int[] numeros) {
		return repetidos3(numeros, 0);
	}
	
	public static int repetidos3(int[] numeros, int pos) {
		if(numeros.length < 2) {
			return 0;
		}
		int repetidos = 0;
		for (int i=pos + 1; i < numeros.length; i++) {
			if(numeros[pos] == numeros[i]) {
				repetidos += 1;
			}
		}
		return repetidos + repetidos3(numeros, pos + 1);
	}

}
