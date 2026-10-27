package socket_th2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

public class MyThread {
	public MyThread(Socket socket) {
		Thread t = new Thread(() -> {
			try {
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				while (true) {
					String cmd = br.readLine();
					if (cmd.toLowerCase().startsWith("exit"))
						break;
					pw.println(processCmd(cmd, pw, br));
				}
				pw.close();
				br.close();
				socket.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		});
		t.start();
	}

	private String processCmd(String cmd, PrintWriter pw, BufferedReader br) {
		try {
			StringTokenizer st = new StringTokenizer(cmd, "+-*/");
			String num1 = "", num2 = "";
			if (st.countTokens() == 0) {
				pw.println("Vui long nhap 2 con so cach nhau bang khoang trang");
				String res = br.readLine();
				StringTokenizer st2 = new StringTokenizer(res, " ");
				if (st2.countTokens() < 2)
					return "Khong hop le, vui long nhap lai phep tinh";
				num1 = st2.nextToken();
				num2 = st2.nextToken();
			} else if (st.countTokens() == 1) {
				if (cmd.startsWith("+") || cmd.startsWith("-") || cmd.startsWith("/") || cmd.startsWith("*")) {
					pw.println("Vui long nhap so dau tien");
					String res = br.readLine();
					num1 = res;
					num2 = st.nextToken();
				} else if (cmd.contains("+") || cmd.contains("-") || cmd.contains("/") || cmd.contains("*")) {
					pw.println("Vui long nhap so con lai");
					String res = br.readLine();
					num2 = res;
					num1 = st.nextToken();
				}
			} else {
				num1 = st.nextToken();
				num2 = st.nextToken();
			}
			double n1 = Double.parseDouble(num1.trim());
			double n2 = Double.parseDouble(num2.trim());

			if (cmd.contains("+")) {
				return cmd + "=" + (n1 + n2);
			} else if (cmd.contains("-")) {
				return cmd + "=" + (n1 - n2);
			} else if (cmd.contains("/")) {
				if (n2 == 0)
					return "Khong the chia 0";
				return cmd + "=" + (n1 / n2);
			} else if (cmd.contains("*")) {
				return cmd + "=" + (n1*n2);
			} else {
				return "Khong ho tro phep tinh nay";
			}
		} catch (NumberFormatException nfe) {
			return "Toan hang phai la so";
		} catch (Exception e) {
			return "Xay ra loi: " + e.getMessage();
		}
	}
}
