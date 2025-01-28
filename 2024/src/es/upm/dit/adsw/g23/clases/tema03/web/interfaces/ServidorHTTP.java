package es.upm.dit.adsw.g23.clases.tema03.web.interfaces;

import java.io.IOException;
import java.net.Socket;

public interface ServidorHTTP {
	public PeticionHTTP accept() throws IOException;
}
