

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.StringTokenizer;

import javax.tools.FileObject;

import server.DownloadWrap;
import server.ILogin;
import server.IManagerFile;

public class Client {
	private Socket socket;
	private ILogin login;
	private IManagerFile manager;
	private BufferedReader br;
	private boolean isLogin = false;
	private String username = null;

	public Client() throws IOException, NotBoundException {
		Registry regis = LocateRegistry.getRegistry(7000);
		login = (ILogin) regis.lookup("login");
		br = new BufferedReader(new InputStreamReader(System.in));
	}

	public void process() {
		perform();
		System.out.println("BYE");
		try {
			login.close();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void perform() {
		while (!isLogin) {
			try {
				String cmd = br.readLine();
				if(cmd.equalsIgnoreCase("quit"))break;
				StringTokenizer st = new StringTokenizer(cmd, " ");
				String command = st.nextToken();
				String param = cmd.substring(command.length(), cmd.length()).stripLeading();
				switch (command.toLowerCase()) {
				case "pass": {
					if (username == null)
						System.out.println("Please enter username before");
					else {
						manager = login.login(username, param);
						if (manager != null)
							isLogin = true;
						System.out.println(manager != null ? "OK" : "FALSE");
					}
					break;
				}
				case "user": {
					username = param;
					System.out.println(login.checkUsername(username) ? "OK" : "FALSE");
					break;
				}
				default:
					System.out.println("plz login");
				}
			} catch (Exception e) {
				System.out.println("ERROR");
			}
		}
		while (isLogin) {
			try {
				String cmd = br.readLine();
				if(cmd.equalsIgnoreCase("quit"))break;
				StringTokenizer st = new StringTokenizer(cmd, " ");
				String command = st.nextToken();
				String source = st.nextToken();
				String dest = st.nextToken();
				switch (command.toLowerCase()) {
				case "send": {
					File file = new File(source);
					FileInputStream fis = new FileInputStream(file);
					long counter = file.length();
					int byteMustRead;
					byte[] buff = new byte[102400];
					while (counter > 0) {
						byteMustRead = (int) (counter > buff.length ? buff.length : counter);
						int byteReaded = fis.read(buff, 0, byteMustRead);
						counter -= byteReaded;
						manager.send(dest, buff, 0, byteReaded);
					}
					System.out.println("OK");
					fis.close();
					break;
				}
				case "get": {
					File file = new File(source);
					FileOutputStream fos = new FileOutputStream(file);
					long counter = manager.getSize(dest);
					int byteMustRead;
					byte[] buff = new byte[102400];
					while (counter > 0) {
						byteMustRead = (int) (counter > buff.length ? buff.length : counter);
						DownloadWrap wrap = manager.get(dest, byteMustRead);
						counter -= wrap.getByteReaded();
						fos.write(wrap.getBuff(), 0, wrap.getByteReaded());
					}
					System.out.println("OK");
					manager.closeFis();
					fos.close();
					break;
				}
				default:
					System.out.println("plz login");
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("ERROR");
			}
		}
	}

	public static void main(String[] args) throws IOException, NotBoundException {
		new Client().process();
	}
}
