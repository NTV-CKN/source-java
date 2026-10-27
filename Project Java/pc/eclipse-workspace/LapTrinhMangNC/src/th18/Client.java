package th18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 54321);
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		System.out.println(br.readLine());
		boolean isContinue = true;
		while(isContinue) {
			String cmd = sc.nextLine();
			pw.println(cmd);
			System.out.println(br.readLine());
			isContinue = Boolean.parseBoolean(br.readLine());
		}
	}
}
