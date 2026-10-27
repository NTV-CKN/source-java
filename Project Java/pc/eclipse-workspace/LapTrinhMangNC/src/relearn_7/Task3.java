package relearn_7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task3 {
	public static void split(String src, long pSize) throws IOException {
		File file = new File(src);
		FileInputStream fis = new FileInputStream(file);
		long lenFile = file.length();
		long loop = lenFile / pSize;
		long remainder = lenFile % pSize;
		long i = 0;
		for (i = 0; i < loop; i++) {
			copy(fis, getExt(i + 1, src), pSize);
		}
		if (remainder != 0)
			copy(fis, getExt(i + 1, src), remainder);
		fis.close();
	}

	private static void copy(FileInputStream fis, String ext, long pSize) throws IOException {
		FileOutputStream fos = new FileOutputStream(ext);
		long counter = pSize;
		int byteMustRead;
		byte[] buff = new byte[102400];
		while (counter > 0) {
			byteMustRead = (int) (buff.length > counter ? counter : buff.length);
			int byteReaded = fis.read(buff, 0, byteMustRead);
			counter -= byteReaded;
			fos.write(buff, 0, byteReaded);
		}
		fos.close();
	}

	public static void join(String partFileName) throws IOException {
		File partFN = new File(partFileName);
		if (!partFN.exists())
			return;
		String source = partFileName.substring(0, partFileName.lastIndexOf("."));
		FileOutputStream fos = new FileOutputStream(source);
		long index = 1;
		while (true) {
			File part = new File(getExt(index++, source));
			if (!part.exists())
				break;
			FileInputStream fis = new FileInputStream(part);
			long counter = part.length();
			int byteMustRead;
			byte[] buff = new byte[102400];
			while (counter > 0) {
				byteMustRead = (int) (buff.length > counter ? counter : buff.length);
				int byteReaded = fis.read(buff, 0, byteMustRead);
				counter -= byteReaded;
				fos.write(buff, 0, byteReaded);
			}
			fis.close();
		}
		fos.close();
	}

	private static String getExt(long index, String path) {
		if (index < 10)
			return path + ".00" + index;
		if (index < 100)
			return path + ".0" + index;
		return path + "." + index;
	}
	public static void main(String[] args) throws IOException {
	//	split("C:\\Users\\pc\\Downloads\\doraemon_44.jpg", 100000);
		join("C:\\Users\\pc\\Downloads\\doraemon_44.jpg.001");
	}
}
