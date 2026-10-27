package bai17_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 12345);
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(br.readLine());
		while(true) {
			String command = input.readLine();
			pw.println(command);
			String res = br.readLine();
			if(res == null) break;
			System.out.println(res);
		}
		System.out.println("SERVER CLOSE, BYE");
		socket.close();
	}
}
