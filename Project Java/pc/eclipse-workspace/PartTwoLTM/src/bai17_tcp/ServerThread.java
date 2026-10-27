package bai17_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class ServerThread extends Thread {
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;
	private String operator, param1, param2;

	public ServerThread(Socket socket) throws IOException {
		this.socket = socket;
		pw = new PrintWriter(this.socket.getOutputStream(), true);
		br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
	}

	@Override
	public void run() {
		super.run();
		try {
			pw.println("Welcome, plz input");
			while (true) {
				String cmd = br.readLine();
				if (cmd.equalsIgnoreCase("exit"))
					break;
				processCmd(cmd);
				String res = performCmd();
				pw.println(res);
			}
			socket.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String performCmd() {
		Double p1 = Double.parseDouble(param1);
		Double p2 = Double.parseDouble(param2);
		switch (operator) {
		case "+": {
			return param1 + operator + param2 + " = " + (p1 + p2);
		}
		case "-": {
			return param1 + operator + param2 + " = " + (p1 - p2);
		}
		case "*": {
			return param1 + operator + param2 + " = " + (p1 * p2);
		}
		case "/": {
			return param1 + operator + param2 + " = " + (p1 / p2);
		}
		default:
			return "NOT FOUND THE OPERATOR: " + operator;
		}
	}

	private void processCmd(String cmd) {
		StringTokenizer st = new StringTokenizer(cmd, "+-*/");
		param1 = st.nextToken();
		param2 = st.nextToken();
		operator = cmd.substring(param1.length(), cmd.length() - param2.length());
	}
}
