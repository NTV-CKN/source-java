package rmi_17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.StringTokenizer;

import bai17_rmi.CalculatorInterface;

public class Client {
	private static String operator, param1, param2;

	public static void main(String[] args) throws NotBoundException, IOException {
		Registry regis = LocateRegistry.getRegistry(12345);
		CalculatorInterface calculator = (CalculatorInterface) regis.lookup("calculator");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("WELCOME");
		while (true) {
			String cmd = br.readLine();
			if(cmd.equalsIgnoreCase("exit"))break;
			processCmd(cmd);
			String res = performCmd(calculator);
			System.out.println(res);
		}
	}

	private static void processCmd(String cmd) {
		StringTokenizer st = new StringTokenizer(cmd, "+-*/");
 		param1 = st.nextToken();
		param2 = st.nextToken();
		operator = cmd.substring(param1.length(), cmd.length() - param2.length());
	}

	private static String performCmd(CalculatorInterface cal) {
		double p1 = Double.parseDouble(param1.trim());
		double p2 = Double.parseDouble(param2.trim());
		switch (operator) {
		case "+": {
			try {
				return param1 + operator + param2 + " = " + (cal.plus(p1, p2));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		case "-": {
			try {
				return param1 + operator + param2 + " = " + (cal.minus(p1, p2));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		case "*": {
			try {
				return param1 + operator + param2 + " = " + (cal.multiply(p1, p2));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		case "/": {
			try {
				return param1 + operator + param2 + " = " + (cal.divide(p1, p2));
			} catch (RemoteException e) {
				return e.getMessage();
			}
		}
		default:
			return "COMMAND NOT FOUND";
		}
	}
}
