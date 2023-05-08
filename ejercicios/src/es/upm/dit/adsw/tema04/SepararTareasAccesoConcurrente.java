package es.upm.dit.adsw.tema04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Evolución del ejemplo de inversión de un diccionario utilizando concurrencia.
 * 
 * En este caso, en lugar de crear sub-resultados en cada hebra, las hebras tienen acceso al
 * resultado global.
 */

public class SepararTareasAccesoConcurrente {
	
	static class MisDatos {
		int contador = 0;
		
		synchronized void actualizar() {
			
		}
	}
	
	static class Procesador extends Thread {
		Map<String, List<Integer>> parte;
		
		// Este resultado es compartido entre todas las hebras
		Map<Integer, List<String>> resultado;
		
		// Hemos añadido un argumento nuevo al constructor, para tener acceso al resultado
		public Procesador(Map<String, List<Integer>> parte, Map<Integer, List<String>> resultado) {
			this.parte = parte;
			this.resultado = resultado;
		}

		public void run() {
			for(Entry<String, List<Integer>> e: parte.entrySet()) {
				synchronized(resultado) {
					String clave = e.getKey();
					for(int valor: e.getValue()) {
						if(resultado.containsKey(valor)) {
							List<String> lista_paises = resultado.get(valor);
							lista_paises.add(clave);
	
						} else {
							resultado.put(valor, new ArrayList<>());
						}
					}
				}
			}
		}
	}
	
	public static List<Map<String, List<Integer>>> separar(Map<String, 
			                                     List<Integer>> entrada, int npartes) {
		
		int nElementos = entrada.size() / npartes;
		List<Map<String, List<Integer>>> salida = new ArrayList<>();
		
		Map<String, List<Integer>> parte = new HashMap<>();
		
		for(Entry<String, List<Integer>> fila: entrada.entrySet()) {
			if(parte.size() >= nElementos) {
				salida.add(parte);
				parte = new HashMap<>();
			}
			parte.put(fila.getKey(), fila.getValue());
		}
		
		if(!parte.isEmpty()) {
			salida.add(parte);
		}
		
		return salida;
	}
	
	public static Map<Integer, List<String>> procesarConcurrente(Map<String, List<Integer>> ejemplo, int npartes)  {
		List<Map<String, List<Integer>>> partes = separar(ejemplo, npartes);
		
		Map<Integer, List<String>> resultado = new HashMap<>();

		List<Procesador> tareas = new ArrayList<>();

		for(Map<String, List<Integer>> parte: partes) {
			Procesador p = new Procesador(parte, resultado);
			p.start();
			tareas.add(p);
		}
		// Esta parte es MUY importante. 
		// Si no esperamos al resultado, las hebras podrían no haber terminado de procesar antes de recoger los resultados.
		for(Thread t: tareas) {
			t.join();
		}
		
		return resultado;
	}
	

	public static void main(String[] args) throws InterruptedException {
		Map<String, List<Integer>> ejemplo = new HashMap<>();
		// Vamos a crear un ejemplo de diccionario que represente los votos que ha recibido cada país en eurovisión
		// A partir del diccionario de ejemplo, podemos ver qué puntuaciones ha recibido cada país.
		// Lo que queremos al final es un diccionario que nos diga qué países han recibido cada puntuación.
		for(int i=1; i<=10; i++) {
			List<Integer> numeros = new ArrayList<>();
			for(int j=1; j<=i; j++) {
				numeros.add(j);
			}
			ejemplo.put("Pais_" + i, numeros);
		}
		
		Map<Integer, List<String>> resultado = procesarConcurrente(ejemplo, 5);
		
		
		System.out.println(resultado.size());
		for(Entry<Integer, List<String>> e: resultado.entrySet()) {
			System.out.println("# Número de países que han recibido " + e.getKey() + " punto(s): " + e.getValue().size());
		}
		
	}
	
	
	MisDatos datos = new MisDatos();
//	synchronized(datos) {
	datos.actualizar();
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
