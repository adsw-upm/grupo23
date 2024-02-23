package es.upm.dit.adsw.g23.clases.tema02.Clase7;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

class SolucionesTest {
	public void assertOrdenado(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			assertTrue(arr[i] >= arr[i-1], "Los elementos en las posiciones " + i + " y " + (i-1) + " están mal ordenados");
		}
	}

	@Test
	void testSinOrdenar() {
		int[] arr1 = new int[] {5, 4, 3, 2, 1};
		try {
			assertOrdenado(arr1);
		} catch(AssertionError ex) {
			// Es lo que esperamos
		}

	}

	@Test
	void testBurbuja() throws Exception {
		int[] arr1 = new int[] { 5, 4, 3, 2, 1 };
		Soluciones.burbuja(arr1);
		assertOrdenado(arr1);
	}
	
	@Test
	void testSeleccion() throws Exception {
		int[] arr1 = new int[] { 5, 4, 3, 2, 1 };
		Soluciones.seleccion(arr1);
		assertOrdenado(arr1);
	}
	
	@Test
	void testInsercion() throws Exception {
		int[] arr1 = new int[] { 5, 4, 3, 2, 1 };
		Soluciones.insercion(arr1);
		assertOrdenado(arr1);
	}
	
	@Test
	void testMerge() throws Exception {
		int[] arr1 = new int[] { 5, 4, 3, 2, 1 };
		Soluciones.mergeSort(arr1);
		assertOrdenado(arr1);
	}
	
	@Test
	void testQuick() throws Exception {
		int[] arr1 = new int[] { 5, 4, 3, 2, 1 };
		Soluciones.quickSort(arr1);
		assertOrdenado(arr1);
	}
	
	
	@Test
	void testMergeExhaustivo() throws Exception {
		int tamano = 100;
		int num_muestras = 100000;
		// Hay que proporcionar una semilla para que siempre se generen los
		// mismos números.
		Random generator = new Random(0);
		for(int i=0; i<num_muestras; i++) {
			int []arr = new int[tamano];
			for(int j=0; j<tamano; j++) {
				arr[j] = generator.nextInt(1000);
			}
			Soluciones.mergeSort(arr);
			assertOrdenado(arr);
		}
	}
	//Ejercicio: hacer un método general que permita probar de forma
	// exhaustiva cualquiera de los métodos que hemos desarrollado.
	@Test
	void testQuickExhaustivo() throws Exception {
		int tamano = 100;
		int num_muestras = 100000;
		Random generator = new Random(0);
		for(int i=0; i<num_muestras; i++) {
			int []arr = new int[tamano];
			for(int j=0; j<tamano; j++) {
				arr[j] = generator.nextInt(1000);
			}
			Soluciones.quickSort(arr);
			assertOrdenado(arr);
		}
	}
	
}
