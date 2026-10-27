package thuc_hanh_buoi_1;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Task3 {
	public static void dirTree(String folder) {
		File folderT = new File(folder);
		if (!folderT.exists())
			return;
		if (folderT.isFile())
			System.out.println(folderT.getName().toLowerCase());
		LinkedHashMap<String, String> hmap = new LinkedHashMap<String, String>();
		processDirTree(folder, 0, hmap);
		for(Map.Entry<String, String> entry: hmap.entrySet()) {
			System.out.println(entry.getValue());
		}
	}
	private static long processDirTree(String path, int level, LinkedHashMap<String, String> hmap) {
		String value = (level-1>0?"  |  ".repeat(level-1):"") + (level>0?"  +-":"") ;
		long total = 0;
		File xxx = new File(path);
		if(xxx.isFile()) {
			hmap.put(xxx.getAbsolutePath(), value + xxx.getName().toLowerCase());
			return xxx.length();
		}
		hmap.put(xxx.getAbsolutePath(), value + xxx.getName().toUpperCase()+":"+total);
		File[] arrFile = xxx.listFiles();
		if(arrFile == null) return 0;
		for (File folder: arrFile) {
			if(folder.isDirectory()) {
				total += processDirTree(folder.getAbsolutePath(), level+1, hmap);
			}
		}
		for (File file: arrFile) {
			if(file.isFile()) {
				total += processDirTree(file.getAbsolutePath(), level+1, hmap);
			}
		}
		hmap.put(xxx.getAbsolutePath(), value + xxx.getName().toUpperCase()+":"+total);
		return total;
	}

	public static void main(String[] args) {
		dirTree("C:\\Users\\pc\\Downloads\\Lesson 18.30");
	}
}
