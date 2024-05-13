package es.upm.dit.adsw.g23.clases.tema03.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import es.upm.dit.adsw.g23.clases.tema03.web.interfaces.PeticionHTTP;

public class PeticionHTTPSimulada implements PeticionHTTP {
	public String path;
	public String method;
	public String version;
	public String host;
	public Socket cliente;
	
	public PeticionHTTPSimulada(Socket cliente) throws IOException {
		this.cliente = cliente;
        BufferedReader br = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        List<String> requestLines = new ArrayList<String>();
        String line;
        while (!(line = br.readLine()).isBlank()) {
            requestLines.add(line);
        }
        String[] first = requestLines.get(0).split(" ");
        method = first[0];
        path = first[1];
        version = first[2];
        host = requestLines.get(1).split(" ")[1];

        List<String> headers = new ArrayList<>();
        for (int h = 2; h < requestLines.size(); h++) {
            String header = requestLines.get(h);
            headers.add(header);
        }
//        String accessLog = String.format("Client %s, method %s, path %s, version %s, host %s, headers %s",
//                cliente.toString(), method, path, version, host, headers.toString());
//        System.out.println(accessLog);
	}

    public void responder(String respuesta) throws IOException {
        responder(respuesta, "200 OK", "text/plain");
    }
    
    public void responder(String content, String status, String contentType) throws IOException {
        OutputStream clientOutput = cliente.getOutputStream();
//        System.out.println("Status: " + status);
        clientOutput.write(("HTTP/1.1 " + status + "\r\n").getBytes());
        clientOutput.write(("Content-Type: " + contentType + "; charset=utf-8\r\n").getBytes());
        clientOutput.write("\r\n".getBytes());
        clientOutput.write(content.getBytes());
        clientOutput.write("\r\n\r\n".getBytes());
        clientOutput.flush();
        clientOutput.close();
        cliente.close();
    }
    
}
