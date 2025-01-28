package es.upm.dit.adsw.g23.clases.tema01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class LineasRepetidasTest {

	@Test
	void testSinDuplicados() {
		List<String> lineas = new ArrayList<String>();
		lineas.add("01");
		lineas.add("02");
		lineas.add("03");
		
		int encontradas = LineasRepetidas05.contarRepetidas(lineas);
		assertEquals(0, encontradas);
	}
	@Test
	void test1Duplicado() {
		List<String> lineas = new ArrayList<String>();
		lineas.add("01");
		lineas.add("02");
		lineas.add("03");
		lineas.add("02");
		
		int encontradas = LineasRepetidas05.contarRepetidas(lineas);
		assertEquals(1, encontradas);
	}
	/**
	 * Comprobar que no hay error cuando no se suministran líneas.
	 */
	@Test
	void testVacio() {
		List<String> lineas = new ArrayList<String>();
		int encontradas = LineasRepetidas05.contarRepetidas(lineas);
		assertEquals(0, encontradas);
	}

}
