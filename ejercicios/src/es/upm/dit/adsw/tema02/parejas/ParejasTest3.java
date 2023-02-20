package es.upm.dit.adsw.tema02.parejas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParejasTest3 {
	
	List<Integer> entrada;	
	static int SIZE = 100_000;
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
	void testSimple() {
		Parejas1.resolver(entrada, SIZE).size();
	}

}
