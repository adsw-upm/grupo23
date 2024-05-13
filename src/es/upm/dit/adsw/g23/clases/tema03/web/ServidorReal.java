package es.upm.dit.adsw.g23.clases.tema03.web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import es.upm.dit.adsw.g23.clases.tema03.web.interfaces.PeticionHTTP;
import es.upm.dit.adsw.g23.clases.tema03.web.interfaces.ServidorHTTP;

public class ServidorReal implements ServidorHTTP {
	ServerSocket servidor;
	
	public ServidorReal(int puerto) throws IOException {
		this.servidor = new ServerSocket(puerto);
	}
	
	@Override
	public PeticionHTTP accept() throws IOException {
		// TODO Auto-generated method stub
		return new PeticionReal(this.servidor.accept());
	}

}
