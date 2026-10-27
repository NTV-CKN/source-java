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
	private boolean isLogin = false, isContinue = true;
	private BufferedReader br;
	private UserDao userDao;
	private StudentDao stDao;
	private String command, param, username = null;

	public ServerThread(Socket socket) throws IOException, ClassNotFoundException, SQLException {
		this.socket = socket;
		pw = new PrintWriter(socket.getOutputStream(), true);
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		userDao = new UserDao();
		stDao = new StudentDao();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			pw.println("WELCOME CLIENT");
			while (isContinue) {
				String cmd = br.readLine();

				try {
					processCmd(cmd);
				} catch (MyException e) {
					// TODO: handle exception
					pw.println(e.getMessage());
					continue;
				}
				try {
					String res = performCmd();
					pw.println(res);
				} catch (MyException e) {
					// TODO: handle exception
					pw.println(e.getMessage());
				}
			}
			userDao.close();
			stDao.close();
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private String performCmd() throws MyException {
		if (isLogin) {
			switch (command) {
			case "findbyid": {
				try {
					Student st = stDao.findById(Integer.parseInt(param));
					return st == null ? "Student not found" : st.toString();
				} catch (Exception e) {
					// TODO: handle exception
					throw new MyException("Ma sv phai la con so");
				}
			}
			case "findbyname": {
				List<Student> res = stDao.findByName(param);
				if (res.isEmpty())
					pw.println("Not found");
				;
				for (Student tmp : res) {
					pw.println(tmp.toString());
				}
				return "THE END";
			}
			case "add": {
				try {
					StringTokenizer st = new StringTokenizer(param, "\t");
					int id;
					try {
						id = Integer.parseInt(st.nextToken());
					} catch (NumberFormatException e) {
						throw new MyException("Ma sinh vien phai la con so");
					}
					String name = st.nextToken();
					double grade;
					try {
						grade = Double.parseDouble(st.nextToken());
					} catch (NumberFormatException e) {
						throw new MyException("diem cua sinh vien phai la con so");
					}
					return stDao.add(new Student(id, name, grade)) ? "OK" : "ERROR";
				} catch (NoSuchElementException e) {
					throw new MyException("Vui long nhap du cac fields");
				}
			}
			case "edit": {
				try {
					StringTokenizer st = new StringTokenizer(param, "\t");
					int id;
					try {
						id = Integer.parseInt(st.nextToken());
					} catch (NumberFormatException e) {
						throw new MyException("Ma sinh vien phai la con so");
					}
					String name = st.nextToken();
					double grade;
					try {
						grade = Double.parseDouble(st.nextToken());
					} catch (NumberFormatException e) {
						throw new MyException("diem cua sinh vien phai la con so");
					}

					return stDao.edit(new Student(id, name, grade)) ? "OK" : "CAN NOT UPDATE";

				} catch (NoSuchElementException e) {
					throw new MyException("Vui long nhap du cac fields");
				}
			}
			case "remove": {
				try {
					List<Integer> ids = new ArrayList<Integer>();
					StringTokenizer st = new StringTokenizer(param, "\t");
					try {
						while (st.hasMoreTokens())
							ids.add(Integer.parseInt(st.nextToken()));
					} catch (NumberFormatException e) {
						// TODO: handle exception
						throw new MyException("Ma sinh vien phai la cac con so");
					}

					return "ROW EFFECT: " + stDao.remove(ids);
				} catch (NoSuchElementException e) {
					throw new MyException("Vui long nhap du cac fields");
				}

			}
			case "quit": {
				isContinue = false;
				return "BYE";
			}
			default:
				return "COMMAND NOT FOUND";
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
					return "PLEASE INPUT USERNAME BEFORE";
				boolean isValid = userDao.login(username, param);
				if (isValid)
					isLogin = true;
				return isValid ? "OK" : "FALSE";
			}
			case "exit": {
				isContinue = false;
				return "BYE";
			}
			default:
				return "PLEASE LOGIN";
			}
		}
	}

	private void processCmd(String cmd) throws MyException {
		StringTokenizer st = new StringTokenizer(cmd, " ");
		try {
			command = st.nextToken().toLowerCase();
		} catch (Exception e) {
			// TODO: handle exception
			throw new MyException("Khong nhan dang duoc command");
		}
		param = cmd.substring(command.length(), cmd.length()).trim();
	}
}
