package es.upm.dit.adsw.tema02.parejas;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Parejas2 {
	
	public static Set<Integer> resolver(List<Integer> elementos, int objetivo) {
		Set<Integer> productos = new HashSet<Integer>();
		Set<Integer> existente = new HashSet<Integer>();
		for(Integer i1: elementos) {
			existente.add(objetivo - i1);
			if(existente.contains(i1)) {
				productos.add(i1 * (objetivo-i1));
			}
		}
		return productos;
	}
}
