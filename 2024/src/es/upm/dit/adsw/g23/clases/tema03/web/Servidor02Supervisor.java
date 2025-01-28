package es.upm.dit.adsw.g23.clases.tema03.web;
import java.io.IOException;

import es.upm.dit.adsw.g23.clases.tema03.web.interfaces.PeticionHTTP;
import es.upm.dit.adsw.g23.clases.tema03.web.interfaces.ServidorHTTP;

public class Servidor02Supervisor extends Thread {
	ServidorHTTP servidor;
	int peticiones = 0;
	
	public Servidor02Supervisor(int puerto) throws IOException {
		this.servidor = new ServidorReal(puerto);
	}
	
	public void run() {
		while(true) {
			try {
				PeticionHTTP peticion = servidor.accept();
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
    	Servidor02Supervisor servidor = new Servidor02Supervisor(puerto);
    	
    	Thread supervisor = new Thread() {
    		public void run() {
    			while(true) {
    				System.out.println("El servidor sigue funcionando");
    				try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.out.println("El servidor se ha parado");
						break;
					}
    			}
    		}
    	};
    	supervisor.start();
    	servidor.start();
    	servidor.join();
    	supervisor.interrupt();
    	supervisor.join();
    }
}