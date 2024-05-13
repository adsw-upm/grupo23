package es.upm.dit.adsw.g23.clases.tema03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.Map;

import org.junit.jupiter.api.Test;

class TestContador {

	void comprobarVeces(Map<String, Integer> veces) {
		assertEquals(15092, veces.get("the"));
		assertEquals(6567, veces.get("a"));
		assertEquals(9, veces.get("ulysses"));
	}
	@Test
	void test01() throws IOException {
		Map<String, Integer> veces = Contador01Secuencial.contar("data/Ulysses.txt");
		comprobarVeces(veces);
	}
	
	@Test
	void test02() throws IOException {
		Map<String, Integer> veces = Contador02Concurrente.contar("data/Ulysses.txt");
		comprobarVeces(veces);
	}
	
	@Test
	void test03() throws IOException {
		Map<String, Integer> veces = Contador03Sincronizado.contar("data/Ulysses.txt");
		comprobarVeces(veces);
	}
	
	@Test
	void test04() throws IOException {
		Map<String, Integer> veces = Contador04Monitor.contar("data/Ulysses.txt");
		comprobarVeces(veces);
	}
	
	
	@Test
	void test05() throws IOException {
		Map<String, Integer> veces = Contador05ProductorConsumidor.contar("data/Ulysses.txt");
		comprobarVeces(veces);
	}

}
