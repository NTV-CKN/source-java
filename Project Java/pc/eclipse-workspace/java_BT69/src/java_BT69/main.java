package java_BT69;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class main {
	static void deQuy(File f) {
		f.deleteOnExit();
		if(f.isDirectory() && f.canRead()) {
			File[] arr = f.listFiles();
			for (File file : arr) {
				deQuy(file);
			}
		}
	}
public static void main(String[] args) throws IOException {
	//thu muc co chua
	File test1 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT69\\test1");
    //thu muc rong
	File test2 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT69\\test2");
	//file
	File test3 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT69\\test4.txt");
System.out.println(test3.exists());
	//main.deQuy(test3);
Path p = test3.toPath();
Files.delete(p);
}
}
