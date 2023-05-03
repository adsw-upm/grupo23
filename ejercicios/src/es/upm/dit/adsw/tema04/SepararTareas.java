package es.upm.dit.adsw.tema04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Ejemplo de inversión de un diccionario utilizando concurrencia.
 * 
 *
 */

public class SepararTareas {
	
	static class Procesador extends Thread {
		Map<String, List<Integer>> trozo;
		Map<Integer, List<String>> resultado;
		public Procesador(Map<String, List<Integer>> trozo) {
			this.trozo = trozo;
		}
		
		public void run() {
			this.resultado = SepararTareas.invertirDiccionario(this.trozo);
		}
	}
	
	public static List<Map<String, List<Integer>>> separar(Map<String, 
			                                     List<Integer>> entrada, int nTrozos) {
		
		int nElementos = entrada.size() / nTrozos;
		List<Map<String, List<Integer>>> salida = new ArrayList<>();
		
		Map<String, List<Integer>> trozo = new HashMap<>();
		
		for(Entry<String, List<Integer>> fila: entrada.entrySet()) {
			if(trozo.size() >= nElementos) {
				salida.add(trozo);
				trozo = new HashMap<>();
			}
			trozo.put(fila.getKey(), fila.getValue());
		}
		
		if(!trozo.isEmpty()) {
			salida.add(trozo);
		}
		
		return salida;
	}
	
	public static Map<Integer, List<String>> invertirDiccionario(Map<String, List<Integer>> entrada) {
		Map<Integer, List<String>> salida = new HashMap<>();
		for(Entry<String, List<Integer>> e: entrada.entrySet()) {
			String clave = e.getKey();
			for(int valor: e.getValue()) {
				if(!salida.containsKey(valor)) {
					salida.put(valor, new ArrayList<>());
				}
				salida.get(valor).add(clave);
			}
		}
		return salida;
	}
	
	public static Map<Integer, List<String>> juntarResultados(List<Map<Integer, List<String>>> trozos) {
		Map<Integer, List<String>> juntos = new HashMap<>();
		for(Map<Integer, List<String>> trozo: trozos) {
			for(Entry<Integer, List<String>> e: trozo.entrySet()) {
			   Integer clave = e.getKey();
			   List<String> valores = e.getValue();
			   if(!juntos.containsKey(clave) ) {
				   juntos.put(clave, new ArrayList<>());
			   }
			   for(String valor: valores) {
				   juntos.get(clave).add(valor);
			   }
			}
			
		}
		return juntos;
	}
	
	public static List<Map<Integer, List<String>>> recogerResultados(List<Procesador> hebras) {
		List<Map<Integer, List<String>>> resultados = new ArrayList<>();
		for(Procesador t: hebras) {
			resultados.add(t.resultado);
		}
		return resultados;
	}
	
	public static Map<Integer, List<String>> procesarSecuencial(Map<String, List<Integer>> ejemplo, int nPartes) throws InterruptedException {
		List<Map<String, List<Integer>>> partes = separar(ejemplo, nPartes);

		List<Map<Integer, List<String>>> resultados = new ArrayList<>();

		for(Map<String, List<Integer>> parte: partes) {
			resultados.add(invertirDiccionario(parte));
		}
		
		Map<Integer, List<String>> resultado = juntarResultados(resultados);

		return resultado;
	}
	
	public static Map<Integer, List<String>> procesarConcurrente(Map<String, List<Integer>> ejemplo, int nTrozos) throws InterruptedException {
		List<Map<String, List<Integer>>> trozos = separar(ejemplo, nTrozos);

		List<Procesador> tareas = new ArrayList<>();
		for(Map<String, List<Integer>> trozo: trozos) {
			Procesador p = new Procesador(trozo);
			p.start();
			tareas.add(p);
		}
		// Esta parte es MUY importante. 
		// Si no esperamos al resultado, las hebras podrían no haber terminado de procesar antes de recoger los resultados.
		for(Thread t: tareas) {
			t.join();
		}
		List<Map<Integer, List<String>>> resultados = recogerResultados(tareas);
		
		Map<Integer, List<String>> resultado = juntarResultados(resultados);

		return resultado;
	}
	

	public static void main(String[] args) throws InterruptedException {
		Map<String, List<Integer>> ejemplo = new HashMap<>();
		// Vamos a crear un ejemplo de diccionario que represente los votos que ha recibido cada país en eurovisión
		// A partir del diccionario de ejemplo, podemos ver qué puntuaciones ha recibido cada país.
		// Lo que queremos al final es un diccionario que nos diga qué países han recibido cada puntuación.
		for(int i=1; i<11; i++) {
			List<Integer> numeros = new ArrayList<>();
			for(int j=1; j<=i; j++) {
				numeros.add(j);
			}
			ejemplo.put("Pais_" + i, numeros);
		}
		
		// Paso 1: Empezamos procesando el diccionario entero
		Map<Integer, List<String>> resultado = invertirDiccionario(ejemplo);
		// Paso 2: Modificamos el código para que procese en partes por separado, pero de forma secuencial
//		Map<Integer, List<String>> resultado = procesarSecuencial(ejemplo, 5);
		// Paso 3: Partiendo del código para procesar secuencial, añadimos hebras para procesar de forma concurrente
//		Map<Integer, List<String>> resultado = procesarConcurrente(ejemplo, 5);
		
		
		System.out.println(resultado.size());
		for(Entry<Integer, List<String>> e: resultado.entrySet()) {
			System.out.println("# Número de países que han recibido " + e.getKey() + " punto(s): " + e.getValue().size());
		}
		
	}

}
