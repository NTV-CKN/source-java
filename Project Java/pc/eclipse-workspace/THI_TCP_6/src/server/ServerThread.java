package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ServerThread extends Thread {
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;
	private boolean isLogin = false;
	private String username = null;
	private UserDao userDao;
	private ProductDao productDao;

	public ServerThread(Socket socket) throws IOException, ClassNotFoundException, SQLException {
		this.socket = socket;
		userDao = new UserDao();
		productDao = new ProductDao();
		pw = new PrintWriter(socket.getOutputStream(), true);
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			pw.println("Welcome to Product Management System");
			process();
			pw.println("BYE");
			socket.close();
			userDao.close();
			productDao.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void process() throws IOException {
		while (!isLogin) {
			String cmd = br.readLine();
			try {
				if (cmd.equalsIgnoreCase("exit"))
					break;
				StringTokenizer st = new StringTokenizer(cmd, "\t");
				String command = st.nextToken();
				String param = cmd.substring(command.length(), cmd.length()).stripLeading();

				switch (command.toLowerCase()) {
				case "user": {
					username = param;
					pw.println(userDao.checkUsername(username) ? "OK" : "FALSE");
					break;
				}
				case "pass": {
					if (username == null)
						pw.println("Please enter username before");
					else {
						boolean isLogin = userDao.login(username, param);
						if (isLogin)
							this.isLogin = isLogin;
						pw.println(isLogin ? "OK" : "FALSE");
					}
					break;
				}
				default:
					pw.println("pls login");
				}
			} catch (Exception e) {
				e.printStackTrace();
				pw.println("ERROR");
				if (cmd != null && (cmd.toLowerCase().startsWith("price\t") || cmd.toLowerCase().startsWith("name\t")))
					pw.println("THE END");
			}
		}

		while (isLogin) {
			String cmd = br.readLine();
			try {
				if (cmd.equalsIgnoreCase("quit"))
					break;
				StringTokenizer st = new StringTokenizer(cmd, "\t");
				String command = st.nextToken();
				List<String> params = new ArrayList<String>();
				while (st.hasMoreTokens())
					params.add(st.nextToken());
				switch (command.toLowerCase()) {
				case "add": {
					int idsp = Integer.parseInt(params.get(0));
					String name = params.get(1);
					double price = Double.parseDouble(params.get(2));
					int count = Integer.parseInt(params.get(3));

					boolean isOk = productDao.add(new Product(idsp, name, count, price));
					pw.println(isOk ? "OK" : "ERROR");
					break;
				}
				case "buy": {
					List<Integer> ids = new ArrayList<Integer>();
					for (String param : params)
						ids.add(Integer.parseInt(param));
					pw.println(productDao.buy(ids) ? "OK" : "ERROR");
					break;
				}
				case "price": {
					List<Product> res = productDao.price(Double.parseDouble(params.get(0)),
							Double.parseDouble(params.get(1)));
					if (res.isEmpty()) {
						pw.println("Product not found");
					} else {
						for (Product prod : res)
							pw.println(prod.toString());
					}
					pw.println("the end");
					break;
				}
				case "name": {
					List<Product> res = productDao.name(params.get(0));
					if (res.isEmpty()) {
						pw.println("Product not found");
					} else {
						for (Product prod : res)
							pw.println(prod.toString());
					}
					pw.println("the end");
					break;
				}
				default:
					pw.println("unknown command");
				}
			} catch (Exception e) {
				e.printStackTrace();
				pw.println("ERROR");
				if (cmd != null && (cmd.toLowerCase().startsWith("price\t") || cmd.toLowerCase().startsWith("name\t")))
					pw.println("THE END");
			}
		}
	}
}
