package es.upm.dit.adsw.g23.clases.tema02.grafos;

import java.util.List;

public interface Grafo<Nodo> {
	/**
	 * 	Adds the undirected edge e to this edge-weighted graph.
	
	 * @param e
	 */
	void addEdge(Nodo desde, Nodo hacia);
	
	void addEdge(Nodo desde, Nodo hacia, double peso);
	void addEdge(Arco<Nodo> arco);
	
	/**
	 * 	Returns the edges incident on vertex v.
	 * @return
	 */
	java.lang.Iterable<Arco<Nodo>> adj(Nodo v);
	/**
	 * 	Returns the degree of vertex v.
	
	 * @param v
	 * @return
	 */
	int degree(Nodo v);
	/**
	 * 	Returns all edges in this edge-weighted graph.
	
	 * @return
	 */
	Iterable<Arco<Nodo>> edges();
	
	/**
	 * 	Returns the number of edges in this edge-weighted graph.
	 * @return
	 */
	int E();

	/**
	 * 	Returns the vertices in this edge-weighted graph.
	 * @return
	 */
	List<Nodo> V();
	
	/**
	 * 	Returns a string representation of the edge-weighted graph.
	 * @return
	 */
	String toString();

}
