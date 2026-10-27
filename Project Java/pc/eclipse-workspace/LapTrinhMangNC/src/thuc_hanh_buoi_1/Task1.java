package thuc_hanh_buoi_1;

import java.io.File;

public class Task1 {
	public static boolean deleteByPath(String path) {
		File file = new File(path);
		if (file.exists()) {// check permission
			return processDeleteByPath(file);
		}
		return false;
	}

	public void findAllByExts(String path, String[] exts) {
		File xxx = new File(path);
		if(!xxx.exists()) return;
		if (xxx.isFile()) {
			for (String ext : exts) {
				if (xxx.getName().endsWith(ext)) {
					System.out.println(xxx.getAbsolutePath());
					return;
				}
			}
		}
		if (xxx.isDirectory()) {
			File[] subXxx = xxx.listFiles();
			if (subXxx != null)
				for (File temp : subXxx) {
					findAllByExts(temp.getAbsolutePath(), exts);
				}
		}
	}

	private static boolean processDeleteByPath(File file) {// van co truong hop path k phai la file, folder van ton tai|folder can read
		if(!file.exists()) return true;
		if (file.isFile())
			return file.delete();
		File[] files = file.listFiles();
		if (files == null)
			return false;
		boolean flag = true;
		for (File temp : files)
			flag = flag && processDeleteByPath(temp);

		return flag && file.delete();
	}

	public static void main(String[] args) {
		Task1 task1 = new Task1();
		System.out.println(task1.deleteByPath("ownloads\\ltmnc - Copy"));

		File file = new File("abc\\:!@#@.");
		System.out.println(file.delete());
		
		task1.findAllByExts("C:\\Users\\pc\\Downloads\\ltmnc test - task2", new String[]{".txt", ".docx"});
	}
}
