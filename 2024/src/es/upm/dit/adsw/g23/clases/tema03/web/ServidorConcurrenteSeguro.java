package es.upm.dit.adsw.g23.clases.tema03.web;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import es.upm.dit.adsw.g23.clases.tema03.web.interfaces.PeticionHTTP;
import es.upm.dit.adsw.g23.clases.tema03.web.interfaces.ServidorHTTP;

public class ServidorConcurrenteSeguro extends Thread {
	ServidorHTTP servidor;
	int peticiones = 0;
	
	public ServidorConcurrenteSeguro(int puerto) throws IOException {
		this.servidor = new ServidorReal(puerto);
	}
	
	public synchronized int aumentarContador() throws InterruptedException {
		int servidas = peticiones;
		Thread.sleep(10);
		peticiones = servidas + 1;
		return peticiones;
	}
	
	public void run() {
		while(true) {
				PeticionHTTP peticion;
				try {
					peticion = servidor.accept();
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}
				new Thread() {
					public void run() {
						try {
							Thread.sleep(1000);
							peticion.responder("Hola, viajero número " + aumentarContador());
						} catch (IOException | InterruptedException e) {
							e.printStackTrace();
						}
					}
				}.start();
		}
	}
	
    public static void main(String[] args) throws Exception {
    	int puerto = 8080;
    	System.out.println("Servidor lanzado en el puerto " + puerto);
    	ServidorConcurrenteSeguro servidor = new ServidorConcurrenteSeguro(puerto);
    	
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