package socket_th1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.StringTokenizer;


public class MyThread {
	public MyThread(Socket socket) {
		Thread t = new Thread(() -> {
			try {
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				while (true) {
					String command = dis.readUTF();
					System.out.println(command);
					if(command.toUpperCase().endsWith("EXIT")) {
						dos.writeBoolean(false);
						break;
					}
					processCmd(command, dos, dis);
				}
				System.out.println("EXIT");
				socket.close();
			} catch (IOException e) {
				 System.out.println(e.getMessage());
			}
		});
		t.start();
	}
	private static void processCmd(String cmd, DataOutputStream dos, DataInputStream dis) throws IOException {
		StringTokenizer st = new StringTokenizer(cmd, " ");
		String command = st.nextToken().toUpperCase();
		String dest = st.nextToken();
		
		switch (command) {
		case "UPLOAD": {
			File destFile = new File(dest);
			boolean canUpload = !destFile.exists();
			dos.writeBoolean(canUpload);
			if(canUpload) {
				//doc
				byte[] buff = new byte[102400];
				long count = dis.readLong();
				FileOutputStream fos = new FileOutputStream(destFile);
				int byteMustRead;
				while(count > 0) {
					 byteMustRead =(int)( buff.length > count?count:buff.length);
					 int byteReaded = dis.read(buff, 0, byteMustRead);
					 fos.write(buff, 0, byteReaded);
					 count -= byteReaded;
				}
				fos.close();
				dos.writeUTF("OK");//gui thong bao
			} else {
				System.out.println("CANNOT UPLOAD: "  + dest);
			}
			break;
		}
		default:
			return;
		}
	}
}
