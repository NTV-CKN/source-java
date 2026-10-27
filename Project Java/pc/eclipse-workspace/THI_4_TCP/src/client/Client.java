package client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.StringTokenizer;

import javax.tools.FileObject;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 7000);
		DataOutputStream pw = new DataOutputStream(socket.getOutputStream());
		DataInputStream br = new DataInputStream(socket.getInputStream());
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(br.readUTF());
		while (true) {
			String cmd = input.readLine();
			StringTokenizer st = new StringTokenizer(cmd, " ");
			String command = st.nextToken();
			String param = cmd.substring(command.length(), cmd.length()).stripLeading();

			switch (command.toLowerCase()) {
			case "user": {
				pw.writeUTF(command + " " + param);
				break;
			}
			case "pass": {
				pw.writeUTF(command + " " + param);
				break;
			}
			case "send": {
				StringTokenizer st2 = new StringTokenizer(param, " ");
				String src = st2.nextToken();
				String dest = st2.nextToken();
				pw.writeUTF(command + " " + dest);
				File file = new File(src);
				FileInputStream fis = new FileInputStream(file);
				long counter = file.length();
				byte[] buff = new byte[102400];
				int byteMustRead;
				pw.writeLong(counter);
				while (counter > 0) {
					byteMustRead = (int) (buff.length > counter ? counter : buff.length);
					int byteReaded = fis.read(buff, 0, byteMustRead);
					counter -= byteReaded;
					pw.write(buff, 0, byteReaded);
				}
				fis.close();
				break;
			}
			case "get": {
				StringTokenizer st2 = new StringTokenizer(param, " ");
				String src = st2.nextToken();
				String dest = st2.nextToken();
				pw.writeUTF(command + " " + dest);
				long counter = br.readLong();
				FileOutputStream fos = new FileOutputStream(src);
				byte[] buff = new byte[102400];
				int byteMustRead;
				while (counter > 0) {
					byteMustRead = (int) (buff.length > counter ? counter : buff.length);
					int byteReaded = br.read(buff, 0, byteMustRead);
					counter -= byteReaded;
					fos.write(buff, 0, byteReaded);
				}
				fos.close();
				break;
			}
			case "quit": {
				pw.writeUTF(command);
				break;
			}
			case "exit": {
				pw.writeUTF(command);
				break;
			}
			default:
				pw.writeUTF(command + " " + param);
			}

			String res = br.readUTF();
			System.out.println(res);
			if (cmd.equalsIgnoreCase("exit") || cmd.equalsIgnoreCase("quit")) {
				if (res.equalsIgnoreCase("BYE"))
					break;
			}
		}
		socket.close();
	}
}
