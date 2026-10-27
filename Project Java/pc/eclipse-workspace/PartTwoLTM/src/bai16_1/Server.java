package bai16_1;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(2000);
		while(true) {
			new ServerThread(serverSocket.accept()).start();
		}
	}
}
