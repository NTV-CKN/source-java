package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import server.ILogin;
import server.IProductManager;
import server.MyException;
import server.Product;

public class Client {
	private ILogin login;
	private IProductManager manager;
	private boolean isContinue = true, isLogin = false;
	private String username = null, command, param;

	public Client() throws AccessException, RemoteException, NotBoundException {
		Registry regis = LocateRegistry.getRegistry(6969);
		login = (ILogin) regis.lookup("login");
	}

	public void process() {
		System.out.println("WELCOME TO MY MANAGE PRODUCT");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while (isContinue) {
				String cmd = br.readLine();

				try {
					processCmd(cmd);
				} catch (MyException e) {
					System.out.println(e.getMessage());
					continue;
				}
				try {
					String res =performCmd();
					System.out.println(res);
				} catch (MyException e) {
					System.out.println(e.getMessage());
				}
			}
			login.close();
			if (manager != null)
				manager.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private String performCmd() throws MyException {
		// TODO Auto-generated method stub
		if (isLogin) {
			switch (command.toLowerCase()) {
			case "view": {
				try {
					List<Product> res = manager.view(param);
					for (Product prod : res)
						System.out.println(prod.toString());
					return "";
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return e.getMessage();
				}
			}
			case "add": {
				StringTokenizer st = new StringTokenizer(param, "\t");
				try {
					int idsp;
					int count;
					double price;
					try {
						idsp = Integer.parseInt(st.nextToken());
					} catch (NumberFormatException e) {
						// TODO: handle exception
						throw new MyException("Ma sp phai la 1 con so");
					}
					String name = st.nextToken();
					try {
						count = Integer.parseInt(st.nextToken());
					} catch (NumberFormatException e) {
						// TODO: handle exception
						throw new MyException("So luong sanpham phai la 1 con so");
					}
					try {
						price = Double.parseDouble(st.nextToken());
					} catch (NumberFormatException e) {
						// TODO: handle exception
						throw new MyException("Gia cua san pham phai la con so");
					}
					try {
						return manager.add(new Product(idsp, name, count, price)) ? "OK" : "ERROR";
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return "ERROR";
					}
				} catch (NoSuchElementException e) {
					// TODO: handle exception
					throw new MyException("Vui long nhap du cac truong yeu cau");
				}
			}
			case "edit": {
				StringTokenizer st = new StringTokenizer(param, "\t");
				try {
					int idsp;
					int count;
					double price;
					try {
						idsp = Integer.parseInt(st.nextToken());
					} catch (NumberFormatException e) {
						// TODO: handle exception
						throw new MyException("Ma sp phai la 1 con so");
					}
					String name = st.nextToken();
					try {
						count = Integer.parseInt(st.nextToken());
					} catch (NumberFormatException e) {
						// TODO: handle exception
						throw new MyException("So luong sanpham phai la 1 con so");
					}
					try {
						price = Double.parseDouble(st.nextToken());
					} catch (NumberFormatException e) {
						// TODO: handle exception
						throw new MyException("Gia cua san pham phai la con so");
					}
					try {
						return manager.edit(new Product(idsp, name, count, price)) ? "OK" : "UPDATE FAILED";
					} catch (RemoteException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return "ERROR";
					}
				} catch (NoSuchElementException e) {
					// TODO: handle exception
					throw new MyException("Vui long nhap du cac truong yeu cau");
				}
			}
			case "remove": {
				List<Integer> ids = new ArrayList<Integer>();
				StringTokenizer st = new StringTokenizer(param, "\t");

				try {
					while (st.hasMoreTokens()) {
						ids.add(Integer.parseInt(st.nextToken()));
					}
				} catch (NumberFormatException e) {
					// TODO: handle exception
					throw new MyException("Ma sp phai la 1 con so");
				}
				try {
					return "ROWS EFFECT: " + manager.remove(ids);
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "ERROR";
				}}
				case "quit": {
					isContinue = false;
					return "BYE";
				}
			default:
				return "COMMAND NOT FOUND";
			}
		} else {
			switch (command.toLowerCase()) {
			case "user": {
				username = param;
				try {
					boolean isValid = login.checkUsername(username);
					return isValid ? "OK" : "FALSE";
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "FALSE";
				}
			}
			case "pass": {
				if (username == null)
					return "Enter username before";
				try {
					manager = login.login(username, param);
					if (manager != null)
						isLogin = true;
					return manager != null ? "OK" : "FALSE";
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return "FALSE";
				}

			}
			case "exit": {
				isContinue = false;
				return "BYE";
			}
			default:
				return "PLS LOGIN";
			}
		}

	}

	private void processCmd(String cmd) throws MyException {
		StringTokenizer st = new StringTokenizer(cmd, "\t");
		try {
			command = st.nextToken();
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			throw new MyException("Vui long nhap lenh");
		}
		param = cmd.substring(command.length(), cmd.length()).trim();
	}

	public static void main(String[] args) throws AccessException, RemoteException, NotBoundException {
		new Client().process();
	}
}
