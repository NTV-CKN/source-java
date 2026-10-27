package bai16_1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

public class Client {
	private static String command;
	private static String param1, param2;

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket socket = new Socket("localhost", 2000);
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(dis.readUTF());
		boolean isContinue = true;
		while (isContinue) {
			String cmd = br.readLine();
			if (cmd.equalsIgnoreCase("exit")) {
				dos.writeUTF("exit");
				isContinue = dis.readBoolean();
				System.out.println(dis.readUTF());
			} else {
				processCmd(cmd);
				String res = performCmd(dis, dos);
				System.out.println(res);
			}
		}
		socket.close();
	}

	private static String performCmd(DataInputStream dis, DataOutputStream dos) throws IOException {
		switch (command) {
		case "upload": {
			// Yeu cau server chuan bi don nhan du lieu
			dos.writeUTF(command + " " + param2);
			// mo file va doc
			File file = new File(param1);
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
			return dis.readUTF();
		}
		case "download": {
			dos.writeUTF(command + " " + param2);
			long counter = dis.readLong();
			File file = new File(param1);
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
			return dis.readUTF();
		}
		default:
			return dis.readUTF();
		}
	}

	private static void processCmd(String cmd) {
		StringTokenizer st = new StringTokenizer(cmd, " ");
		command = st.nextToken().toLowerCase();
		param1 = st.nextToken();
		param2 = st.nextToken();
	}
}
