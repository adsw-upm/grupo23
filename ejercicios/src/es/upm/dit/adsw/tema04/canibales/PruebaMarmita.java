package es.upm.dit.adsw.tema04.canibales;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;



class PruebaMarmita {

		/**
		 * Comprueba que el monitor funciona para un caso específico en que aparecen un cierto
		 * número de caníbales (mayor que la capacidad máxima) desde el principio y se pide 
		 * al cocinero rellenar varias veces.
		 * 
		 * 
		 * @param c
		 * @throws InterruptedException
		 * @throws InstantiationException
		 * @throws IllegalAccessException
		 * @throws IllegalArgumentException
		 * @throws InvocationTargetException
		 * @throws NoSuchMethodException
		 * @throws SecurityException
		 */
	  @DisplayName("Test with @MethodSource")
	  @ParameterizedTest(name = "Test for {index}: {0})")
	  @MethodSource("localParameters")
	  @Timeout(value = 10)
	  void test(Class<MarmitaInterface> c) throws InterruptedException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		System.out.println("Probando clase " + c.getName());
		int max = 2;
		int nRefills = 2;
		int nCanibales = max * nRefills - 1;
		
		// Probamos varias veces, porque puede que algunos casos no den problemas
		for(int a=0; a<10; a++) {
			MarmitaInterface m = (MarmitaInterface) c.getDeclaredConstructor(int.class).newInstance(max);
			List<Thread> hebras = new ArrayList<>();
			for(int i=0; i< nCanibales; i++) {
				int j = i;
				// Creamos caníbales "simplificados"
				Thread t = new Thread() {
					public void run() {
						try {
							m.comer(j);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				};
				t.start();
				hebras.add(t);
			}
			// Dejamos tiempo para que los caníbales lleguen a esperar
			Thread.sleep(50);
			for(int i=0; i< nRefills; i++) {
				m.rellenar();
			}
			System.out.println("Acabado");
			for(Thread t: hebras) {
				t.join();
			}
		}
	  }
	  
	  static Stream<Arguments> localParameters() {
		    return Stream.of(
		        Arguments.of(MarmitaEnOrden.class),
		        Arguments.of(MarmitaSolucionOficial.class),
		        Arguments.of(MarmitaTodosEsperan.class),
		        Arguments.of(MarmitaTodosEsperan2.class)
		    );
		  }

}
