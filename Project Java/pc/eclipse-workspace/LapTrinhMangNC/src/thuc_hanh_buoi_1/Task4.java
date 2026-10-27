package thuc_hanh_buoi_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Task4 {
	public static void splitFile(String source, long pSize) throws IOException {
		File fileSource = new File(source);
		if (!fileSource.exists())
			return;
		long fileSize = fileSource.length();
		int loop = (int) (fileSize / pSize);
		long remain = fileSize % pSize;
		int i;
		FileInputStream fis = new FileInputStream(fileSource);
		for (i = 0; i < loop; i++) {
			copy(i, source, fis, pSize);
		}
		if (remain > 0) {
			FileOutputStream fos = new FileOutputStream(source + getExt(i + 1));
			int byteReaded = fis.read();
			while (byteReaded != -1) {
				fos.write(byteReaded);
				byteReaded = fis.read();
			}
			fos.close();
		}
		fis.close();
	}
	
	public static void join(String partFile) throws IOException {
		File partFileSrc = new File(partFile);
		if(!partFileSrc.exists()) return;
		String absolutePath = partFileSrc.getAbsolutePath();
		String subString = absolutePath.substring(0, absolutePath.lastIndexOf("."));
		File source = new File(subString);
		FileOutputStream fos = new FileOutputStream(source);
		int index = 0;
		while(true) {
			File partFileOfSource = new File(subString + getExt(++index));
			if(!partFileOfSource.exists()) break;
			FileInputStream fis = new FileInputStream(partFileOfSource);
			byte[] buffer = new byte[102400];
			long counter = partFileOfSource.length();
			int byteMustRead;
			while (counter > 0) {
				byteMustRead = (int) ((buffer.length < counter) ? buffer.length : counter);
				int byteReaded = fis.read(buffer, 0, byteMustRead);
				counter -= byteReaded;
				fos.write(buffer, 0, byteReaded);
			}
			fis.close();
		}
		System.out.println(index);
		fos.close();
	}

	private static void copy(int i, String source, FileInputStream fis, long pSize) throws IOException {
		FileOutputStream fos = new FileOutputStream(source + getExt(i + 1));
		byte[] buffer = new byte[102400];
		long counter = pSize;
		int byteMustRead;
		while (counter > 0) {
			byteMustRead = (int) ((buffer.length < counter) ? buffer.length : counter);
			int byteReaded = fis.read(buffer, 0, byteMustRead);
			counter -= byteReaded;
			fos.write(buffer, 0, byteReaded);
		}
		fos.close();
	}

	private static String getExt(int i) {
		return (i < 10) ? ".00" + i : (i < 100) ? ".0" + i : "." + i;
	}

	public static void main(String[] args) {
		try {
		//	splitFile("C:\\Users\\pc\\Downloads\\test\\split.png", 100000);
			join("C:\\Users\\pc\\Downloads\\test\\split.png.030");
			//splitFile("C:\\Users\\pc\\Downloads\\test\\test.txt", 100);
		//	join("C:\\Users\\pc\\Downloads\\test\\test.txt.001");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
}