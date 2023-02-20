package es.upm.dit.adsw.tema02.parejas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParejasTest4 {
	
	List<Integer> entrada;	
	static int SIZE = 10_000_000;
	Random rand;
	
	@BeforeEach
    void beforeAllTests() {
    	entrada = new ArrayList<Integer>();
		rand = new Random(); 
		for(int i=0; i<SIZE; i++) {
			entrada.add(rand.nextInt(SIZE));
		}		
	}

	@Test
	void test1() {
		List<Integer> entrada = Arrays.asList(1, 5, 10, 25, 29);
		assertEquals(2, Parejas2.resolver(entrada, 30).size());
	}

	@Test
	void testSimple() {
		Parejas2.resolver(entrada, SIZE).size();
	}

}
