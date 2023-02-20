package es.upm.dit.adsw.tema02.parejas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ParejasTest {
	
	@Test
	void test1() {
		List<Integer> entrada = Arrays.asList(1, 5, 10, 25, 29);
		assertEquals(2, Parejas1.resolver(entrada, 30).size());
	}

}
