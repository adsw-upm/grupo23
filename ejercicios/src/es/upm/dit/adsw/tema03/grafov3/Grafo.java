package es.upm.dit.adsw.tema03.grafov3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import es.upm.dit.adsw.tema03.grafov1.Arista;
import es.upm.dit.adsw.tema03.grafov1.Nodo;

public class Grafo extends es.upm.dit.adsw.tema03.grafov2.Grafo {
	
	public static Grafo crearEjemplo() {
		Grafo g = new Grafo();
		for(int i=0; i<6; i++) {
			g.crearNodo(i);
		}
		g.conectar(0, 1, 5);
		g.conectar(0, 3, 8);
		g.conectar(0, 4, 9);
		
		g.conectar(1, 3, 15);
		g.conectar(1, 2, 12);
		
		g.conectar(2, 3, 7);
		g.conectar(2, 5, 1);
		
		g.conectar(3, 4, 5);
		g.conectar(3, 5, 9);
		
		g.conectar(4, 5, 20);
		return g;
	}

	private List<Arista> metodoMisterioso() throws Exception {
		// TODO: modificar este método para que devuelva un grafo
		List<Arista> salida = new ArrayList<>();
		List<Arista> opciones = new ArrayList<>();
		Set<Integer> visitados = new HashSet<>();
		
		Nodo n = this.nodos.values().iterator().next();
		visitados.add(n.getId());
		
		for(Arista a: n.getAristas()) {
			opciones.add(a);
		}

		while(visitados.size() < nodos.size()) {
			if(opciones.size() < 1) {
				throw new Exception("No hay opciones para seguir");
			}
			int min = Integer.MAX_VALUE;
			int posMin = -1;
			for(int i=0; i<opciones.size(); i++) {
				if(opciones.get(i).getPeso() < min) {
					posMin = i;
					min = opciones.get(i).getPeso();
				}
			}
			Arista minima = opciones.remove(posMin);
			int id1 = minima.getN1().getId();
			int id2 = minima.getN2().getId();
			if(visitados.contains(id1) && visitados.contains(id2)) {
				continue;
			}
			salida.add(minima);
			int otro = id1;
			if(visitados.contains(id1)) {
				otro = id2;
			}
			visitados.add(otro);
			for(Arista a: this.getNodo(otro).getAristas()) {
				opciones.add(a);
			}
		}		
		
		return salida;
	}
	
	
	public static void main(String[] args) {
		Grafo g = crearEjemplo();
		try {
			for(Arista a: g.metodoMisterioso()) {
				System.out.println(a);
			}
		}catch(Exception e) {
			System.out.println("No se pudo ejecutar:" + e.getLocalizedMessage());
		}
	}


}
