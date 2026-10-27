package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

public class ServerThread extends Thread {
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;
	private boolean isLogin = false;
	private String username = null;
	private UserDao userDao;
	private ProductDao prodDao;

	public ServerThread(Socket socket) throws IOException, ClassNotFoundException, SQLException {
		this.socket = socket;
		pw = new PrintWriter(this.socket.getOutputStream(), true);
		br = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
		userDao = new UserDao();
		prodDao = new ProductDao();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		pw.println("WELCOME");
		process();
		pw.println("BYE");
		try {
			socket.close();
			userDao.close();
			prodDao.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void process() {
		loop1: while (!isLogin) {
			try {
				String cmd = br.readLine();
				if(cmd.equalsIgnoreCase("exit")) break loop1;
				// token
				StringTokenizer st = new StringTokenizer(cmd, "\t");
				String command;
				try {
					command = st.nextToken();
				} catch (NoSuchElementException e) {
					// TODO: handle exception
					throw new MyException("Vui long nhap lenh");
				}
				String param;
				try {
					param = st.nextToken();
				} catch (NoSuchElementException e) {
					throw new MyException("Vui long nhap param");
				}
				// perform
				switch (command.toLowerCase()) {
				case "user": {
					username = param;
					pw.println(userDao.checkUsername(username) ? "OK" : "FALSE");
					break;
				}
				case "pass": {
					if (username == null) {
						pw.println("Vui long nhap username truoc");
					} else {
						boolean isOk = userDao.login(username, param);
						if (isOk)
							isLogin = true;
						pw.println(isOk ? "OK" : "FALSE");
					}
					break;
				}
				default:
					pw.println("vui long dang nhap");
				}
			} catch (MyException e) {
				// TODO: handle exception
				pw.println(e.getMessage());
			} catch (Exception e) {
				pw.println("ERROR");
			}
		}

		loop2: while (isLogin) {
			try {
				String cmd = br.readLine();
				if(cmd.equalsIgnoreCase("quit")) break loop2;
				// token
				StringTokenizer st = new StringTokenizer(cmd, "\t");
				String command;
				try {
					command = st.nextToken();
				} catch (NoSuchElementException e) {
					// TODO: handle exception
					throw new MyException("Vui long nhap lenh");
				}
				List<String> params = new ArrayList<String>();

				while (st.hasMoreTokens())
					params.add(st.nextToken());

				// perform
				switch (command.toLowerCase()) {
				case "add": {
					if (params.size() != 4) {
						pw.println("vui long nhap dung so luong cac truong");
					} else {
						int idsp, count;
						double price;
						String name;

						try {
							idsp = Integer.parseInt(params.get(0));
						} catch (NumberFormatException e) {
							// TODO: handle exception
							throw new MyException("Id cua san pham phai la con so");
						}
						name = params.get(1);
						try {
							count = Integer.parseInt(params.get(2));
						} catch (NumberFormatException e) {
							// TODO: handle exception
							throw new MyException("so luong cua san pham phai la con so");
						}
						try {
							price = Double.parseDouble(params.get(3));
						} catch (NumberFormatException e) {
							// TODO: handle exception
							throw new MyException("gia cua san pham phai la con so");
						}

						boolean isOk = prodDao.add(new Product(idsp, name, count, price));
						pw.println(isOk ? "OK" : "ERROR");
					}
					break;
				}
				case "remove": {
					if (params.isEmpty()) {
						pw.println("Vui long nhap cac id cho remove");
					} else {
						List<Integer> ids = new ArrayList<Integer>();
						try {
							for (String id : params)
								ids.add(Integer.parseInt(id));
						} catch (NumberFormatException e) {
							throw new MyException("ma cua san pham phai la con so");
						}
						pw.println("ROWS EFFECT: " + prodDao.remove(ids));
					}
					break;
				}
				case "view": {
					if (params.isEmpty()) {
						pw.println("Vui long nhap tu khoa cho view");
					} else {
						List<Product> res = prodDao.view(params.get(0));
						for (Product prod : res)
							pw.println(prod.toString());
					}
					pw.println("THE END");
					break;
				}
				case "edit": {
					if (params.size() != 4) {
						pw.println("vui long nhap dung so luong cac truong");
					} else {
						int idsp, count;
						double price;
						String name;
						try {
							idsp = Integer.parseInt(params.get(0));
						} catch (NumberFormatException e) {
							// TODO: handle exception
							throw new MyException("Id cua san pham phai la con so");
						}
						name = params.get(1);
						try {
							count = Integer.parseInt(params.get(2));
						} catch (NumberFormatException e) {
							// TODO: handle exception
							throw new MyException("so luong cua san pham phai la con so");
						}
						try {
							price = Double.parseDouble(params.get(3));
						} catch (NumberFormatException e) {
							// TODO: handle exception
							throw new MyException("gia cua san pham phai la con so");
						}
						boolean isOk = prodDao.edit(new Product(idsp, name, count, price));
						pw.println(isOk ? "OK" : "CAN NOT UPDATE");
					}
					break;
				}
				default: {
					pw.println("khong biet lenh");
				}
					
				}
			} catch (MyException e) {
				// TODO: handle exception
				pw.println(e.getMessage());
			} catch (Exception e) {
				pw.println("ERROR");
			}
		}
	}
}
