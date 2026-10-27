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
	private UserDao userDao;
	private ProductDao productDao;
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;
	private String command, param, username = null;
	private boolean isContinue = true, isLogin = false;

	public ServerThread(Socket socket) throws IOException, ClassNotFoundException, SQLException {
		this.socket = socket;
		pw = new PrintWriter(this.socket.getOutputStream(), true);
		br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		userDao = new UserDao();
		productDao = new ProductDao();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			pw.println("WELCOME TO MANAGE PRODUCT SYSTEM");
			while (isContinue) {
				String cmd = br.readLine();
				processCmd(cmd);
				String res = performCmd();
				pw.println(res);
			}
			userDao.close();
			productDao.close();
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private String performCmd() {
		if (isLogin) {
			switch (command) {
			case "add": {
				StringTokenizer st = new StringTokenizer(param, "\t");
				int idsp = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				int count = Integer.parseInt(st.nextToken());
				double price = Double.parseDouble(st.nextToken());
				int res = productDao.add(new Product(idsp, name, count, price));

				return res > 0 ? "OK" : "ERROR";
			}
			case "remove": {
				List<Integer> ids = new ArrayList<Integer>();
				StringTokenizer st = new StringTokenizer(param, "\t");
				while (st.hasMoreTokens())
					ids.add(Integer.parseInt(st.nextToken()));

				return "ROW EFFECT: " + productDao.remove(ids);
			}
			case "quit": {

				isContinue = false;
				return "SERVER BYE";
			}
			case "edit": {
				StringTokenizer st = new StringTokenizer(param, "\t");
				int idsp = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				int count = Integer.parseInt(st.nextToken());
				double price = Double.parseDouble(st.nextToken());
				int res = productDao.edit(new Product(idsp, name, count, price));

				return res > 0 ? "OK" : "CAN NOT UPDATE";
			}
			case "view": {
				List<Product> prods = productDao.view(param);
				for (Product prod : prods) {
					pw.println(prod.toString());
				}
				return "THE END";
			}
			default:
				return "LENH KHONG HOP LE";
			}
		} else {
			switch (command) {
			case "user": {
				username = param;
				boolean isValid = userDao.checkUsername(username);
				return isValid ? "OK" : "FALSE";
			}
			case "pass": {
				if (username == null)
					return "VUI LONG NHAP USERNAME TRUOC";
				boolean isValid = userDao.login(username, param);
				if (isValid)
					isLogin = true;
				return isValid ? "OK" : "FALSE";
			}
			case "exit": {
				isContinue = false;
				return "SERVER BYE";
			}
			default:
				return "VUI LONG DANG NHAP";
			}
		}
	}

	private void processCmd(String cmd) {
		StringTokenizer st = new StringTokenizer(cmd, "\t");
		command = st.nextToken();
		param = cmd.substring(command.length(), cmd.length()).trim();
	}
}
