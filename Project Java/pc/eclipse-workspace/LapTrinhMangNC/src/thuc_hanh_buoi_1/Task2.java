package thuc_hanh_buoi_1;

import java.io.File;
import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

public class Task2 {
	private static ArrayList<String> linkedFolders = new ArrayList<String>(); // index 0 is drive

	// COMMAND MANAGER
	public static void processCommand(String request) {
		String[] arrReq = request.split(" +");
		int size = arrReq.length;
		String cmd = arrReq[0]; // get cmd

		if (cmd.equalsIgnoreCase("cd")) { // cmd: cd
			if (size >= 2) {
				String path = getPath(arrReq, 1); // avoid subfolder has name "abc xyz"
				changeDir(path);
			} else
				printlinkFolder(linkedFolders);
		} else if (cmd.equalsIgnoreCase("dir")) { // cmd: dir
			if (size == 1)
				showDirCurrent();
			else
				System.err.println("No halong mode");
		} else if (cmd.equalsIgnoreCase("delete")) { // cmd: delete
			if (arrReq.length == 1) {
				System.err.println("The syntax of the command is incorrect.");
				return;
			}
			String currentPath = getPath(linkedFolders);
			String pathInput = getPath(arrReq, 1);

			if (isPathInputEqualsCurrentPath(currentPath, pathInput)) {// check case user input equals with current path
				System.err.println("The process cannot access the file because it is being used by another process.");
				return;
			}
			String pathAvailable = isPathInputIndependent(pathInput) ? pathInput : currentPath + "\\" + pathInput;
			if (Task1.deleteByPath(pathAvailable))
				System.out.println("Delete successful");
			else
				System.err.println("Delete failed");
		} else {
			System.err.println(cmd + " is not recognized as an internal or external command,\r\n"
					+ "operable program or batch file.");
		}
	}

	// PRINT CURRENT FOLDER
	public static void printlinkFolder(List<String> folders) {
		if (folders.size() == 0)
			return;
		if (folders.size() == 1) {
			System.out.print(folders.get(0));
			return;
		}

		String result = "";
		for (int i = 0; i < folders.size() - 1; i++) {
			result += folders.get(i) + (char) 92;
		}
		result += folders.get(folders.size() - 1);
		System.out.print(result + ">");
	}

	// SHOW CONTENT OF CURRENT DIR (1 level)
	public static void showDirCurrent() {
		String pathTempList = getPath(linkedFolders);
		File[] arrays = new File(pathTempList).listFiles();
		String saveFile = "";
		if (arrays != null) {
			for (File xx : arrays) {
				if (xx.isDirectory()) {
					System.out.println("<DIR>\t" + xx.getName().toUpperCase());
				} else if (xx.isFile()) {
					saveFile += xx.getName().toLowerCase() + "\n";
				}
			}
			System.out.println(saveFile);
		}
	}

	// COMMAND CD
	public static void changeDir(String path) {
		String[] folders = path.split("\\\\+");
		if (folders.length == 0)
			return;
		// if path is exist and can read, we only cd to this
		// linkedFolders.get(0) => avoid cd .
		File xx = new File(path);
		if (path.contains(linkedFolders.get(0)) && isPathInputIndependent(path)) {
			linkedFolders.clear();
			for (String folder : folders) {
				linkedFolders.add(folder);
			}
			return;
		}

		@SuppressWarnings("unchecked")
		ArrayList<String> tempList = (ArrayList<String>) linkedFolders.clone();
		for (String folder : folders) {
			if (folder.equals("..")) {// remove the last subfolder in tempList, not include drive
				if (tempList.size() > 1)
					tempList.remove(tempList.size() - 1);
			} else if (!folder.equals(".") && !folder.isEmpty()) {
				tempList.add(folder);
			}
		}

		String pathTempList = getPath(tempList);
		File abcxyz = new File(pathTempList);
		if (abcxyz.canRead() && abcxyz.isDirectory()) {
			linkedFolders = tempList;
			tempList = null;
		} else {
			System.err.println("The system cannot find the path specified or another exception");
		}
	}

	// CHECK INPUT PATH INDEPENDENT AND CANREAD
	private static boolean isPathInputIndependent(String path) {
		File xx = new File(path);
		return (xx.canRead() && xx.isDirectory()) ? true : false;
	}

	// CHECK INPUT PATH COMPARE WITH CURRENT PATH
	private static boolean isPathInputEqualsCurrentPath(String currentPath, String pathInput) {
		return currentPath.equals(pathInput);
	}

	// GET PATH BY LIST
	private static String getPath(List<String> linkedFolders) {
		String pathTempList = "";
		for (int i = 0; i < linkedFolders.size() - 1; i++) {// get path tempList
			pathTempList += linkedFolders.get(i) + "\\";
		}
		pathTempList += linkedFolders.get(linkedFolders.size() - 1);
		return pathTempList;
	}

	// GET PATH BY ARRAY
	private static String getPath(String[] arr, int startIndex) {// if folder is 'temp list' => split temp and list =>
																	// we will reconvert
		String pathTempList = "";
		for (int i = startIndex; i < arr.length - 1; i++) {// get path tempList
			pathTempList += arr[i] + " ";
		}
		pathTempList += arr[(arr.length - 1)];
		return pathTempList;
	}

	public static void main(String[] args) {
		new File("C:\\temp_cmd").mkdir();

		linkedFolders.add("C:");
		linkedFolders.add("temp_cmd");

		Scanner sc = new Scanner(System.in);
		String command = "";
		do {
			printlinkFolder(linkedFolders);
			command = sc.nextLine();
			processCommand(command);
			System.out.println();
		} while (!command.equalsIgnoreCase("exit"));
	}
}
