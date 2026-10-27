package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;

public class Server {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		ServerSocket serverSocket = new ServerSocket(7000);
		while (true) {
			new ServerThread(serverSocket.accept()).start();
		}
	}
}
