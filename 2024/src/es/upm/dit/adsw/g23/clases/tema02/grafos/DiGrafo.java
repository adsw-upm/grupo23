package es.upm.dit.adsw.g23.clases.tema02.grafos;

import java.util.List;

public interface DiGrafo<Nodo> {
	/**
	 * 	Adds the undirected edge e to this edge-weighted graph.
	
	 * @param e
	 */
	void addEdge(Nodo desde, Nodo hacia);
	
	void addEdge(Nodo desde, Nodo hacia, double peso);
	
	/**
	 * 	Returns the edges incident on vertex v.
	 * @return
	 */
	java.lang.Iterable<DiArco<Nodo>> adj(Nodo v);
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
	Iterable<DiArco<Nodo>> edges();
	
	/**
	 * 	Returns the number of edges in this edge-weighted graph.
	 * @return
	 */
	int E();

	/**
	 * 	Returns the number of vertices in this edge-weighted graph.
	 * @return
	 */
	Nodo[] V();
	/**
	 * 	Returns a string representation of the edge-weighted graph.
	 * @return
	 */
	String toString();

}
