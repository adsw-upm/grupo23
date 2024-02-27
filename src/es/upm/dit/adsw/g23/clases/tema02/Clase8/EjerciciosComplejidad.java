package es.upm.dit.adsw.g23.clases.tema02.Clase8;

import java.util.logging.Level;
import java.util.logging.Logger;

public class EjerciciosComplejidad {
    static Logger logger = Logger.getLogger("");
    
	public static void main(String[] args) {
		logger.setLevel(Level.ALL);
		logger.getHandlers()[0].setLevel(Level.ALL);
		int[] a = new int[] {4, 5};
		int[] b = new int[] {1, 3};
		int[] c = ejemplo07(a, b);
		System.out.println("Terminado");
		
	}
	
    public static int ejemplo01(int n){
    	int sq = n * n;
        try {
        	logger.fine("Resultado: " + sq);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return sq;
    }
    
    public static long ejemplo02(int n){
    	long resultado = 0;
    	for(int i=0; i<n; i++) {
    		resultado += ejemplo01(i);
    	}
    	return resultado;
    }
    
    public static int ejemplo03(int n) {
    	int total = 0;
    	for(int i=0; i<10; i++) {
    		total += i;
    	}
    	return total;
    }
    
    public static int ejemplo04(int n) {
    	int total = 0;
    	for(int i=0; i<n; i++) {
    		total += i;
    	}
    	return total;
    }
    
    public static String ejemplo05(int n) {
    	String t = "";
    	for(int i=0; i<10; i++) {
    		char c = 'o';
    		if(i % 2 == 0) {
    			c = 'x';
    		}
    		t += c;
    	}
		logger.fine(t);
		return t;

    }
    public static String ejemplo06(int n) {
    	String t = "";
    	for(int i=0; i<n; i++) {
    		char c = 'o';
    		if(i % 2 == 0) {
    			c = 'x';
    		}
    		t += c;
    	}
		logger.fine(t);
		return t;

    }
    
    public static String ejemplo07(int n) {
    	String t = "";
    	for(int i=0; i<n; i++) {
    		t += ejemplo06(n);
    		t += "\n";
    	}
		logger.fine(t);
		return t;

    }
    
    public static int ejemplo08(int n){
    	int total = n;
    	for(int i=0; i<10; i++) {
    		total -= i;
    	}
    	return total;
    }   
    
    public static int ejemplo09(int n){
    	int total = 0;
    	for(int i=0; i<n; i++) {
    		total += i;
    	}
    	return total;
    }
    
    public static int[] ejemplo07(int[] a, int[] b){
    	int[] resultado = new int[a.length + b.length];
    	for(int i=0; i<a.length; i++) {
    		resultado[i] = a[i];
    	}
    	for(int i=0; i<b.length; i++) {
    		resultado[a.length+i] = b[i];
    	}
    	return resultado;
    }
    
    public static int[] ejemplo10(int[] a, int[] b){
    	int[] resultado = new int[a.length + b.length];
    	int i = 0;
    	int j = 0;
    	for(int pos=0; pos<resultado.length; pos++) {
    		int valor;
    		if(i>=a.length) {
    			valor = b[j];
    			j++;
    		}else if(j >= b.length) {
    			valor = a[i];
    			i++;
    		} else if(a[i] < a[j]) {
    			valor = a[i];
    			i++;
    		} else {
    			valor = b[j];
    			j++;
    		}
    		resultado[pos] = valor;
    	}
    	return resultado;
    }
    
    public static int[] ejemplo11(int[] a, int[] b){
    	int[] resultado = new int[a.length + b.length];
    	int i = 0;
    	int j = 0;
    	for(int pos=0; pos<resultado.length; pos++) {
    		int valor;
    		if(i>=a.length) {
    			valor = b[j];
    			j++;
    		}else if(j >= b.length) {
    			valor = a[i];
    			i++;
    		} else if(a[i] < b[j]) {
    			valor = a[i];
    			i++;
    		} else {
    			valor = b[j];
    			j++;
    		}
    		resultado[pos] = valor;
    	}
    	return resultado;
    }
    
	public boolean ejemplo12(Float[] puntuaciones, float objetivo) {
		int a = 0;
		int b = puntuaciones.length - 1;
		while(a <= b) {
			int m = (a + b) / 2;
			if(puntuaciones[m] == objetivo) {
				return true;
			} else if(puntuaciones[m] < objetivo) {
				a = m + 1;
			} else {
				b = m - 1;
			}
		}
		return false;
	}
}