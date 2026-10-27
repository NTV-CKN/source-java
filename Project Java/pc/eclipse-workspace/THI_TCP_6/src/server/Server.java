package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.sql.SQLException;

public class Server {
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		ServerSocket serverSocket = new ServerSocket(1080);
		while (true)
			new ServerThread(serverSocket.accept()).start();
	}
}
