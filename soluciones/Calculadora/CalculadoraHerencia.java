public class CalculadoraHerencia {
	int ans = 0;

	public CalculadoraHerencia(int ans) {
		this.ans = ans;
	}
	
	void calcular(String op, int b) throws OperationException {
		int c = 0;
		if(op == "+") {
			c = this.ans + b;
		} else if (op.equals("-")) {
			c = this.ans - b;
		} else {
			throw new OperationException(op);
		}
		System.out.println(this.ans + " " + op + " " + b + " = " + c);
		this.ans = c;
	}
	
	public static void main(String[] args) throws OperationException {
		int a = 5;

		CalculadoraCientifica calc = new CalculadoraCientifica(a);
		calc.calcular("+", 2);
		calc.calcular("^", 3);
	}
}

class CalculadoraCientifica extends CalculadoraHerencia {
	
	public CalculadoraCientifica(int a) {
		super(a);
	}

	public int exp(int b) {
		int base = this.ans;
		int c = 1;
		for(int i=0; i<b; i++) {
			c = c * base;
		}
		System.out.println(this.ans + "^" + b + " = " + c);
		this.ans = c;
		return this.ans;
	}
	
	@Override
	public void calcular(String op, int b) throws OperationException {
		try {
			super.calcular(op, b);
		} catch(OperationException ex){
			if(op.equals("^")) {
				this.exp(b);
			}
			else {
				throw new OperationException(op);
			}
		}
	}
	
}

class OperationException extends Exception {
	String op;
	
	public OperationException(String op) {
		this.op = op;
	}
}
