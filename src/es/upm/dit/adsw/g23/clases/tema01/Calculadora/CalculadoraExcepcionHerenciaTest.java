package es.upm.dit.adsw.g23.clases.tema01.Calculadora;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;



class CalculadoraCientificaTest  {
	@Test
	void test() throws OperationException {
		CalculadoraExcepcionHerencia calc = new CalculadoraExcepcionHerencia(0);
		calc.calcular("+", 5);
		assertEquals(calc.ans, 5);
		calc.calcular("-", 2);
		assertEquals(calc.ans, 3);
	}
	
	@Test
	void testCientifica() throws OperationException {
		CalculadoraExcepcionHerencia calc = new CalculadoraCientifica(10);
		calc.calcular("^", 0);
		assertEquals(calc.ans, 1);
		calc = new CalculadoraCientifica(3);
		calc.calcular("^", 3);
		assertEquals(calc.ans, 27);
		
	}


}
