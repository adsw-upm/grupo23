package es.upm.dit.adsw.g23.clases.tema02.Clase7;

public class Soluciones {
	/**
	 * Función de ayuda para el resto de métodos. Permite intercambiar dos posiciones
	 * en un array
	 */
	private static void intercambia(int[] array, int pos1, int pos2) {
		if(pos1 != pos2) {
			int t = array[pos1];
			array[pos1] = array[pos2];
			array[pos2] = t;
		}
	}

	/**
	 * Ordena el array dado usando BubbleSort en el sitio (in-place)
	 * @param array
	 */
	static void burbuja(int[] array) {
		for(int num_pasadas=1; num_pasadas<array.length;num_pasadas++) {
			for(int pos_derecha=1; pos_derecha<array.length;pos_derecha++){
				int pos_izquierda = pos_derecha - 1;
				if(array[pos_izquierda] > array[pos_derecha]) {
					intercambia(array, pos_izquierda, pos_derecha);
				}
			}
		}
	}
	static void burbujaParadaTemprana(int[] array) {
		for(int num_pasadas=1; num_pasadas<array.length; num_pasadas++) {
			boolean cambiado = false;
			for(int pos_derecha=1; pos_derecha<array.length;pos_derecha++){
				int pos_izquierda = pos_derecha - 1;
				if(array[pos_izquierda] > array[pos_derecha]) {
					intercambia(array, pos_izquierda, pos_derecha);
					cambiado = true;
				}
			}
			// Si en alguna pasada no ha habido cambios, el array
			// ya está ordenado.
			if(!cambiado) {
				break;
			}
		}
	}
	static void burbujaOptimizada(int[] array) {
		for(int num_pasadas=1; num_pasadas<array.length; num_pasadas++) {
			boolean cambiado = false;
			// No necesitamos comprobar hasta el final, porque los i últimos elementos
			// ya están ordenados
			for(int pos_derecha=1; pos_derecha<(array.length-num_pasadas);pos_derecha++){
				int pos_izquierda = pos_derecha - 1;
				if(array[pos_izquierda] > array[pos_derecha]) {
					intercambia(array, pos_izquierda, pos_derecha);
					cambiado = true;
				}
			}
			// Si en alguna pasada no ha habido cambios, el array
			// ya está ordenado.
			if(!cambiado) {
				break;
			}
		}
	}

	/**
	 * Ordena el array dado usando Selection Sort en el sitio (in-place)
	 * @param array
	 */
	static void seleccion(int[] array) {
		for(int pos_final=0; pos_final<array.length-1; pos_final++){
			int pos_menor = pos_final;
			for(int pos_candidato=pos_final+1; pos_candidato<array.length; pos_candidato++) {
				if(array[pos_candidato] < array[pos_menor]) {
					pos_menor = pos_candidato;
				}
			}
			if(pos_menor != pos_final) {
				intercambia(array, pos_menor, pos_final);
			}
		}
	}

	/**
	 * Ordena el array dado usando Insertion Sort en el sitio (in-place)
	 * @param array
	 */
	static void insercion(int[] array) {
		for(int pos_original=1; pos_original<array.length; pos_original++){
			int elemento = array[pos_original];
			int pos_final = pos_original;
			// Desplaza a la derecha todos los elementos mayores
			while(pos_final > 0 && array[pos_final-1] > elemento) {
				array[pos_final] = array[pos_final-1];
				pos_final--;
			}
			if(pos_final != pos_original) {
				array[pos_final] = elemento;
			}
		}
	}
	/**
	 * Ordena el array dado usando Merge Sort en el sitio (in-place)
	 * @param array
	 */
	static void mergeSort(int[] array) {
		mergeSort(array, 0, array.length);
	}

	static void mergeSort(int[] array, int a, int b) {
		int med = (a + b) / 2;
		// Las posiciones son:
		// [a, .., m] b
		// El último caso que requiere atención sería:
		// [a, a+1 ] b
		// En ese caso, m == (a + a+2) / 2 = a + 1
		if(med <= a) {
			return;
		}
		mergeSort(array, a, med);
		mergeSort(array, med, b);
		merge(array, a, med, b);
	}

	static void merge(int[] array, int a, int med, int b) {
		// El resultado final irá en array, tenemos que copiar 
		// los valores de los subarrays para poder ir
		// modificándolo en el sitio.
		int[] izquierda = new int[med-a];
		for(int i=a; i<med; i++) {
			izquierda[i-a] = array[i];
		}
		int[] derecha = new int[b-med];
		for(int i=med; i<b; i++) {
			derecha[i-med] = array[i];
		}

		int idx_izq = 0;
		int idx_dcha = 0;
		int pos_final = a;
		while(idx_izq < izquierda.length && idx_dcha < derecha.length) {
			if(derecha[idx_dcha] < izquierda[idx_izq]) {
				array[pos_final] = derecha[idx_dcha];
				idx_dcha++;
			} else {
				array[pos_final] = izquierda[idx_izq];
				idx_izq++;

			}
			pos_final++;
		}
		while(idx_izq < izquierda.length) {
			array[pos_final++] = izquierda[idx_izq++];
		}
		while(idx_dcha < derecha.length) {
			array[pos_final++] = derecha[idx_dcha++];
		}
	}

	/**
	 * Ordena el array dado usando Quick Sort en el sitio (in-place)
	 * @param array
	 */
	static void quickSort(int[] array) {
		quickSort(array, 0, array.length);
	}

	static void quickSort(int[] array, int a, int b) {
		if(a >= b) {
			return;
		}
		int pivot = a; 
		int comienzo_mayores = a+1;
		for(int pos_antigua=a+1; pos_antigua < b; pos_antigua++) {
			if(array[pos_antigua] < array[pivot]) {
				intercambia(array, comienzo_mayores, pos_antigua);
				comienzo_mayores++;
			}
		}
		intercambia(array, pivot, comienzo_mayores-1);
		quickSort(array, a, comienzo_mayores-1);
		quickSort(array, comienzo_mayores, b);
	}
}
