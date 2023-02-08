public class CalculadoraMain {
	
	public static void main(String[] args) {
		int a = 5;
		String op = "-";
		int b = 10;
		
		int c = 0;
		if(op == "+") {
			c = a + b;
		} else if (op == "-") {
			c = a - b;
		} else {
			throw new IllegalArgumentException("operación no permitida");
		}
		System.out.println(a + " " + op + " " + b + " = " + c);
	}
}
