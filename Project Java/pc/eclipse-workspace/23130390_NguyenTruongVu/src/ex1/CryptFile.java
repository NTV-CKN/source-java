package ex1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;

public class CryptFile {
	private static String readFile(String pathName) throws FileNotFoundException {
		char[] buffer = new char[1024];
		StringWriter writer = new StringWriter();
		File file = new File(pathName);
		InputStream inputT = new FileInputStream(file);
		try (InputStream input = new BufferedInputStream(inputT)) {
			int size;
			Reader reader = new InputStreamReader(input);
			while ((size = reader.read(buffer)) != -1) {
				writer.write(buffer, 0, size);
			}
		} catch (IOException ignore) {
		}
		return writer.toString();
	}

	public static boolean encryptFile(String pathNameFrom, String pathNameTo, int step, boolean flag) throws FileNotFoundException {
		String data = readFile(pathNameFrom);
		if(flag) {
			data = Ex1.encrypt(step, data);
		}else {
			data= Ex1.decrypt(step, data);
		}
		try (BufferedOutputStream bufferedStream = new BufferedOutputStream(new FileOutputStream(pathNameTo))) {
			bufferedStream.write(data.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
