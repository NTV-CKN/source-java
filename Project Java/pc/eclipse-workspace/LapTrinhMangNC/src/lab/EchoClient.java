package lab;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
	public static void main(String[] args) {
		try {
			System.out.println("Client: ");
			Socket clientSoc = new Socket("localhost", 7);
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter your string: ");
			BufferedReader brRes = new BufferedReader(new InputStreamReader(clientSoc.getInputStream()));
			PrintWriter pw = new PrintWriter(clientSoc.getOutputStream(), true);
		
			while(true) {
				String input = br.readLine();	
				if(input.equalsIgnoreCase("exit")) break;
				pw.println(input);
				System.out.println(brRes.readLine());
			}
			br.close();
			brRes.close();
			pw.close();
			clientSoc.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
