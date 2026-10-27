package java_BT76;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipMutipleFiles {
public static void main(String[] args) {
	try {
		//File file = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT76\\test1.txt", "D:\\Project Java\\pc\\eclipse-workspace\\java_BT76\\test2.txt");
		List<String> file = Arrays.asList("D:\\Project Java\\pc\\eclipse-workspace\\java_BT76\\test1.txt", "D:\\Project Java\\pc\\eclipse-workspace\\java_BT76\\test2.txt");
	
	FileOutputStream fos = new FileOutputStream("D:\\Project Java\\pc\\eclipse-workspace\\java_BT76\\nen.zip");
	ZipOutputStream zipOut = new ZipOutputStream(fos);
	
	for (String fx : file) {
		File f = new File(fx);

		FileInputStream fis = new FileInputStream(f);
		ZipEntry zipe = new ZipEntry(f.getName());
		zipOut.putNextEntry(zipe);
		
		byte[] bytes = new byte[1024];
		int length;
		while((length = fis.read(bytes)) >= 0) {
			zipOut.write(bytes, 0, length);
		} fis.close();
	}    zipOut.close();fos.close(); 
	}catch(Exception e) {
	e.printStackTrace();
}
}
}
