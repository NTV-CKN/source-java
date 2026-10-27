package server;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.StringTokenizer;

public class ServerThread extends Thread {
	private Socket socket;
	private DataOutputStream pw;
	private DataInputStream br;
	private boolean isLogin = false;
	private String username = null;
	private UserDao dao;

	public ServerThread(Socket socket) throws IOException, ClassNotFoundException, SQLException {
		this.socket = socket;
		dao = new UserDao();
		pw = new DataOutputStream(socket.getOutputStream());
		br = new DataInputStream(socket.getInputStream());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			pw.writeUTF("WELCOME CLIENT");
			process();
			pw.writeUTF("BYE");
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void process() throws IOException {
		while (!isLogin) {
			try {
				// input
				String cmd = br.readUTF();
				if (cmd.equalsIgnoreCase("exit"))
					break;
				// token
				StringTokenizer st = new StringTokenizer(cmd);
				String command = st.nextToken();
				String param = cmd.substring(command.length(), cmd.length()).stripLeading();
				// perform
				switch (command.toLowerCase()) {
				case "user": {
					username = param;
					pw.writeUTF(dao.checkUsername(username) ? "OK" : "FALSE");
					break;
				}
				case "pass": {
					if (username == null)
						pw.writeUTF("ENTER USERNAME BEFORE");
					else {
						boolean isOk = dao.login(username, param);
						if (isOk)
							isLogin = true;
						pw.writeUTF(isOk ? "OK" : "FALSE");
					}
					break;
				}
				default:
					pw.writeUTF("pls login");
				}

			} catch (Exception e) {
				pw.writeUTF("ERROR");
			}
		}

		// login = true
		while (isLogin) {
			try {
				// input
				String cmd = br.readUTF();
				if (cmd.equalsIgnoreCase("quit"))
					break;
				// token
				StringTokenizer st = new StringTokenizer(cmd);
				String command = st.nextToken();
				String param = st.nextToken();
				// perform
				switch (command.toLowerCase()) {
				case "send": {
					long counter = br.readLong();
					FileOutputStream fos = new FileOutputStream(param);
					byte[] buff = new byte[102400];
					int byteMustRead;
					while (counter > 0) {
						byteMustRead = (int) (buff.length > counter ? counter : buff.length);
						int byteReaded = br.read(buff, 0, byteMustRead);
						counter -= byteReaded;
						fos.write(buff, 0, byteReaded);
					}
					fos.close();
					pw.writeUTF("SEND SUCCESS");
				}
				case "get": {
					File file = new File(param);
					FileInputStream fis = new FileInputStream(file);
					long counter = file.length();
					byte[] buff = new byte[102400];
					int byteMustRead;
					pw.writeLong(counter);
					while (counter > 0) {
						byteMustRead = (int) (buff.length > counter ? counter : buff.length);
						int byteReaded = fis.read(buff, 0, byteMustRead);
						counter-= byteReaded;
						pw.write(buff, 0, byteReaded);
					}
					fis.close();
					pw.writeUTF("GET SUCCESS");
					break;
				}
				default:
					pw.writeUTF("unknown command");
				}

			} catch (Exception e) {
				pw.writeUTF("ERROR");
			}
		}
	}
}
