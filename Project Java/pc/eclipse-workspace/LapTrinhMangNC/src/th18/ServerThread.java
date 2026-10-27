package th18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class ServerThread extends Thread {
	private boolean isContinue = true;
	boolean isAuthorization = false;
	private String command = "", param1 = "", username = "", pass = "";
	private Socket socket;
	private List<Students> students;

	public ServerThread(Socket socket, List<Students> students) {
		this.socket = socket;
		this.students = students;
	}

	@Override
	public void run() {
		super.run();
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw.println("Xin chao, vui long dang nhap");
			while (isContinue) {
				String cmd = br.readLine();
				processCmd(cmd);
				String res = performCmd();
				pw.println(res);
				pw.println(isContinue);
			}
			pw.close();
			br.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private String performCmd() {
		switch (command) {
		case "QUIT": {
			isContinue = false;
			return "cancel connect";
		}
		case "FindById": {
			if (!isAuthorization)
				return "Vui long dang nhap";
			int id = Integer.parseInt(param1);
			for (Students student : students) {
				if (student.studentId == id)
					return student.toString();
			}
			return "Khong tim thay sinh vien nay";
		}
		case "FindByName": {
			if (!isAuthorization)
				return "Vui long dang nhap";
			List<Students> studentsName = new ArrayList<Students>();
			for (Students student : students) {
				if (nameFindContain(param1, student.fullName)) {
					studentsName.add(student);
				}
			}
			StringBuilder strB = new StringBuilder();
			for (Students student : studentsName) {
				strB.append(student.toString() + "; ");
			}
			return strB.toString();
		}
		case "USER": {
			if (isAuthorization)
				return "Da dang nhap";
			username = param1;
			return "Nhap mat khau";
		}
		case "PASS": {
			if (isAuthorization)
				return "Da dang nhap";
			if (username.isEmpty())
				return "Vui long nhap username truoc";
			if (username.equals(Server.USER_NAME) && Server.PASS_WORD.equals(param1)) {
				isAuthorization = true;
				return "Dang nhap thanh cong, moi nhap lenh";
			} else {
				pass = "";
				return "Sai mk hoac username";
			}
		}
		default:
			return "He thong khong co lenh nay";
		}
	}

	private boolean nameFindContain(String name, String fullName) {
		StringTokenizer st = new StringTokenizer(fullName, " ");
		List<String> lst = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			lst.add(st.nextToken());
		}
		if (lst.size() == 0)
			return false;
		String tmp = lst.get(lst.size() - 1);
		for (int i = lst.size() - 2; i >= 0; i--) {
			if (tmp.equalsIgnoreCase(name))
				return true;
			tmp = lst.get(i) + " " + tmp;
		}
		return false;
	}

	private void processCmd(String cmd) {
		StringTokenizer st = new StringTokenizer(cmd, " ");
		try {
			command = st.nextToken();
		} catch (Exception e) {
			param1 = "";
			command = "";
		}
		try {
			if (command.equalsIgnoreCase("findbyname")) {
				param1 = st.nextToken();
				while (st.hasMoreTokens()) {
					param1 += " " + st.nextToken();
				}
			} else
				param1 = st.nextToken();
		} catch (Exception e) {
			param1 = "";
		}
	}
}
