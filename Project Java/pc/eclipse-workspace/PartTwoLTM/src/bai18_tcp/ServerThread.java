package bai18_tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

public class ServerThread extends Thread {
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;
	private String command, param;
	private boolean isLogin = false;
	private String username = null;
	private StudentDao dao;

	public ServerThread(Socket socket) throws IOException, ClassNotFoundException, SQLException {
		this.socket = socket;
		pw = new PrintWriter(socket.getOutputStream(), true);
		br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		dao = new StudentDao();
	}

	@Override
	public void run() {
		super.run();
		try {
			pw.println("WELCOME CLIENT");
			while (true) {

				String cmd = br.readLine();
				if (cmd.equalsIgnoreCase("exit")) {
					pw.println("BYE");
					break;
				}
				processCmd(cmd);
				String res = performCmd();
				pw.println(res);
			}
			this.socket.close();
		} catch (IOException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String performCmd() throws SQLException {
		if (!isLogin) {
			switch (command) {
			case "user": {
				boolean isValid = dao.checkUsername(param);
				if (isValid) {
					username = param;
					return "USER OK";
				}
				username = null;
				return "USER ERROR";
			}
			case "pass": {
				if (username == null)
					return "Moi nhap username truoc";
				boolean login = dao.login(username, param);
				if (login) {
					isLogin = true;
					return "Login OK";
				}
				return "Login fail";
			}
			default:
				return "Moi dang nhap";
			}
		}
		if (isLogin) {
			switch (command) {
			case "findbyid": {
				int id = Integer.parseInt(param.trim());
				Student st = dao.findStById(id);
				if (st == null)
					return "Khong tim thay sv";
				return st.toString();
			}
			case "findbyname": {
				List<Student> lst = dao.findStByName(param);
				for (Student st : lst) {
					 pw.println(st.toString());
				}
				return "ENDFBN";
			}
			case "remove": {
				int id = Integer.parseInt(param.trim());
				boolean isValid = dao.deleteStudent(id);
				return isValid?"DEL SUCCESS":"DEL FAILED";
			}
			case "add": {
				StringTokenizer st2 = new StringTokenizer(param, "\t");
				Student student = new Student(Integer.parseInt(st2.nextToken()), st2.nextToken(), Double.parseDouble(st2.nextToken()));
				boolean isValid = dao.addStudent(student);
				return isValid?"ADD SUCCESS":"ADD FAILED";
			}
			//update theo id, cac du lieu student cach nhau 1 tab dong
			case"update": {
				StringTokenizer st = new StringTokenizer(param, " ");
				String token1 = st.nextToken();
				int id = Integer.parseInt(token1);
				String remain = param.substring(token1.length(), param.length()).stripLeading();
				StringTokenizer st2 = new StringTokenizer(remain, "\t");
				Student student = new Student(Integer.parseInt(st2.nextToken()), st2.nextToken(), Double.parseDouble(st2.nextToken()));
				boolean isValid = dao.update(id, student);
				return isValid?"UPDATE SUCCESS":"UPDATE FAILED";
			}
			default:
				return "Khong thay lenh phu hop";
			}
		}
		return "Unknow";
	}

	private void processCmd(String cmd) {
		StringTokenizer st = new StringTokenizer(cmd, " ");
		command = st.nextToken().toLowerCase();
		param = cmd.substring(command.length(), cmd.length()).stripLeading();
	}
}
