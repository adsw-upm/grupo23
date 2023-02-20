package es.upm.dit.adsw.tema02.parejas;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parejas3 {
	
	public static Set<Integer> resolver(List<Integer> elementos, int objetivo) {
		Set<Integer> productos = new HashSet<Integer>();
		
		for(int i=0; i<elementos.size(); i++) {
			int i1 = elementos.get(i);
			for (int j=0; j<i; j++) {
				int i2 = elementos.get(j);
				if (i1+i2 == objetivo) {
					productos.add(i1*i2);
				}
			}
		}
		return productos;
	}
}
