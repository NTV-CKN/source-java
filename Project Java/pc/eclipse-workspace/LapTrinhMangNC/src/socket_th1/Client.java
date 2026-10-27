package socket_th1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 2000);
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter: ");
			String cmd = sc.nextLine();
			if (cmd.toUpperCase().endsWith("EXIT")) {
				dos.writeUTF("EXIT");
				boolean isContinue = dis.readBoolean();
				System.out.println(isContinue);
				if (!isContinue)
					break;
			}
			processCmd(cmd, dos, dis);
		}
		socket.close();
	}

	private static void processCmd(String cmd, DataOutputStream dos, DataInputStream dis) throws IOException {
		StringTokenizer st = new StringTokenizer(cmd, " ");
		String command = st.nextToken().toUpperCase();
		String src = st.nextToken();
		String dest = st.nextToken();

		switch (command) {
		case "UPLOAD": {
			dos.writeUTF(command + " " + dest);
			boolean canUpload = dis.readBoolean();
			if (canUpload) {
				File file = new File(src);
				dos.writeLong(file.length());

				// doc
				byte[] buff = new byte[102400];
				long count = file.length();
				FileInputStream fis = new FileInputStream(file);
				int byteMustRead;
				while (count > 0) {
					byteMustRead = (int) (buff.length > count ? count : buff.length);
					int byteReaded = fis.read(buff, 0, byteMustRead);
					dos.write(buff, 0, byteReaded);
					count -= byteReaded;
				}
				fis.close();
				System.out.println(dis.readUTF());// doc thong bao
			} else {
				System.out.println("CANNOT UPLOAD: " + dest);
			}
			break;
		}
		default:
			return;
		}
	}
}
