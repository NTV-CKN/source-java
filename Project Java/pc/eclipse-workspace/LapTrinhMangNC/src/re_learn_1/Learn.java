package re_learn_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class Learn {
	public static void split(String src, long pSize) throws IOException {
		File file = new File(src);
		if (!file.exists() || file.isDirectory())
			return;
		long sizeFile = file.length();
		int numLoop = (int) (sizeFile / pSize);
		int remainder = (int) (sizeFile % pSize);
		FileInputStream fis = new FileInputStream(file);
		int i;
		for (i = 1; i <= numLoop; i++) {
			copy(fis, getExtFile(i, src), pSize);
		}
		if (remainder != 0)
			copy(fis, getExtFile(i, src), remainder);
		fis.close();
	}

	private static void copy(FileInputStream fis, String dest, long pSize) throws IOException {
		FileOutputStream fos = new FileOutputStream(new File(dest));
		byte[] buff = new byte[102400];
		int byteMustRead;
		long counter = pSize;
		while (counter > 0) {
			byteMustRead = (int) (buff.length > counter ? counter : buff.length);
			int byteReaded = fis.read(buff, 0, byteMustRead);
			fos.write(buff, 0, byteReaded);
			counter -= byteReaded;
		}
		fos.close();
	}

	private static void copy(FileOutputStream fos, File src) throws IOException {
		FileInputStream fis = new FileInputStream(src);
		byte[] buff = new byte[102400];
		int byteMustRead;
		long counter = src.length();
		while (counter > 0) {
			byteMustRead = (int) (buff.length > counter ? counter : buff.length);
			int byteReaded = fis.read(buff, 0, byteMustRead);
			fos.write(buff, 0, byteReaded);
			counter -= byteReaded;
		}
		fis.close();
	}

	private static String getExtFile(int index, String source) {
		if (index < 10)
			return source + ".00" + index;
		if (index < 100)
			return source + ".0" + index;
		return source + "." + index;
	}

	public static void join(String partFileName) throws IOException {
		File file = new File(partFileName);
		if (!file.exists() || file.isDirectory())
			return;
		String src = partFileName.substring(0, partFileName.lastIndexOf("."));
		FileOutputStream fos = new FileOutputStream(new File(src));
		int index = 1;
		while (true) {
			File tmp = new File(getExtFile(index, src));
			if (!tmp.exists())
				break;
			copy(fos, tmp);
			index++;
		}
		fos.close();
	}

	public static void main(String[] args) throws IOException {
	//split("C:\\Users\\pc\\Downloads\\Newfolder\\DOC1.PNG", 20000);
join("C:\\Users\\pc\\Downloads\\Newfolder\\DOC1.PNG.005");
	}
}
