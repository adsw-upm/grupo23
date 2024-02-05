package es.upm.dit.adsw.tema01.Calculadora;
public class CalculadoraMemoriaArgumentos {
	int ans = 0;
	
	public CalculadoraMemoriaArgumentos() {
		this(0);
	}
	
	public CalculadoraMemoriaArgumentos(int ans) {
		this.ans = ans;
	}
	
	void calcular(String op, int b) {
		int c = 0;
		if(op.equals("+")) {
			c = this.ans + b;
		} else if (op.equals("-")) {
			c = this.ans - b;
		} else if (op.equals("*")) {
			c = this.ans * b;
		} else {
			throw new IllegalArgumentException("operación no permitida: " + op); // Este tipo de excepción no hace falta declararla con throws en la cabecera
		}
		System.out.println(this.ans + " " + op + " " + b + " = " + c);
		this.ans = c;
	}
	
	public static void main(String[] args) {
		int a = Integer.parseInt(args[0]);
		String op = args[1];
		int b = Integer.parseInt(args[2]);

		CalculadoraMemoriaArgumentos calc = new CalculadoraMemoriaArgumentos(a);
		
		calc.calcular(op, b);
		calc.calcular("*", 30);
	}
}
