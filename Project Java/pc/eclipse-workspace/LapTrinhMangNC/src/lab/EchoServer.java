package lab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	public static void main(String[] args) throws IOException {
		System.out.println("Server waiting client request connect");
		ServerSocket serverSocket = new ServerSocket(7);
		int clientCount = 0;

		while (true) {
			clientCount++;
			Socket socket = serverSocket.accept();
			System.out.println("Completed client request connect: " + clientCount + socket.getPort() + " local "
					+ socket.getLocalPort());
			Thread t = new Thread(() -> {
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
					BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

					while (true) {
						String res = br.readLine();
						if(res == null) break;
						bw.write("ECHO: " + res);
						bw.newLine();
						bw.flush();
					}
					
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			t.start();
		}
	}
}
