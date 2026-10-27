import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Client {
	private String command, param;
	private boolean isLogin = false;
	private String username = null;
	private Registry regis;
	private IFactory factory;
	private ISearch search;

	public Client() throws RemoteException, NotBoundException {
		Registry regis = LocateRegistry.getRegistry("localhost", 54321);
		factory = (IFactory) regis.lookup("factory");
	}

	public void run() throws IOException {

		PrintWriter output = new PrintWriter(System.out, true);
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		output.println("Hello client");
		while (true) {
			System.out.println("Enter command:");
			String cmd = input.readLine();
			if (cmd.toLowerCase().startsWith("quit"))
				break;
			processCmd(cmd);
			String res = performCommand();
			System.out.println(res);
		}

		output.close();
		input.close();
	}

	private String performCommand() throws RemoteException {
		if (isLogin) {
			switch (command) {
			case "findbyid": {
				return search.getStById(Integer.parseInt(param)).toString();
			}
			case "findbyname": {
				List<Student> lst = search.getStByName(param);
				StringBuilder strB = new StringBuilder();
				for(Student st: lst) {
					strB.append(st.toString());
					strB.append("\n");
				}
				return strB.toString();
			}
			default:
				return "Lenh Khong Hop Le";
			}
		}
		if (!isLogin) {
			switch (command) {
			case "username": {
				username = param;
				return "OK Username";
			}
			case "password": {
				if(username == null) return "vui long nhap username";
				search = factory.login(username, param);
				if (search == null)
					return "Dang nhap that bai";
				isLogin = true;
				return "Dang nhap thanh cong";
			}
			default:
				return "Lenh Khong Hop Le  hoac chua dang nhap";
			}
		}
		return "Khong biet loi";
	}

	private void processCmd(String cmd) {
		StringTokenizer st = new StringTokenizer(cmd, " ");
		command = st.nextToken().toLowerCase();
		param = cmd.substring(command.length(), cmd.length()).trim();
	}
	public static void main(String[] args) throws NotBoundException, IOException {
		Client client = new Client();
		client.run();
	}
}
