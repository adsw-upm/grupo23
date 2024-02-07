package es.upm.dit.adsw.g23.clases.tema01.Clase3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EjerciciosSolucionTest {
	static Integer[] arrayPositivos = {1, 2, 3, 4, 5};
	static Integer[] arrayNegativos = {-1, -2, -3, -4, -5};
	static Integer[] arrayRepetidos = {1, 2, 3, 4, 4};

	@Test
	void testMax() {
		assertEquals(5, EjerciciosSolucion.max(arrayPositivos));
	}
	@Test
	void testMaxNegativos() {
		assertEquals(-1, EjerciciosSolucion.max(arrayNegativos));
	}
	@Test
	void testMin() {
		assertEquals(1, EjerciciosSolucion.min(arrayPositivos));
	}
	@Test
	void testMinNegativos() {
		assertEquals(-5, EjerciciosSolucion.min(arrayNegativos));
	}
	
	@Test
	void testMaxOrdenados() {
		assertEquals(5, EjerciciosSolucion.maxOrdenados(arrayPositivos));
	}
	@Test
	void testTopV1() {
		// Nota: ¿qué pasa si usamos assertEquals?
		assertArrayEquals(new Integer[]{5}, EjerciciosSolucion.topV1(arrayPositivos, 1));
		assertArrayEquals(new Integer[]{5, 4}, EjerciciosSolucion.topV1(arrayPositivos, 2));
		assertArrayEquals(new Integer[]{-1}, EjerciciosSolucion.topV1(arrayNegativos, 1));
		assertArrayEquals(new Integer[]{-1, -2}, EjerciciosSolucion.topV1(arrayNegativos, 2));
	}
	@Test
	void testTopV2() {
		// Nota: ¿qué pasa si usamos assertEquals?
		assertArrayEquals(new Integer[]{5}, EjerciciosSolucion.topV2(arrayPositivos, 1));
		assertArrayEquals(new Integer[]{5, 4}, EjerciciosSolucion.topV2(arrayPositivos, 2));
		assertArrayEquals(new Integer[]{-1}, EjerciciosSolucion.topV2(arrayNegativos, 1));
		assertArrayEquals(new Integer[]{-1, -2}, EjerciciosSolucion.topV2(arrayNegativos, 2));
	}
	@Test
	void testTopV2_1() {
		// Nota: ¿qué pasa si usamos assertEquals?
		assertArrayEquals(new Integer[]{5}, EjerciciosSolucion.topV2_1(arrayPositivos, 1));
		assertArrayEquals(new Integer[]{5, 4}, EjerciciosSolucion.topV2_1(arrayPositivos, 2));
		assertArrayEquals(new Integer[]{-1}, EjerciciosSolucion.topV2_1(arrayNegativos, 1));
		assertArrayEquals(new Integer[]{-1, -2}, EjerciciosSolucion.topV2_1(arrayNegativos, 2));
	}
	@Test
	void testTopOrdenados() {
		// Nota: ¿qué pasa si usamos assertEquals?
		assertArrayEquals(new Integer[]{5}, EjerciciosSolucion.topOrdenados(arrayPositivos, 1));
		assertArrayEquals(new Integer[]{4, 4}, EjerciciosSolucion.topOrdenados(arrayRepetidos, 2));
	}
	@Test
	void testMedia() {
		assertEquals((5+4+3+2)/4, EjerciciosSolucion.media(arrayPositivos));
		assertEquals((-1-2-3-4)/4, EjerciciosSolucion.media(arrayNegativos));
		assertEquals((2+3+4+4)/4, EjerciciosSolucion.media(arrayRepetidos));
	}
	@Test
	void testMediaSinExtremosV1() {
		// Este test falla. Pregunta: ¿puedes encontrar el error? 
		assertEquals((4+3+2)/3, EjerciciosSolucion.mediaSinExtremosV1(arrayPositivos));
		assertEquals((-2-3-4)/3, EjerciciosSolucion.mediaSinExtremosV1(arrayNegativos));
		assertEquals((2+3+4)/3, EjerciciosSolucion.mediaSinExtremosV1(arrayRepetidos));
	}	
	@Test
	void testMediaSinExtremosV2() {
		assertEquals((4+3+2)/3, EjerciciosSolucion.mediaSinExtremosV2(arrayPositivos));
		assertEquals((-2-3-4)/3, EjerciciosSolucion.mediaSinExtremosV2(arrayNegativos));
		assertEquals((2+3+4)/3, EjerciciosSolucion.mediaSinExtremosV2(arrayRepetidos));
	}

}
