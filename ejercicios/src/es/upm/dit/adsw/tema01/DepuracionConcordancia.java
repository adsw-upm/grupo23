package es.upm.dit.adsw.tema01;

/**
 * Ejercicio para practicar depuración.
 * 
 * 
 * Prueba (sin añadir código) a:
 * - Visualizar el resultado de dar la vuelta a cada cadena de texto
 * - Encontrar casos en los que falla
 *
 */
public class DepuracionConcordancia {
	
	private String objetivo;
	
	public DepuracionConcordancia(String objetivo) {
		this.objetivo = objetivo;
	}
	
	/**
	 * Comprueba si una cadena dada concuerda con la cadena objetivo al leerla del revés.
	 * @param cadena de texto a comprobar
	 * @return true si hay coincidencia
	 */
	
	public boolean concuerda(String cadena) {
		String reves = "";
		for (int i=0; i<cadena.length(); i++) {
			reves = cadena.charAt(i) + reves;
		}
		return reves == this.objetivo;
	}
	
	/**
	 * Código de ejemplo para probar la clase. 
	 */
		
	public static void main(String[] args) {
		DepuracionConcordancia arroz = new DepuracionConcordancia("arroz");
		String[] palabras = {"abad", "camino", "carrera", "zorra", "dábale"};
		for(String i: palabras) {
			if(arroz.concuerda(i)) {
				System.out.println("Encontrado");
				return;
			}
		}
		System.out.println("No encontrado");
	}

}