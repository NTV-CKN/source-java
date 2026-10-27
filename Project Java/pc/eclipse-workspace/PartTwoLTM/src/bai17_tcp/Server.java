package bai17_tcp;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(12345);
		while(true) {
			new ServerThread(serverSocket.accept()).start();
		}
	}
}
