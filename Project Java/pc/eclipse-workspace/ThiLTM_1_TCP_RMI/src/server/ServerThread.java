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
	private boolean isContinue = true;
	private boolean isLogin = false;
	private String command, param, username = null;
	private UserDao userDao;
	private ProductDao productDao;

	public ServerThread(Socket socket) throws IOException, ClassNotFoundException, SQLException {
		this.socket = socket;
		pw = new PrintWriter(socket.getOutputStream(), true);
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
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
				String rs = performCmd();
				pw.println(rs);
			}socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	private String performCmd() {
		if (!isLogin) {
			switch (command) {
			case "user": {
				username = param;

				return userDao.checkUsername(username) ? "OK" : "FALSE";
			}
			case "pass": {
				if (username == null)
					return "VUI LONG NHAP USERNAME";
				if (userDao.login(username, param)) {
					isLogin = true;
					return "OK";
				}
				return "FALSE";
			}
			case "exit": {
				isContinue = false;
				return "BYE";
			}
			default:
				return "VUI LONG DANG NHAP";
			}
		} else {
			switch (command) {
			case "add": {
				StringTokenizer st = new StringTokenizer(param, "\t");
				int idsp = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				int count = Integer.parseInt(st.nextToken());
				double price = Double.parseDouble(st.nextToken());
				
				return productDao.add(idsp, name, count, price)>0?"OK":"ERROR";
			}
			case "edit": {
				StringTokenizer st = new StringTokenizer(param, "\t");
				int idsp = Integer.parseInt(st.nextToken());
				String name = st.nextToken();
				int count = Integer.parseInt(st.nextToken());
				double price = Double.parseDouble(st.nextToken());
				
				return productDao.edit(idsp, name, count, price)>0?"OK":"CAN NOT UPDATE";
			}
			case "view": {
				List<Product> res = productDao.view(param);
				for(Product prod: res) {
					pw.println(prod.toString());
				}
				return "the end";
			}
			case "remove": {
				StringTokenizer st = new StringTokenizer(param, "\t");
				List<Integer> list = new ArrayList<Integer>();
				while(st.hasMoreTokens()) {
					list.add(Integer.parseInt(st.nextToken()));
				}
				return"ROW EFFECTS: "  + productDao.remove(list);
			}
			case "quit": {
				isContinue = false;
				return "BYE";
			}
			default:
				return "VUI LONG NHAP DUNG LENH";
			}
		}
	}

	private void processCmd(String cmd) {
		StringTokenizer st = new StringTokenizer(cmd, "\t");
		command = st.nextToken().toLowerCase();
		param = cmd.substring(command.length(), cmd.length()).trim();
	}
}
