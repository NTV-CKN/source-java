package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.Socket;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 1080);
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(br.readLine());
		while (true) {
			String cmd = input.readLine();
			pw.println(cmd);
			if (cmd.toLowerCase().startsWith("name\t") || cmd.toLowerCase().startsWith("price\t")) {
				String res;
				while (!(res = br.readLine()).equalsIgnoreCase("THE END")) {
					System.out.println(res);
				}
				continue;
			}
			String res = br.readLine();
			System.out.println(res);
			if (cmd.equalsIgnoreCase("quit") || cmd.equalsIgnoreCase("exit"))
				if (res.equalsIgnoreCase("BYE"))
					break;
		}
		socket.close();
	}
}
