package es.upm.dit.adsw.g23.clases.tema01.ordenacion;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class TestsClase {
	int[] arraySimple() {
		int[] array = {5, 4, 3, 2, 1};
		return array;
	}
	
	void assertOrdenado(int[] entrada, int[] resultado) {
		for(int i=1; i<resultado.length; i++) {
			if(resultado[i] < resultado[i-1]) {
				fail("El elemento en la posición " + i + " no está ordenado");
			}
		}
		int[] ordenada = Arrays.copyOf(entrada, entrada.length);
		Arrays.sort(ordenada);
		assertArrayEquals(ordenada, resultado);
	}

	@Test
	void testSimple1() {
		int[] array1 = {5, 4, 3, 2, 1};
		int[] resultado = CodigoClase.ordenar1(array1);
		assertOrdenado(array1, resultado);
	}
	
	@Test
	void testSimple2() {
		int[] array1 = {5, 4, 3, 2, 1};
		int[] resultado = CodigoClase.ordenar2(array1);
		assertOrdenado(array1, resultado);
	}
	
	@Test
	void testSimple3() {
		int[] array1 = {5, 4, 3, 2, 1};
		int[] resultado  = CodigoClase.ordenar3(array1);
		assertOrdenado(array1, resultado);
	}
	@Test
	void testSimple4() {
		int[] array1 = {5, 4, 3, 2, 1};
		int[] resultado = CodigoClase.ordenar4(array1);
		assertOrdenado(array1, resultado);
	}
	
//	@Test
//	void testRepeticion1() {
//		int[] array1 = {4, 4, 3, 2, 1};
//		int[] resultado = CodigoClase.ordenar1(array1);
//		assertOrdenado(array1, resultado);
//	}
//	@Test
//	void testRepeticion2() {
//		int[] array1 = {4, 4, 3, 2, 1};
//		int[] resultado = CodigoClase.ordenar2(array1);
//		assertOrdenado(array1, resultado);
//	}
//	@Test
//	void testRepeticion3() {
//		int[] array1 = {4, 4, 3, 2, 1};
//		int resultado[] = CodigoClase.ordenar3(array1);
//		assertOrdenado(array1, resultado);
//	}
//	
//	@Test
//	void testRepeticion4() {
//		int[] array1 = {4, 4, 3, 2, 1};
//		int[] resultado = CodigoClase.ordenar4(array1);
//		assertOrdenado(array1, resultado);
//	}
}
