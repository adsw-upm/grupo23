package es.upm.dit.adsw.g23.clases.tema03.web;
import java.io.IOException;

import es.upm.dit.adsw.g23.clases.tema03.web.interfaces.PeticionHTTP;
import es.upm.dit.adsw.g23.clases.tema03.web.interfaces.ServidorHTTP;

public class Servidor01Secuencial {
	ServidorHTTP socket;
	int peticiones = 0;
	
	public Servidor01Secuencial(int puerto) throws IOException {
		this.socket = new ServidorReal(puerto);
	}
	
	public Servidor01Secuencial() throws IOException {
		this.socket = new ServidorSimulado();
	}
	
	public void servir() {
		while(true) {
			try {
				PeticionHTTP peticion = socket.accept();
				Thread.sleep(1000);
				peticion.responder("Hola, viajero número " + peticiones++);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
    public static void main(String[] args) throws Exception {
    	int puerto = 8080;
    	System.out.println("Servidor lanzado en el puerto " + puerto);
    	Servidor01Secuencial servidor = new Servidor01Secuencial(puerto);
    	servidor.servir();
    	System.out.println("El servidor ya no está activo.");
    }
}