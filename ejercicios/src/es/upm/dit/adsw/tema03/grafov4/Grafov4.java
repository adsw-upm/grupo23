package es.upm.dit.adsw.tema03.grafov4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import es.upm.dit.adsw.tema03.grafov1.Arista;
import es.upm.dit.adsw.tema03.grafov1.Nodo;
import es.upm.dit.adsw.tema03.grafov3.Grafo;

public class Grafov4 {
	
	public static Map<Integer, Arista> dijkstra(Grafo g, int id_origen) {
		
		// Diccionario edgeTo
		Map<Integer, Arista> edgeTo = new HashMap<>();
		// Distancia nodo
		Map<Integer, Integer> distancias = new HashMap<>();
		// Lista de posibles
		List<Integer> posibles = new ArrayList<>();
		
		distancias.put(id_origen, 0);
		edgeTo.put(id_origen, null);
		
		posibles.add(id_origen);
		
		while(!posibles.isEmpty()) {
			// Coger el posible con menor distancia
			int pos_menor = -1;
			int distancia_minima = Integer.MAX_VALUE;
			int id_menor = -1;
			
			for(int i=0; i<posibles.size(); i++) {
				int posible = posibles.get(i);
				int distancia_posible = distancias.get(posible);
				if(distancia_posible < distancia_minima) {
					distancia_minima = distancia_posible;
					pos_menor = i;
					id_menor = posible;
				}
			}
			posibles.remove(pos_menor);
		
			Nodo nodo_menor = g.getNodo(id_menor);
			for(Arista a: nodo_menor.getAristas()) {
				int distancia = distancia_minima + a.getPeso();
				
				int id_otro;
				if(a.getN1() == nodo_menor) {
					id_otro = a.getN2().getId();
				} else {
					id_otro = a.getN1().getId();
				}
				if(!distancias.containsKey(id_otro) || distancias.get(id_otro) > distancia) {
					posibles.add(id_otro);
					edgeTo.put(id_otro, a);
					distancias.put(id_otro, distancia);
				}
			}
			
		}
		
		
		// id_menor
		// distancia_menor
		
		
		
		
		return edgeTo;
	}
	
	public static void main(String[] args) {
		Grafo g = Grafo.crearEjemplo();
		g.print();
		
		Map<Integer, Arista> solucion = dijkstra(g, 0);
		for(int id_nodo: solucion.keySet()) {
			System.out.println("Nodo " + id_nodo + ": " + solucion.get(id_nodo));
		}
	}
}
