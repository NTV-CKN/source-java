package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ServerThread extends Thread {
	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;
	private boolean isLogin = false;
	private String username = null;
	private ManagerTS manager;
	private UserDao dao;

	public ServerThread(Socket socket) throws IOException, ClassNotFoundException, SQLException {
		this.socket = socket;
		dao = new UserDao();
		manager = new ManagerTS();
		dos = new DataOutputStream(socket.getOutputStream());
		dis = new DataInputStream(socket.getInputStream());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		try {
			dos.writeUTF("WELCOME TO MY SERVER");
			process();
			dos.writeUTF("BYE");
			dao.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void process() throws IOException {
		while (!isLogin) {
			try {
				String cmd = dis.readUTF();
				if (cmd.equalsIgnoreCase("exit"))
					break;
				StringTokenizer st = new StringTokenizer(cmd, "\t");
				String command = st.nextToken();
				String param = st.nextToken();

				switch (command.toLowerCase()) {
				case "user": {
					username = param;
					dos.writeUTF(dao.checkUsername(username) ? "OK" : "FALSE");
					break;
				}
				case "pass": {
					if (username == null)
						dos.writeUTF("PLEASE ENTER USERNAME BEFORE");
					else {
						boolean isOK = dao.login(username, param);
						if (isOK)
							isLogin = true;
						dos.writeUTF(isOK ? "OK" : "FALSE");
					}
					break;
				}
				default:
					dos.writeUTF("pls login");
				}
			} catch (Exception e) {
				dos.writeUTF("error");
			}
		}

		while (isLogin) {
			try {
				String cmd = dis.readUTF();
				if (cmd.equalsIgnoreCase("quit"))
					break;
				StringTokenizer st = new StringTokenizer(cmd, "\t");
				String command = st.nextToken();
				List<String> params = new ArrayList<String>();
				while (st.hasMoreTokens())
					params.add(st.nextToken());

				switch (command.toLowerCase()) {
				case "remove": {
					boolean isOk = manager.remove(Integer.parseInt(params.get(0)));
					dos.writeUTF(isOk ? "REMOVE SUCCESS" : "REMOVE FAILED");
					break;
				}
				case "image": {
					int idTs = Integer.parseInt(params.get(0));
					boolean isOk = manager.findById(idTs);
					dos.writeBoolean(isOk);
					if (isOk) {
						dos.writeLong(100000);
						boolean isSuccess = manager.getImgTs(idTs, dos);
						dos.writeUTF(isSuccess ? "getOk" : "getFailed");
					} else {
						dos.writeUTF("Can not found id thi sinh");
					}
					break;
				}
				case "add": {
					int idTs = Integer.parseInt(params.get(0));
					String name = params.get(1);
					String date = params.get(2);
					String address = params.get(3);
					String url = params.get(4);
					boolean isJpeg = url.toLowerCase().endsWith(".jpg");
					dos.writeBoolean(isJpeg);
					if (isJpeg) {
						long len = dis.readLong();
						if (len > 100000) {
							dos.writeBoolean(false);
							dos.writeUTF("Can not accept file image over len 100kb");
						} else {
							dos.writeBoolean(true);
							boolean isOk = manager.addTs(new ThiSinh(idTs, name, date, address), dis, len);
							dos.writeUTF(isOk ? "Add OK" : "Add Failed");
						}
					} else {
						dos.writeUTF("Can not accept file not jpeg");
					}
					break;
				}
				default:
					dos.writeUTF("unknown command");
				}
			} catch (Exception e) {
				dos.writeUTF("error");
			}
		}
	}
}
