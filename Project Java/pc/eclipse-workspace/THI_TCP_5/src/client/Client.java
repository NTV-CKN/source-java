package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.StringTokenizer;

public class Client {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 2000);
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(dis.readUTF());
		while (true) {
			String cmd = input.readLine();
			StringTokenizer st = new StringTokenizer(cmd, "\t");
			String command = st.nextToken();
			String param = cmd.substring(command.length(), cmd.length()).trim();
			switch (command.toLowerCase()) {
			case "user": {
				dos.writeUTF(command + "\t" + param);
				break;
			}
			case "pass": {
				dos.writeUTF(command + "\t" + param);
				break;
			}
			case "add": {
				StringTokenizer st2 = new StringTokenizer(param, "\t");
				String idTs = st2.nextToken();
				String name = st2.nextToken();
				String date = st2.nextToken();
				String address = st2.nextToken();
				String url = st2.nextToken();
				File file = new File(url);

				dos.writeUTF(command + "\t" + idTs + "\t" + name + "\t" + date + "\t" + address + "\t" + url);
				boolean isSuit = dis.readBoolean();
				if (isSuit) {
					dos.writeLong(file.length());
					boolean isAccpt = dis.readBoolean();
					if (isAccpt) {
						FileInputStream fis = new FileInputStream(file);
						long counter = file.length();
						int byteMustReaded;
						byte[] buff = new byte[102400];
						System.out.println("1");
						while (counter > 0) {
							System.out.println(counter);
							byteMustReaded = (int) (buff.length > counter ? counter : buff.length);
							int byteReaded = fis.read(buff, 0, byteMustReaded);
							counter -= byteReaded;
							dos.write(buff, 0, byteReaded);
						}
						fis.close();
					}
				}

				break;
			}
			case "image": {
				StringTokenizer st2 = new StringTokenizer(param, "\t");
				String source = st2.nextToken();
				String id = st2.nextToken();
				dos.writeUTF(command + "\t" + id);
				boolean isOK = dis.readBoolean();
				if(isOK) {
					FileOutputStream fos = new FileOutputStream(source);
					long counter = dis.readLong();
					int byteMustReaded;
					byte[] buff = new byte[102400];
					while (counter > 0) {
						byteMustReaded = (int) (buff.length > counter ? counter : buff.length);
						int byteReaded = dis.read(buff, 0, byteMustReaded);
						counter -= byteReaded;
						fos.write(buff, 0, byteReaded);
					}
					fos.close();
				}
				break;
			}
			case "remove": {
				dos.writeUTF(command + "\t" + param);
				break;
			}
			case "quit": {
				dos.writeUTF(command);
				break;
			}
			case "exit": {
				dos.writeUTF(command);
				break;
			}
			default:
				dos.writeUTF(command + "\t" + param);
			}
			String res = dis.readUTF();
			System.out.println(res);
			if (cmd.equalsIgnoreCase("exit") || cmd.equalsIgnoreCase("quit"))
				if (res.equalsIgnoreCase("BYE"))
					break;
		}
		socket.close();
	}
}
