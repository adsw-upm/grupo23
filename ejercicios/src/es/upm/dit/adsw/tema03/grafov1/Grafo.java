package es.upm.dit.adsw.tema03.grafov1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Grafo {
	Map<Integer, Nodo> nodos;
	
	public Grafo() {
		this.nodos = new HashMap<>();
	}
	
	public Nodo getNodo(int id) {
		return this.nodos.get(id);
	}
	
	public void insertarNodo(Nodo nuevo) {
		nodos.put(nuevo.id, nuevo);
	}
	
	public static void main(String[] args) {
		Grafo g = new Grafo();
		
		Nodo n0 = new Nodo(0);
		Nodo n1 = new Nodo(1);
		Nodo n2 = new Nodo(2);
		Nodo n3 = new Nodo(3);
		Nodo n4 = new Nodo(4);
		Nodo n5 = new Nodo(5);
		
		Arista a0_1 = new Arista(n0, n1, 5);
		Arista a0_3 = new Arista(n0, n3, 8);
		Arista a0_4 = new Arista(n0, n4, 9);
		n0.getAristas().add(a0_1);
		n0.getAristas().add(a0_3);
		n0.getAristas().add(a0_4);
		
		Arista a1_0 = a0_1;
		Arista a1_3 = new Arista(n1, n3, 15);
		Arista a1_2 = new Arista(n1, n2, 12);
		n1.getAristas().add(a1_0);
		n1.getAristas().add(a1_3);
		n1.getAristas().add(a1_2);
		
		Arista a2_1 = a1_2;
		Arista a2_3 = new Arista(n2, n3, 7);
		Arista a2_5 = new Arista(n2, n5, 1);
		n2.getAristas().add(a2_1);
		n2.getAristas().add(a2_3);
		n2.getAristas().add(a2_5);
		
		Arista a3_0 = a0_3;
		Arista a3_1 = a1_3;
		Arista a3_2 = a2_3;
		Arista a3_4 = new Arista(n3, n4, 5);
		Arista a3_5 = new Arista(n3, n5, 9);
		n3.getAristas().add(a3_0);
		n3.getAristas().add(a3_1);
		n3.getAristas().add(a3_2);
		n3.getAristas().add(a3_4);
		n2.getAristas().add(a3_5);

		Arista a4_0 = a0_4;
		Arista a4_3 = a3_4;
		Arista a4_5 = new Arista(n4, n5, 20);
		n3.getAristas().add(a4_0);
		n3.getAristas().add(a4_3);
		n2.getAristas().add(a4_5);

		Arista a5_2 = a2_5;
		Arista a5_3 = a3_5;
		Arista a5_4 = a4_5;
		n3.getAristas().add(a5_2);
		n3.getAristas().add(a5_3);
		n2.getAristas().add(a5_4);
	}
	

}
