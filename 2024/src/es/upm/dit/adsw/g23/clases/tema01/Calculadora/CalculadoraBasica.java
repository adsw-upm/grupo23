package es.upm.dit.adsw.g23.clases.tema01.Calculadora;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraBasica {
	int memoria;
	
	public CalculadoraBasica() {
		this.memoria = 0;
	}
	
	int calcular(String op, int b) {
		return this.calcular(this.memoria, op, b);
	}
	
	int calcular(int a, String op, int b) {
		int c = 0;
		if(op.equals("+")) {
			c = a + b;
		} else if (op.equals("-")) {
			c = a - b;
		} else {
			throw new IllegalArgumentException("operador no conocido");
		}
		System.out.println(a + " " + op + " " + b + " = " + c);
		this.memoria = c;
		return c;
	}
	
	public static void main(String[] args) {
		int a = Integer.parseInt(args[1]);
		String op = args[0];
		int b = Integer.parseInt(args[2]);
		
		CalculadoraBasica micalculadora = new CalculadoraBasica();
		
		micalculadora.calcular(a, op, b);
//		micalculadora.calcular("5 + 3");
	}
}
