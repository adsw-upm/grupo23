package es.upm.dit.adsw.tema04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Ejemplo de inversión de un diccionario utilizando un monitor.
 * 
 * El monitor gestionará las hebras para procesar el diccionario, además de los 
 * datos necesarios para guardar las partes del diccionario y los resultados parciales.
 */

public class SepararTareasConMonitor {

	static class Monitor {
		private List<Map<String, List<Integer>>> partes;
		private List<Map<Integer, List<String>>> resultados;
		private List<Thread> hebras;
		private boolean cerrado;

		/**
		 * Genera un monitor que gestionará 3 hebras.
		 */
		public Monitor() {
			this(3);
		}
		/**
		 * Clase que gestiona tres cosas:
		 * 1) Diccionarios a invertir (partes)
		 * 2) Resultados de invertir cada parte (resultados)
		 * 3) Hebras que se encargan de realizar el proceso de inversión.
		 */

		public Monitor(int nhebras) {
			this.partes = new ArrayList<>();
			this.resultados = new ArrayList<>();
			this.hebras = new ArrayList<>();
			this.cerrado = false;
			for (int i = 0; i < nhebras; i++) {
				this.hebras.add(new Procesador(this));
				this.hebras.get(i).start();
			}
		}

		/**
		 * Añade una parte para ser procesada.
		 * @return Parte a procesar, o null si el monitor ya se ha cerrado.
		 * @throws InterruptedException
		 */
		public Map<String, List<Integer>> getParte() throws InterruptedException {
			// Tenemos que asegurarnos de que no hay acceso concurrente a partes
			synchronized (partes) {
				while (partes.isEmpty()) {
					// Este método es sincronizado
					if (this.isCerrado()) {
						return null;
					}
					partes.wait();
				}
				Map<String, List<Integer>> parte = partes.remove(0);
				partes.notify();
				return parte;
			}
		}
		/**
		 * Añade el resultado de procesar una parte.
		 * @param resultado
		 */
		public void putResultado(Map<Integer, List<String>> resultado) {
			synchronized (resultados) {
				resultados.add(resultado);
				resultados.notify();
			}
		}
		/**
		 * Recoge el resultado de procesar una parte.
		 * Bloquea hasta que hay un resultado disponible.
		 */

		public Map<Integer, List<String>> getResultado() throws InterruptedException {
			synchronized (this.resultados) {
				while (this.resultados.isEmpty()) {
					this.resultados.wait();
				}
				this.resultados.notify();
				return this.resultados.remove(0);
			}
		}

		/**
		 * Añade una parte para procesar.
		 * Bloquea si el número de partes pendientes (no han sido recogidas para procesar aún) es mayor
		 * o igual al número de hebras disponibles.
		 * @param parte
		 * @throws InterruptedException
		 */
		public void putParte(Map<String, List<Integer>> parte) throws InterruptedException {
			synchronized (this.partes) {
				while (this.partes.size() >= this.hebras.size()) {
					this.partes.wait();
				}
				// Tenemos que notificar, porque podría haber hebras esperando partes nuevas
				this.partes.notify();
				this.partes.add(parte);
			}
		}

		synchronized boolean isCerrado() {
			return this.cerrado;
		}

		// No sincronizamos el método completo, porque las hebras necesitan acceder a
		// isCerrado, y aquí debemos bloquear hasta que acaben las hebras.
		public void cerrar() throws InterruptedException {
			synchronized(this) { 
				if(this.cerrado) {
					return;
				}
				this.cerrado = true;
			}
			// Tenemos que notificar a las hebras que están esperando que haya partes disponibles.
			// Si no lo hacemos, se quedarán esperando indefinidamente (no quedan productores que vayan a 
			// añadir partes).
			// Para poder notificar, tenemos que sincronizar primero con partes.
			synchronized(this.partes) {
				this.partes.notifyAll();
			}
			print("Cerrando hebras");
			for(Thread h: this.hebras) {
				h.join();
			}
		}
	}

	static class Procesador extends Thread {
		// Ya no tenemos parte y resultado.
		// Obtendremos la parte del monitor, y guardaremos el resultado en el monitor
		Monitor monitor;

		public Procesador(Monitor monitor) {
			this.monitor = monitor;
		}

		public void run() {
			print("comenzando");
			while (!this.monitor.isCerrado()) {
				try {
					print("recogiendo una parte");
					Map<String, List<Integer>> parte = this.monitor.getParte();
					print("recogida parte" + parte);
					if (parte == null) {
						break;
					}
					Map<Integer, List<String>> resultado = SepararTareasConMonitor.invertirDiccionario(parte);
					this.monitor.putResultado(resultado);
					print("resultado añadido");
				} catch (InterruptedException e) {
					break;
				}
			}
			print("acabada");
		}
	}
	
