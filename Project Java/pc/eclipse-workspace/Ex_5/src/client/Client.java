package client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.StringTokenizer;

import bai16_rmi.UploadFactory;
import bai16_rmi.UploadInterface;

public class Client {
	private static UploadFactory factory;
	private static UploadInterface upload;
	private static String command, source, dest;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			Registry regis = LocateRegistry.getRegistry(12345);
			factory = (UploadFactory) regis.lookup("factory");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("WELCOME");
		while (true) {
			String cmd = br.readLine();
			if (cmd.equalsIgnoreCase("exit"))
				break;
			processCmd(cmd);
			String res = performCmd();
			System.out.println(res);
		}
		System.out.println("BYE");
	}

	private static String performCmd() throws IOException {
		switch (command) {
		case "upload": {
			if (upload == null)
				upload = factory.getUploader(dest);
			else
				upload.resetPath(dest);
			boolean isSuccess = true;
			File file = new File(source);
			FileInputStream fis = new FileInputStream(file);
			long counter = file.length();
			byte[] buff = new byte[102400];
			int byteMustRead;
			while (counter > 0) {
				byteMustRead = (int) (buff.length > counter ? counter : buff.length);
				int byteReaded = fis.read(buff, 0, byteMustRead);
				counter -= byteReaded;
				isSuccess = isSuccess && upload.upload(buff, byteReaded, 0);
			}
			upload.closeFos();
			fis.close();
			return isSuccess ? "UPLOAD CUSSESS" : "UPLOAD FAILED";
		}
		default:
			return "KHONG TIM THAY LENH";
		}
	}

	private static void processCmd(String cmd) {
		StringTokenizer st = new StringTokenizer(cmd, " ");
		command = st.nextToken().toLowerCase();
		source = st.nextToken();
		dest = st.nextToken();
	}
}
