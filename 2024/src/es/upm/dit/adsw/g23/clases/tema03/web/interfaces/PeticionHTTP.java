package es.upm.dit.adsw.g23.clases.tema03.web.interfaces;

import java.io.IOException;

public interface PeticionHTTP {
    public void responder(String content, String status, String contentType) throws IOException;
    public void responder(String respuesta) throws IOException;
}
