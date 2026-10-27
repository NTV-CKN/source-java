package java_BT70;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class main {
	
	static void copyAll(File f1, File f2) {
		try {
			Files.copy(f1.toPath(), f2.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(f1.canRead() && f1.isDirectory()) {
			
			File[] arr = f1.listFiles();
			for (File fx : arr) {
				File f2_new = new File(f2.getAbsolutePath()+"\\"+fx.getName());
				copyAll(fx, f2_new);
				}
			
		}
	}
	
public static void main(String[] args) {
	
	File f0 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT70\\hello1.txt");
	File f1 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT70\\hello2.txt");
	
	File f2 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT70\\hello3\\hello2.txt");
	File f3 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT70\\hello2.txt");
	
	File f4 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT70\\hello4\\hello3");
	File f5 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT70\\hello3");
	File f6 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT70\\hello333");
	File f7 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT70\\hellocm2");
	//doi ten
	//f6.delete();
	f0.renameTo(f1);
	// di chuyen
	f3.renameTo(f2);
	f5.renameTo(f4);
	
	//copy
	File f10 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT70\\hello4");
	File f11 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT70\\hello5");

	main.copyAll(f10, f11);

	
//	try {
//		Files.copy(f7.toPath(), f6.toPath(), StandardCopyOption.REPLACE_EXISTING);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	
}

}
