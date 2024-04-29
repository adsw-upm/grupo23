package es.upm.dit.adsw.g23.clases.tema02.grafos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;



/**
 * Clase para implementar métodos básicos de grafos y realizar smoketests.
 * @param <Nodo>
 */
public class AlgoritmosGrafos  {

	public static <Nodo> boolean conectadosDFS(DiGrafo<Nodo> grafo,
												Nodo primero,
												Nodo segundo) {
		return conectadosDFSrecursivo(grafo, primero, segundo, new HashSet<Nodo>());
	}
	
	public static <Nodo> boolean conectadosDFSrecursivo(DiGrafo<Nodo> grafo, Nodo primero, Nodo segundo, HashSet<Nodo> visitados) {
		if(primero == segundo) {
			return true;
		}
		if(visitados.contains(primero)) {
			return false;
		}
		addAndPrint(visitados, primero);
		for(DiArco<Nodo> arco: grafo.adj(primero)) {
			if(conectadosDFSrecursivo(grafo, arco.hacia, segundo, visitados)) {
				return true;
			}
		}
		return false;

	}
	public static <Nodo> void addAndPrint(HashSet<Nodo> visitados, Nodo nodo) {
		System.out.print("Visitados: ");
		for(Nodo n: visitados) {
			System.out.print(n + ", ");
		}
		visitados.add(nodo);
		System.out.println(nodo);

	}
	public static <Nodo> boolean conectadosDFSiterativo(DiGrafo<Nodo> grafo, Nodo primero, Nodo segundo) {
		HashSet<Nodo> visitados = new HashSet<>();
		List<Nodo> siguientes = new ArrayList<>();
		
		siguientes.add(primero);
		while(!siguientes.isEmpty()) {
			Nodo siguiente = siguientes.remove(siguientes.size()-1);
			if(segundo == siguiente) {
				return true;
			}
			if(visitados.contains(siguiente)) {
				continue;
			}
			addAndPrint(visitados, siguiente);
			for(DiArco<Nodo> conectado: grafo.adj(siguiente)) {
				siguientes.add(conectado.hacia);
			}
		}
		return false;
	}
	
	/**
	 * Método que comprueba si existe algún posible camino entre el primer y el segundo nodo
	 * @param <Nodo>
	 * @param grafo Grafo dirigido
	 * @param primero Nodo de origen
	 * @param segundo Nodo de destino
	 * @return
	 */
	public static <Nodo> boolean conectadosBFSiterativo(DiGrafo<Nodo> grafo, Nodo primero, Nodo segundo) {
		HashSet<Nodo> visitados = new HashSet<>();
		List<Nodo> siguientes = new ArrayList<>();
		
		siguientes.add(primero);
		while(!siguientes.isEmpty()) {
			Nodo siguiente = siguientes.remove(0);
			if(segundo == siguiente) {
				return true;
			}
			if(visitados.contains(siguiente)) {
				continue;
			}
			addAndPrint(visitados, siguiente);
			for(DiArco<Nodo> conectado: grafo.adj(siguiente)) {
				siguientes.add(conectado.hacia);
			}
		}
		return false;
	}

