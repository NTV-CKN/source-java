package java_BT76;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDirectory {
public static void main(String[] args) throws IOException {
	try {
		FileOutputStream fos = new FileOutputStream("D:\\Project Java\\pc\\eclipse-workspace\\java_BT76\\nen3.zip");
		ZipOutputStream zipOut = new ZipOutputStream(fos);
		File fileToZip = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT76\\dir");
		
		
		zipFile(fileToZip, fileToZip.getName(), zipOut);
		zipOut.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
private static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
	if(fileToZip.isHidden()) {
		return;
	}
	if(fileToZip.isDirectory()) {
		if(fileName.endsWith("\\")) {
			zipOut.putNextEntry(new ZipEntry(fileName));
			zipOut.closeEntry();
		}else {
			zipOut.putNextEntry(new ZipEntry(fileName+"\\") );
			zipOut.closeEntry();
		}
	File[] arr = fileToZip.listFiles();
	for (File file: arr) {
     zipFile(file, fileName +"\\"+ file.getName(), zipOut);
	}
	return;
}
	FileInputStream fis = new FileInputStream(fileToZip);
	ZipEntry zipe = new ZipEntry(fileToZip.getName());
	zipOut.putNextEntry(zipe);
	
	byte[] bytes = new byte[1024];
	int length;
	while((length = fis.read(bytes)) >= 0) {
		zipOut.write(bytes, 0, length);
	}fis.close();
}
}
