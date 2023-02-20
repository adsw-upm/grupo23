package es.upm.dit.adsw.tema02.parejas;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parejas1 {
	
	public static Set<Integer> resolver(List<Integer> elementos, int objetivo) {
		Set<Integer> productos = new HashSet<Integer>();
		for(Integer i1: elementos) {
			for (Integer i2: elementos) {
				if (i1+i2 == objetivo) {
					productos.add(i1*i2);
				}
			}
		}
		return productos;
	}
}