	/**
	 * Calcula un posible Minimum Spanning Tree (árbol de expansión mínima) para el grafo dado
	 * @param <Nodo>
	 * @param grafo
	 * @return
	 */
	public static <Nodo extends Comparable<? super Nodo>> Grafo<Nodo> prim(Grafo<Nodo> grafo) {
		Set<Nodo> visitados = new HashSet<Nodo>();
		List<Arco<Nodo>> pendientes = new ArrayList<Arco<Nodo>>();
		Grafo<Nodo> mst = new GrafoLista<Nodo>();
		
		List<Nodo> nodos = grafo.V();
		Nodo primero = nodos.get(0);
		for(Arco<Nodo> arco: grafo.adj(primero)) {
			pendientes.add(arco);
		}
		while((!pendientes.isEmpty()) && visitados.size() < nodos.size()) {
			int pos = 0;
			double minimo = pendientes.get(0).peso;
			for(int i=1; i < pendientes.size(); i++) {
				if(pendientes.get(i).peso < minimo) {
					minimo = pendientes.get(i).peso;
					pos = i;
				}
			}
			Arco<Nodo> siguiente = pendientes.remove(pos);
			Nodo nuevo = siguiente.uno();
			if(visitados.contains(nuevo)) {
				nuevo = siguiente.otro(nuevo);
				if(visitados.contains(nuevo)) {
					continue;
				}
			}
			visitados.add(nuevo);
			mst.addEdge(siguiente.otro(nuevo), nuevo, siguiente.peso);
			for(Arco<Nodo> arco: grafo.adj(nuevo)) {
				pendientes.add(arco);
			}
		}
		return mst;
	}
	
	
	/**
	 * Calcula todos los caminos mínimos desde el nodo origen en el grafo dado. Esta versión es para grafos no dirigidos.
	 * @param <Nodo>
	 * @param grafo Grafo no dirigido.
	 * @param origen Nodo de origen
	 * @return Diccionario de destinos y último arco del camino óptimo del origen a ese destino.
	 */
	public static <Nodo extends Comparable<? super Nodo>> Map<Nodo, Arco<Nodo>> dijkstra(Grafo<Nodo> grafo, Nodo origen) {
		// El diccionario que contiene la ruta por camino óptimo
		Map<Nodo, Arco<Nodo>> edgeTo = new HashMap<Nodo, Arco<Nodo>>();
		// Diccionario con las distancias óptimas a cada nodo
		Map<Nodo, Double> distancias = new HashMap<Nodo, Double>();
		
		// Cola de arcos sin explorar.
		// Necesitamos ordenar por el peso TOTAL de un camino, no por el peso de cada nodo.
		// Por ello, hemos creadouna clase nueva para representar una opción con su peso.
		PriorityQueue<PunteroCamino<Nodo>> opciones = new PriorityQueue<>();
		
		// Al comienzo, todas las distancias son infinito
		for(Nodo destino: grafo.V()) {
			distancias.put(destino, Double.POSITIVE_INFINITY);
		}
		
		// Añadimos una opción al comienzo para llegar al nodo origen
		// Otra alternativa hubiera sido añadir los arcos adyacentes
		opciones.add(new PunteroCamino<Nodo>(null, 0.0, origen));
		
		while(true) {
			PunteroCamino<Nodo> puntero = opciones.poll();
			if(puntero == null) {
				break;
			}
			double distancia = puntero.pesoTotal;
			Nodo siguiente = puntero.siguiente;
			if(distancia > distancias.get(siguiente)) {
				continue;
			}
			distancias.put(siguiente, distancia);
			edgeTo.put(siguiente, puntero.ultimo);
			for(Arco<Nodo> vecino: grafo.adj(siguiente)) {
				opciones.add(new PunteroCamino<Nodo>(vecino, vecino.peso + distancia, vecino.otro(siguiente)));
			}
		}
				
		return edgeTo;
	}
	
	
	/**
	 * Ampliación de Prim para devolver el Minimum Spanning Forest (bosque de expansión mínima)
	 * También incluye dos modificaciones sobre la implementación original.
	 * 
	 * La primera es que usa el MST/MSF para comprobar si un nodo ya ha sido comprobado, en lugar de guardar un array o un conjunto adicional.
	 * 
	 * La segunda es que en lugar de utilizar una lista de arcos siguientes, utiliza una cola de prioridad, igual que hemos visto en la implementación
	 * de Dijkstra.
	 * 
	 * @param grafo
	 * @return Uno de los posibles Bosques de Expansión Mínima para el grafo inicial. 
	 */
	public static <Nodo extends Comparable<? super Nodo>> Grafo<Nodo> primNoConexo(Grafo<Nodo> grafo) {
		Grafo<Nodo> msf = new GrafoLista<Nodo>();
		
		for(Nodo nodo: grafo.V()) {
			primNoConexo(grafo, nodo, msf);
		}
		return msf;
	}
	
	/**
	 *  En el método auxiliar devolvemos void porque obtenemos el grafo como argumento y lo modificamos.
	 *  Una versión alternativa de este código podría devolver un grafo, y NO modificar el msf proporcionado.
	 * @param <Nodo> Tipo de elemento a utilizar como nodo.
	 * @param grafo Grafo original
	 * @param primero Nodo por el que comenzar el MSF
	 * @param msf MSF hasta el momento.
	 */
	private static <Nodo extends Comparable<? super Nodo>> void primNoConexo(Grafo<Nodo> grafo, Nodo primero, Grafo<Nodo> msf) {
		if(msf.V().contains(primero)) {
			return;
		}
		PriorityQueue<PunteroCamino<Nodo>> pendientes = new PriorityQueue<PunteroCamino<Nodo>>();
		for(Arco<Nodo> arco: grafo.adj(primero)) {
			pendientes.add(new PunteroCamino<Nodo>(arco, arco.peso, arco.otro(primero)));
		}
		while((!pendientes.isEmpty())) {
			PunteroCamino<Nodo> puntero = pendientes.poll();
			Nodo siguiente = puntero.siguiente;
			Arco<Nodo> arco = puntero.ultimo;
			if(msf.V().contains(siguiente)) {
				continue;
			}
			msf.addEdge(arco);
			for(Arco<Nodo> vecino: grafo.adj(puntero.siguiente)) {
				pendientes.add(new PunteroCamino<Nodo>(vecino, vecino.peso, vecino.otro(puntero.siguiente)));
			}
		}
		return;
	}
	
