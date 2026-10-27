package bis_bos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task {
	public static boolean fileCopy(String fileSrc, String fileDest, boolean isMove) throws IOException {
		File src = new File(fileSrc);
		FileInputStream fis = new FileInputStream(src);
		FileOutputStream fos = new FileOutputStream(fileDest);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		// Mo file src
		try {
			long counter = src.length();
			int byteMustRead;
			byte[] buff = new byte[102400];
			while (counter > 0) {
				byteMustRead = (int) (counter > buff.length ? buff.length : counter);
				int byteReaded = bis.read(buff, 0, byteMustRead);
				counter -= byteReaded;
				bos.write(buff, 0, byteReaded);
			}
		} catch (Exception e) {
			return false;
		}
		bos.close();
		bis.close();
		fis.close();
		fos.close();
		// check isMove
		return isMove ? src.delete() : true;
	}

	public static boolean folderCopy(String sFolder, String destFolder, boolean moved) throws IOException {
		File srcFolder = new File(sFolder);
		File destFol = new File(destFolder);
		File[] lstSrc = srcFolder.listFiles();
		boolean isCompleted = true;
		if (!destFol.exists())
			isCompleted = destFol.mkdir();

		// Xu li file
		for (File file : lstSrc) {
			if (file.isFile()) {
				isCompleted = isCompleted && fileCopy(file.getAbsolutePath(), destFolder + "\\" + file.getName(), moved);
			}
		}
		// Xu li folder
		for (File folder : lstSrc) {
			if (folder.isDirectory()) {
				isCompleted = isCompleted
						&& folderCopy(folder.getAbsolutePath(), destFolder + "\\" + folder.getName(), moved) && moved
								? folder.delete()
								: true;
			}
		}
		boolean res =  isCompleted && moved?srcFolder.delete():true;
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) throws IOException {
//		System.out.println(
//				Task.fileCopy("C:\\Users\\pc\\Downloads\\test.txt", "C:\\Users\\pc\\Downloads\\test1.txt", true));
//		;
		System.out.println(Task.folderCopy("C:\\Users\\pc\\Downloads\\Newfolder - Copy",
				"C:\\Users\\pc\\Downloads\\Newfolder - Copy1", true));
	}
}
