package es.upm.dit.adsw.g23.clases.tema02.Clase9;

public class Ejercicios {

	private static void intercambia(int[] array, int pos1, int pos2) {
		if (pos1 != pos2) {
			int t = array[pos1];
			array[pos1] = array[pos2];
			array[pos2] = t;
		}
	}

	static void cerveza(int[] array) {
		for (int num_pasadas = 1; num_pasadas < array.length; num_pasadas++) {
			for (int pos_derecha = 1; pos_derecha < array.length; pos_derecha++) {
				int pos_izquierda = pos_derecha - 1;
				if (array[pos_izquierda] > array[pos_derecha]) {
					intercambia(array, pos_izquierda, pos_derecha);
				}
			}
		}
	}

	static void rubia(int[] array) {
		for (int num_pasadas = 1; num_pasadas < array.length; num_pasadas++) {
			boolean cambiado = false;
			for (int pos_derecha = 1; pos_derecha < array.length; pos_derecha++) {
				int pos_izquierda = pos_derecha - 1;
				if (array[pos_izquierda] > array[pos_derecha]) {
					intercambia(array, pos_izquierda, pos_derecha);
					cambiado = true;
				}
			}
			if (!cambiado) {
				break;
			}
		}
	}

	static void tostada(int[] array) {
		for (int num_pasadas = 1; num_pasadas < array.length; num_pasadas++) {
			boolean cambiado = false;
			for (int pos_derecha = 1; pos_derecha < (array.length - num_pasadas); pos_derecha++) {
				int pos_izquierda = pos_derecha - 1;
				if (array[pos_izquierda] > array[pos_derecha]) {
					intercambia(array, pos_izquierda, pos_derecha);
					cambiado = true;
				}
			}
			if (!cambiado) {
				break;
			}
		}
	}

	static void camacho(int[] array) {
		for (int pos_final = 0; pos_final < array.length - 1; pos_final++) {
			int pos_menor = pos_final;
			for (int pos_candidato = pos_final + 1; pos_candidato < array.length; pos_candidato++) {
				if (array[pos_candidato] < array[pos_menor]) {
					pos_menor = pos_candidato;
				}
			}
			if (pos_menor != pos_final) {
				intercambia(array, pos_menor, pos_final);
			}
		}
	}

	static void juana(int[] array) {
		juana(array, 0, array.length);
	}

	static void juana(int[] array, int a, int b) {
		int med = (a + b) / 2;
		if (med <= a) {
			return;
		}
		juana(array, a, med);
		juana(array, med, b);
		loca(array, a, med, b);
	}

	static void loca(int[] array, int a, int med, int b) {
		int[] izquierda = new int[med - a];
		for (int i = a; i < med; i++) {
			izquierda[i - a] = array[i];
		}
		int[] derecha = new int[b - med];
		for (int i = med; i < b; i++) {
			derecha[i - med] = array[i];
		}

		int idx_izq = 0;
		int idx_dcha = 0;
		int pos_final = a;
		while (idx_izq < izquierda.length && idx_dcha < derecha.length) {
			if (derecha[idx_dcha] < izquierda[idx_izq]) {
				array[pos_final] = derecha[idx_dcha];
				idx_dcha++;
			} else {
				array[pos_final] = izquierda[idx_izq];
				idx_izq++;
			}
			pos_final++;
		}
		while (idx_izq < izquierda.length) {
			array[pos_final++] = izquierda[idx_izq++];
		}
		while (idx_dcha < derecha.length) {
			array[pos_final++] = derecha[idx_dcha++];
		}
	}

	static void cuña(int[] array) {
		for (int pos_original = 1; pos_original < array.length; pos_original++) {
			int elemento = array[pos_original];
			int pos_final = pos_original;
			while (pos_final > 0 && array[pos_final - 1] > elemento) {
				array[pos_final] = array[pos_final - 1];
				pos_final--;
			}
			if (pos_final != pos_original) {
				array[pos_final] = elemento;
			}
		}
	}

	static void gasol(int[] array) {
		gasol(array, 0, array.length);
	}

	static void gasol(int[] array, int a, int b) {
		if (a >= b) {
			return;
		}
		int pivot = a;
		int comienzo_mayores = a + 1;
		for (int pos_antigua = a + 1; pos_antigua < b; pos_antigua++) {
			if (array[pos_antigua] < array[pivot]) {
				intercambia(array, comienzo_mayores, pos_antigua);
				comienzo_mayores++;
			}
		}
		intercambia(array, pivot, comienzo_mayores - 1);
		gasol(array, a, comienzo_mayores - 1);
		gasol(array, comienzo_mayores, b);
	}
}