	/**
	 * Crea un grafo dirigido de prueba.
	 * @return
	 */
	public static DiGrafo<Integer> nuevoDiGrafo() {
		DiGrafo<Integer> grafo = new DiGrafoLista<Integer>();
		grafo.addEdge(0,  1);
		grafo.addEdge(1, 0);
		grafo.addEdge(1, 2);
		grafo.addEdge(2, 1);
		grafo.addEdge(0, 3);
		grafo.addEdge(3, 0);
		grafo.addEdge(3, 4);
		grafo.addEdge(4, 3);
		grafo.addEdge(0, 5);
		grafo.addEdge(5, 0);
		
		
		grafo.addEdge(6, 7);
		grafo.addEdge(7, 6);
		grafo.addEdge(3, 9);
		grafo.addEdge(9, 3);
		return grafo;
	}

	/**
	 * Crea un nuevo grafo no dirigido de prueba.
	 * @return
	 */
	public static Grafo<Integer> nuevoGrafo() {
		Grafo<Integer> grafo = new GrafoLista<Integer>();
		grafo.addEdge(0, 1, 5);
		grafo.addEdge(0, 3, 8);
		grafo.addEdge(0, 4, 9);
		grafo.addEdge(1, 3, 15);
		grafo.addEdge(1, 2, 12);
		grafo.addEdge(2, 5, 1);
		grafo.addEdge(2, 3, 7);
		grafo.addEdge(3, 4, 5);
		grafo.addEdge(3, 5, 9);
		grafo.addEdge(4, 5, 20);
		return grafo;
	}
	
	/**
	 * Crea un grafo no dirigido y no conexo para las pruebas.
	 * @return
	 */
	public static Grafo<Integer> nuevoGrafo2() {
		Grafo<Integer> grafo = nuevoGrafo();
		grafo.addEdge(6, 7);
		grafo.addEdge(7, 8);
		return grafo;
	}
	
	/**
	 * Smoketest de BFS y DFS
	 */
	public static void pruebaBFSyDFS() {
		DiGrafo<Integer> grafo = nuevoDiGrafo();
		System.out.println(grafo);
		System.out.println("DFS");
		System.out.println("# Recursivo");
		System.out.println(conectadosDFS(grafo, 0, 2));
		System.out.println(conectadosDFS(grafo, 0, 6));
		System.out.println("# Iterativo:");
		System.out.println(conectadosDFSiterativo(grafo, 0, 4));
		System.out.println("# BFS:");
		System.out.println(conectadosBFSiterativo(grafo, 0, 4));
		System.out.println(conectadosBFSiterativo(grafo, 0, 6));

	}
	
	/**
	 * Smoketest de Dijkstra sobre un grafo y un nodo dados.
	 * @param <Nodo>
	 * @param grafo
	 * @param origen
	 */
	public static <Nodo extends Comparable<? super Nodo>> void pruebaDijkstra(Grafo<Nodo> grafo, Nodo origen) {
		Map<Nodo, Arco<Nodo>> edgeTo = dijkstra(grafo, origen);
		System.out.println("# Dijkstra: desde " + origen + " (" + edgeTo.size() + " nodos alcanzables)");
		for(Nodo destino: grafo.V()) {
			Nodo actual = destino;
			System.out.print(actual);
			if(!edgeTo.containsKey(actual)) {
				System.out.println(" ¡No es alcanzable!");
				continue;
			}
			double total = 0;
			Arco<Nodo> arco = edgeTo.get(actual);
			while(arco != null) {
				Nodo otro = arco.otro(actual);
				total += arco.peso;
				System.out.print(" <-[" + arco.peso + "]- " + otro);
				actual = otro;
				arco = edgeTo.get(actual);
			}
			System.out.println(" Peso total: " + total);
		}
	}
	
	public static void main(String[] args) {
		Grafo<Integer> grafo = nuevoGrafo2();
		System.out.println("Grafo original (no conexo):");
		System.out.println(grafo);
		
		grafo = nuevoGrafo2();
		System.out.println("# Prim:");
		System.out.println(primNoConexo(grafo));
		pruebaDijkstra(grafo, 0);
		pruebaDijkstra(grafo, 7);
	}

}

/**
 * Clase auxiliar para guardar cada opción de camino en Dijkstra y ordenar las opciones
 * según el peso total.
 * 
 * Una opción es mejor que otra si su peso total es menor o igual.
 * @param <Nodo>
 */
class PunteroCamino<Nodo> implements Comparable<PunteroCamino<Nodo>>{
	Arco<Nodo> ultimo;
	Double pesoTotal;
	Nodo siguiente;
	public PunteroCamino(Arco<Nodo> ultimo, Double pesoTotal, Nodo siguiente) {
		this.ultimo = ultimo;
		this.pesoTotal = pesoTotal;
		this.siguiente = siguiente;
	}
	@Override
	public int compareTo(PunteroCamino<Nodo> o) {
		return Double.compare(this.pesoTotal, o.pesoTotal);
	}
}

