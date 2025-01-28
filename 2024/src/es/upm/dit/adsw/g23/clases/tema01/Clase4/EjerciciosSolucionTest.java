package es.upm.dit.adsw.g23.clases.tema01.Clase4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EjerciciosSolucionTest {
	es.upm.dit.adsw.g23.clases.tema01.Clase3.Ejercicios solucion = new EjerciciosSolucion();
	
	@Test
	protected void testIncluyeOrdenados() {
		assert(solucion.incluyeOrdenadas(new Float[] {1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 5.0f));
		assert(!solucion.incluyeOrdenadas(new Float[] {1.0f, 2.0f, 3.0f, 4.0f, 5.0f}, 6f));
	}
}