	/**
	 * Método para simplificar la salida por pantalla. Se añade siempre el identificador de la hebra.
	 * @param msg Mensaje a mostrar por consola.
	 */
	public static void print(String msg) {
		String id = Thread.currentThread().getName();
		System.out.println(String.format("%-10s", id) + ": " + msg);
	}

	public static List<Map<String, List<Integer>>> separar(Map<String, List<Integer>> entrada, int npartes) {

		int nElementos = entrada.size() / npartes;
		List<Map<String, List<Integer>>> salida = new ArrayList<>();

		Map<String, List<Integer>> parte = new HashMap<>();

		for (Entry<String, List<Integer>> fila : entrada.entrySet()) {
			if (parte.size() >= nElementos) {
				salida.add(parte);
				parte = new HashMap<>();
			}
			parte.put(fila.getKey(), fila.getValue());
		}

		if (!parte.isEmpty()) {
			salida.add(parte);
		}

		return salida;
	}

	public static Map<Integer, List<String>> invertirDiccionario(Map<String, List<Integer>> entrada) {
		Map<Integer, List<String>> salida = new HashMap<>();
		for (Entry<String, List<Integer>> e : entrada.entrySet()) {
			String clave = e.getKey();
			for (int valor : e.getValue()) {
				if (!salida.containsKey(valor)) {
					salida.put(valor, new ArrayList<>());
				}
				salida.get(valor).add(clave);
			}
		}
		return salida;
	}

	public static Map<Integer, List<String>> juntarResultados(List<Map<Integer, List<String>>> partes) {
		Map<Integer, List<String>> juntos = new HashMap<>();
		for (Map<Integer, List<String>> parte : partes) {
			for (Entry<Integer, List<String>> e : parte.entrySet()) {
				Integer clave = e.getKey();
				List<String> valores = e.getValue();
				if (!juntos.containsKey(clave)) {
					juntos.put(clave, new ArrayList<>());
				}
				for (String valor : valores) {
					juntos.get(clave).add(valor);
				}
			}

		}
		return juntos;
	}

	public static Map<Integer, List<String>> procesarSecuencial(Map<String, List<Integer>> ejemplo, int nPartes) {
		List<Map<String, List<Integer>>> partes = separar(ejemplo, nPartes);

		List<Map<Integer, List<String>>> resultados = new ArrayList<>();

		for (Map<String, List<Integer>> parte : partes) {
			resultados.add(invertirDiccionario(parte));
		}

		Map<Integer, List<String>> resultado = juntarResultados(resultados);

		return resultado;
	}

	/**
	 * Método que utiliza el monitor internamente para procesar el diccionario que se pase como argumento, que se 
	 * dividirá en tantas partes (o segmentos) como se especifique.
	 * 
	 * @param entrada Diccionario a invertir
	 * @param npartes Número de partes en las que se dividirá la entrada
	 * @return Diccionario invertido
	 * @throws InterruptedException
	 */
	public static Map<Integer, List<String>> procesarMonitor(Map<String, List<Integer>> entrada, int npartes)
			throws InterruptedException {
		
		Monitor m = new Monitor();
		List<Map<String, List<Integer>>> partes = separar(entrada, npartes);

		for (int i=0; i<partes.size(); i++) {
			Map<String, List<Integer>> parte = partes.get(i);
			try {
				print("Añadiendo parte " + i + "/" + partes.size());
				m.putParte(parte);
			} catch (InterruptedException e) {
				break;
			}
		}
		print("Añadidas todas las partes. Capturando resultados");

		List<Map<Integer, List<String>>> resultados = new ArrayList<>();
		for (int i = 0; i < npartes; i++) {
			resultados.add(m.getResultado());
		}
		print("Resultados capturados");

		m.cerrar();
		Map<Integer, List<String>> resultado = juntarResultados(resultados);
		print("Resultados integrados");

		return resultado;
	}

	public static void main(String[] args) throws InterruptedException {
		Map<String, List<Integer>> ejemplo = new HashMap<>();
		// Vamos a crear un ejemplo de diccionario que represente los votos que ha
		// recibido cada país en eurovisión
		// A partir del diccionario de ejemplo, podemos ver qué puntuaciones ha recibido
		// cada país.
		// Lo que queremos al final es un diccionario que nos diga qué países han
		// recibido cada puntuación.
		for (int i = 1; i < 11; i++) {
			List<Integer> numeros = new ArrayList<>();
			for (int j = 1; j <= i; j++) {
				numeros.add(j);
			}
			ejemplo.put("Pais_" + i, numeros);
		}

		Map<Integer, List<String>> resultado = procesarMonitor(ejemplo, 5);

		for (Entry<Integer, List<String>> e : resultado.entrySet()) {
			print("# Número de países que han recibido " + e.getKey() + " punto(s): " + e.getValue().size());
		}

	}

}
