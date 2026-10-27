package relearn_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task {
	public static void split(String src, long pSize) throws IOException {
		File file = new File(src);
		FileInputStream fis = new FileInputStream(file);
		long lenFile = file.length();
		int partFiles = (int) (lenFile / pSize);
		int remainder = (int) (lenFile % pSize);
		int i = 0;
		for (i = 0; i < partFiles; i++) {
			copy(fis, getExts(i+1, src), pSize);
		}
		if(remainder != 0) copy(fis, getExts(i+1, src), remainder);
	}

	public static void join(String partFile) throws IOException {
		File part = new File(partFile);
		if(!part.exists()) return;
		String source = partFile.substring(0, partFile.lastIndexOf("."));
		FileOutputStream fos = new FileOutputStream(source);
		int i = 1;
		while(true) {
			String ext = getExts(i, source);
			File pFile = new File(ext);
			if(!pFile.exists()) break;
			FileInputStream fis = new FileInputStream(pFile);
			//Doc du lieu
			long counter = pFile.length();
			byte[] buff = new byte[102400];
			int byteMustRead;
			while(counter > 0) {
				byteMustRead =(int) (counter > buff.length?buff.length:counter);
				int byteReaded = fis.read(buff, 0, byteMustRead);
				counter -= byteReaded;
				fos.write(buff, 0, byteReaded);
			}
			fis.close();
			i++;
		}
		fos.close();
	}
	
	private static void copy(FileInputStream fis, String pName, long pSize) throws IOException {
		FileOutputStream fos = new FileOutputStream(pName);
		byte[] buff = new byte[102400];
		int byteMustRead;
		long counter = pSize;
		while(counter > 0) {
			byteMustRead =(int) (counter > buff.length?buff.length:counter);
			int byteReaded = fis.read(buff, 0, byteMustRead);
			counter -= byteReaded;
			fos.write(buff, 0, byteReaded);
		}
		fos.close();
	}

	private static String getExts(int index, String source) {
		if (index < 10)
			return source + ".00" + index;
		if (index < 100)
			return source + ".0" + index;
		return source + "." + index;
	}
	public static void main(String[] args) throws IOException {
		//Task.split("C:\\Users\\pc\\Downloads\\Newfolder\\copy.pdf", 100000);
		Task.join("C:\\Users\\pc\\Downloads\\Newfolder\\copy.pdf.022");
	}
}
