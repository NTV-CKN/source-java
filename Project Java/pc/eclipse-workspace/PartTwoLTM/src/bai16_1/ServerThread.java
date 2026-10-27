package bai16_1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;

public class ServerThread extends Thread {
	private Socket socket;
	private String command, param;
	DataInputStream dis;
	DataOutputStream dos;

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		super.run();
		try {
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF("Welcome client, enter your command!");
			boolean isContinue = true;
			while (isContinue) {
				String cmd = dis.readUTF();
				if (cmd.equalsIgnoreCase("exit")) {
					isContinue = false;
					dos.writeBoolean(isContinue);
					dos.writeUTF("BYE");
					break;
				} else {
					processCmd(cmd);
					performCmd();
				}
			}
			
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void performCmd() throws IOException {
		switch (command) {
		case "upload": {
			long counter = dis.readLong();
			File file = new File(param);
			FileOutputStream fos = new FileOutputStream(file);
			byte[] buff = new byte[102400];
			int byteMustRead;
			while(counter > 0) {
				byteMustRead = (int)(counter>buff.length?buff.length:counter);
				int byteReaded = dis.read(buff, 0, byteMustRead);
				counter -= byteReaded;
				fos.write(buff, 0, byteReaded);
			}
			fos.close();
			dos.writeUTF("UPLOAD SUCCESSFULLY!");
			break;
		}
		case "download": {
			File file = new File(param);
			dos.writeLong(file.length());
			FileInputStream fis = new FileInputStream(file);
			// doc du lieu
			byte[] buff = new byte[102400];
			long counter = file.length();
			int byteMustRead;
			while (counter > 0) {
				byteMustRead = (int) (counter > buff.length ? buff.length : counter);
				int byteReaded = fis.read(buff, 0, byteMustRead);
				counter -= byteReaded;
				dos.write(buff, 0, byteReaded);
			}
			fis.close();
			dos.writeUTF("DOWNLOAD SUCCESSFULLY!");
			break;
		}
		default:
			dos.writeUTF("CANNOT FIND COMMAND");
		}
	}

	private void processCmd(String cmd) {
		StringTokenizer st = new StringTokenizer(cmd, " ");
		command = st.nextToken().toLowerCase();
		param = st.nextToken();
	}
}
