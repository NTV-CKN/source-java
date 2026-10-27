package relearn_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Task2 {
	private String folderPath;
	private File folderCurrent;
	private String command, param;

	public Task2() {
		this.folderPath = "C:\\Users\\pc\\Downloads";
		folderCurrent = new File(folderPath);
	}

	public void run() throws IOException {
		PrintWriter pw = new PrintWriter(System.out, true);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pw.println("Hello, please enter command!");
		while (true) {
			pw.print(folderCurrent.getAbsolutePath() + ">");
			pw.flush();
			String cmd = br.readLine();
			if (cmd.toLowerCase().startsWith("exit"))
				break;
			processCommand(cmd);
			String res = performCommand();
			pw.println(res);
		}
	}

	private String performCommand() throws IOException {
		switch (command) {
		case "cd": {
			return cdPerform(param);
		}
		case "dir": {
			return dirPerform();
		}
		case "delete": {
			return deletePerform(param);
		}
		default:
			return "Khong co lenh nay";
		}
	}

	private String deletePerform(String param2) {
		boolean res = deleteFileOrFolder(folderCurrent + "\\" + param2);
		return res ? "Xoa thanh cong" : "Xoa that bai";
	}

	private String dirPerform() {
		StringBuilder strB = new StringBuilder();
		File[] files = folderCurrent.listFiles();
		for (File folder : files) {
			if (folder.isDirectory()) {
				strB.append(folder.getName().toUpperCase()).append("\n");
			}
		}

		for (File file : files) {
			if (file.isFile()) {
				strB.append(file.getName().toLowerCase()).append("\n");
			}
		}
		return strB.toString();
	}

	private String cdPerform(String param2) throws IOException {
		if (param.equals("..")) {
			try {
				folderPath = folderPath.substring(0, folderPath.lastIndexOf("\\"));
				folderCurrent = new File(folderPath);
				return folderPath;
			} catch (IndexOutOfBoundsException e) {
				return "Khong the back ve sau";
			}
		} else {
			File file = new File(param);
			if (!file.isAbsolute()) {
				File folderNew = new File(folderCurrent, param);
				if (!folderNew.exists())
					return "Loi duong dan khong ton tai";
				folderCurrent = folderNew;
				return folderCurrent.getAbsolutePath();
			}
			file = file.getCanonicalFile();
			if (file.exists() && file.isDirectory()) {
				folderCurrent = file;
				return file.getAbsolutePath();
			}
			return "DUong dan khong hop le";
		}
	}

	private boolean deleteFileOrFolder(String path) {
		File xx = new File(path);
		if (!xx.exists())
			return false;
		if (xx.isFile())
			return xx.delete();
		File[] files = xx.listFiles();
		boolean isDelete = true;
		for (File yy : files) {
			if (yy.isFile())
				isDelete = isDelete && yy.delete();
			if (yy.isDirectory())
				isDelete = isDelete && deleteFileOrFolder(yy.getAbsolutePath());
		}
		return isDelete && xx.delete();
	}

	private void processCommand(String cmd) {
		StringTokenizer st = new StringTokenizer(cmd, " ");
		command = st.nextToken().toLowerCase();
		param = cmd.substring(command.length(), cmd.length()).trim();
	}

	public static void main(String[] args) throws IOException {
		String path = "C:\\Users\\pc\\.\\Downloads\\Newfolder";
		File file = new File(path);
		System.out.println(file.getAbsolutePath());
		System.out.println(file.getCanonicalPath());
		new Task2().run();
	}
}
