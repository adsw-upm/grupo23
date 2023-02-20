package es.upm.dit.adsw.tema02.parejas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParejasTest2 {
	
	List<Integer> entrada;	
	static int SIZE = 1000;
	
	@BeforeEach
    void beforeAllTests() {
    	entrada = new ArrayList<Integer>();
		for(int i=0; i<SIZE; i++) {
			entrada.add(i);
		}		
	}

	@Test
	void testSimple() {
		assertEquals(SIZE/2, Parejas1.resolver(entrada, SIZE).size());
	}

}
