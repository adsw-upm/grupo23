package es.upm.dit.adsw.tema03.grafov4;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import es.upm.dit.adsw.tema03.grafov1.Arista;
import es.upm.dit.adsw.tema03.grafov1.Nodo;
import es.upm.dit.adsw.tema03.grafov3.Grafo;

public class Grafov4_sol extends es.upm.dit.adsw.tema03.grafov3.Grafo {
	public static Map<Integer, Arista> dijkstra(Grafo g, int id_origen) {
		Map<Integer, Arista> camino = new HashMap();
		Map<Integer, Integer> prioridad = new HashMap();
		Map<Integer, Integer> distancia = new HashMap();
				
		Nodo origen = g.getNodo(id_origen);
		prioridad.put(id_origen, 0);
		camino.put(id_origen, null);
		distancia.put(id_origen, 0);
		
		while(!prioridad.isEmpty()) {
			int minimo = Integer.MAX_VALUE;
			int id_minimo = 0;
			for(int id: prioridad.keySet()) {
				int valor = prioridad.get(id);
				if(valor < minimo) {
					id_minimo = id;
					minimo = valor; 
				}
			}
			prioridad.remove(id_minimo);
			
			if(distancia.get(id_minimo) < minimo) {
				continue;
			}
						
			for(Arista arista: g.getNodo(id_minimo).getAristas()) {
				int suma = minimo + arista.getPeso();
				int id_otro = arista.getN1().getId();
				if(id_otro == id_minimo) {
					id_otro = arista.getN2().getId();
				}
				if(!distancia.containsKey(id_otro) || distancia.get(id_otro) > suma) {
					distancia.put(id_otro, suma);
					camino.put(id_otro, arista);
					prioridad.put(id_otro, suma);
				}
			}
			
			
		}		
		return camino;
	}
	public static void main(String[] args) {
		Grafo g = crearEjemplo();
		g.print();
		Map<Integer, Arista> d = dijkstra(g, 0);
		System.out.println("Dijkstra: " + d.size() + " aristas ");
		for(Entry<?, ?> e: d.entrySet()) {
			System.out.println(e.getKey() + " a través de " + e.getValue());
		}


	}

}
