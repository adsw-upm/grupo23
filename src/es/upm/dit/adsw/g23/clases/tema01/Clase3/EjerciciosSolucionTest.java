package es.upm.dit.adsw.g23.clases.tema01.Clase3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EjerciciosSolucionTest {
	EjerciciosSolucion solucion = new EjerciciosSolucion();
	static Integer[] arrayPositivos = {1, 2, 3, 4, 5};
	static Integer[] arrayNegativos = {-1, -2, -3, -4, -5};
	static Integer[] arrayRepetidos = {1, 2, 3, 4, 4};

	@Test
	protected void testMax() {
		assertEquals(5, solucion.max(arrayPositivos));
	}
	@Test
	protected void testMaxNegativos() {
		assertEquals(-1, solucion.max(arrayNegativos));
	}
	@Test
	protected void testMin() {
		assertEquals(1, solucion.min(arrayPositivos));
	}
	@Test
	protected void testMinNegativos() {
		assertEquals(-5, solucion.min(arrayNegativos));
	}
	
	@Test
	protected void testMaxOrdenados() {
		assertEquals(5, solucion.maxOrdenados(arrayPositivos));
	}
	@Test
	protected void testTopV1() {
		// Nota: ¿qué pasa si usamos assertEquals?
		assertArrayEquals(new Integer[]{5}, solucion.topV1(arrayPositivos, 1));
		assertArrayEquals(new Integer[]{5, 4}, solucion.topV1(arrayPositivos, 2));
		assertArrayEquals(new Integer[]{-1}, solucion.topV1(arrayNegativos, 1));
		assertArrayEquals(new Integer[]{-1, -2}, solucion.topV1(arrayNegativos, 2));
	}
	@Test
	protected void testTopV2() {
		// Nota: ¿qué pasa si usamos assertEquals?
		assertArrayEquals(new Integer[]{5}, solucion.topV2(arrayPositivos, 1));
		assertArrayEquals(new Integer[]{5, 4}, solucion.topV2(arrayPositivos, 2));
		assertArrayEquals(new Integer[]{-1}, solucion.topV2(arrayNegativos, 1));
		assertArrayEquals(new Integer[]{-1, -2}, solucion.topV2(arrayNegativos, 2));
	}
	@Test
	protected void testTopV2_1() {
		// Nota: ¿qué pasa si usamos assertEquals?
		assertArrayEquals(new Integer[]{5}, solucion.topV2_1(arrayPositivos, 1));
		assertArrayEquals(new Integer[]{5, 4}, solucion.topV2_1(arrayPositivos, 2));
		assertArrayEquals(new Integer[]{-1}, solucion.topV2_1(arrayNegativos, 1));
		assertArrayEquals(new Integer[]{-1, -2}, solucion.topV2_1(arrayNegativos, 2));
	}
	@Test
	protected void testTopOrdenados() {
		// Nota: ¿qué pasa si usamos assertEquals?
		assertArrayEquals(new Integer[]{5}, solucion.topOrdenados(arrayPositivos, 1));
		assertArrayEquals(new Integer[]{4, 4}, solucion.topOrdenados(arrayRepetidos, 2));
	}
	@Test
	protected void testMedia() {
		assertEquals((5+4+3+2)/4, solucion.media(arrayPositivos));
		assertEquals((-1-2-3-4)/4, solucion.media(arrayNegativos));
		assertEquals((2+3+4+4)/4, solucion.media(arrayRepetidos));
	}
	@Test
	protected void testMediaSinExtremosV1() {
		// Este test falla. Pregunta: ¿puedes encontrar el error? 
		assertEquals((4+3+2)/3, solucion.mediaSinExtremosV1(arrayPositivos));
		assertEquals((-2-3-4)/3, solucion.mediaSinExtremosV1(arrayNegativos));
		assertEquals((2+3+4)/3, solucion.mediaSinExtremosV1(arrayRepetidos));
	}	
	@Test
	protected void testMediaSinExtremosV2() {
		assertEquals((4+3+2)/3, solucion.mediaSinExtremosV2(arrayPositivos));
		assertEquals((-2-3-4)/3, solucion.mediaSinExtremosV2(arrayNegativos));
		assertEquals((2+3+4)/3, solucion.mediaSinExtremosV2(arrayRepetidos));
	}
	@Test
	protected void testIncluyeOrdenados() {
		// Nota: ¿qué pasa si usamos assertEquals?
		assert(solucion.incluyeOrdenadas(new Float[] {1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 5.0f));
		assert(!solucion.incluyeOrdenadas(new Float[] {1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 6f));
	}

}
