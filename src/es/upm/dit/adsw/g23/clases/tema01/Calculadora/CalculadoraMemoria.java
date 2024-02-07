package es.upm.dit.adsw.g23.clases.tema01.Calculadora;
public class CalculadoraMemoria {
	int ans = 0;
	
	public CalculadoraMemoria() {
		this(0);
	}
	
	public CalculadoraMemoria(int ans) {
		this.ans = ans;
	}
	
	void calcular(String op, int b) {
		int c = 0;
		if(op == "+") {
			c = this.ans + b;
		} else if (op == "-") {
			c = this.ans - b;
		} else {
			throw new IllegalArgumentException("operación no permitida"); // Este tipo de excepción no hace falta declararla con throws en la cabecera
		}
		System.out.println(this.ans + " " + op + " " + b + " = " + c);
		this.ans = c;
	}
	
	public static void main(String[] args) {
		int a = 5;
		String op = "-";
		int b = 10;

		CalculadoraMemoria calc = new CalculadoraMemoria(a);
		
		calc.calcular(op, b);
		calc.calcular("*", 30);
	}
}
