package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.StringTokenizer;

import bai18_rmi.CRUDStudentInterface;
import bai18_rmi.LoginInterface;
import bai18_rmi.Student;

public class Client {
	private static boolean isLogin = false;
	private static String username = null;
	private static CRUDStudentInterface crud;
	private static LoginInterface login;
	private static String command, param;

	public static void main(String[] args) throws NotBoundException, IOException {
		Registry regis = LocateRegistry.getRegistry(12345);
		login = (LoginInterface) regis.lookup("login");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("welcome");
		while (true) {
			String cmd = br.readLine();
			if (cmd.equalsIgnoreCase("exit"))
				break;
			processCmd(cmd);
			System.out.println(performCmd());;
		}
		System.out.println("BYE");
		if (crud != null)
			crud.closeDao();
		br.close();
	}

	private static String performCmd() throws RemoteException {
		if (isLogin) {
			switch (command) {
			case "findbyname": {
				List<Student> sts = crud.findByName(param);
				if (sts.isEmpty())
					return "KHONG TIM THAY SV";
				String res = "";
				for (Student st : sts) {
					res += st.toString() + "\n";
				}
				return res;
			}
			case "findbyid": {
				Student st = crud.findById(Integer.parseInt(param.trim()));
				if (st == null)
					return "KHONG TIM THAY SV";
				return st.toString();
			}
			case "update": {
				StringTokenizer st = new StringTokenizer(param, "\t");
				int id = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				double grade = Double.parseDouble(st.nextToken());
				boolean isSuccess = crud.updateStudent(id, name, grade);
				return isSuccess ? "UPDATE OK" : "UPDATE FAILED";
			}
			case "add": {
				StringTokenizer st = new StringTokenizer(param, "\t");
				int id = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				double grade = Double.parseDouble(st.nextToken());
				boolean isSuccess = crud.addStudent(id, name, grade);
				return isSuccess ? "ADD OK" : "ADD FAILED";
			}
			case "delete": {
				int id = Integer.parseInt(param);

				boolean isSuccess = crud.deleteStudent(id);
				return isSuccess ? "DEL OK" : "DEL FAILED";
			}
			default:
				return "KHONG TIM THAY LENH";
			}
		} else {
			switch (command) {
			case "user": {
				boolean isValid = login.checkUsername(param);
				if (isValid) {
					username = param;
					return "USERNAME OK";
				}
				return "USERNAME ERROR";
			}
			case "pass": {
				if (username == null)
					return "VUI LONG NHAP USERNAME TRUOC";
				crud = login.login(username, param);
				if (crud != null) {
					isLogin = true;
					return "LOGIN OK";
				}
				return "LOGIN ERROR";
			}
			default:
				return "KHONG TIM THAY LENH VA HAY DANG NHAP";
			}
		}
	}

	private static void processCmd(String cmd) {
		StringTokenizer st = new StringTokenizer(cmd, " ");
		command = st.nextToken().toLowerCase();
		param = cmd.substring(command.length(), cmd.length()).stripLeading();
	}
}
