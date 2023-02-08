public class CalculadoraBasica {
	
	static int calcular(int a, String op, int b) {
		int c = 0;
		if(op == "+") {
			c = a + b;
		} else if (op == "-") {
			c = a - b;
		}
		System.out.println(a + " " + op + " " + b + " = " + c);
		return c;
	}
	
	public static void main(String[] args) {
		int a = 5;
		String op = "-";
		int b = 10;
		
		int c = calcular(a, op, b);
		calcular(c, "+", 30);
	}
}
