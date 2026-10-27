package java_BT76;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFile {
public static void main(String[] args) throws IOException {
	
	try {
		File f = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT76\\file.txt");
		FileOutputStream fos = new FileOutputStream("D:\\Project Java\\pc\\eclipse-workspace\\java_BT76\\nen.zip");
		ZipOutputStream zipOut = new ZipOutputStream(fos);
		
		FileInputStream fis = new FileInputStream(f);
		ZipEntry zipe = new ZipEntry(f.getName());
		zipOut.putNextEntry(zipe);
		byte[] bytes = new byte[1024];
		 int length;
		 while((length = fis.read(bytes)) >= 0) {
			 zipOut.write(bytes, 0, length);
		 }fis.close();
		
		zipOut.close();fos.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}

}
