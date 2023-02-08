import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



class CalculadoraCientificaTest  {
	@Test
	void test() {
		CalculadoraHerencia calc = new CalculadoraHerencia(0);
		calc.calcular("+", 5);
		assertEquals(calc.ans, 5);
		calc.calcular("-", 2);
		assertEquals(calc.ans, 3);
	}
	
	@Test
	void testCientifica() {
		CalculadoraHerencia calc = new CalculadoraCientifica(10);
		calc.calcular("^", 0);
		assertEquals(calc.ans, 1);
		calc = new CalculadoraCientifica(3);
		calc.calcular("^", 3);
		assertEquals(calc.ans, 27);
		
	}


}
