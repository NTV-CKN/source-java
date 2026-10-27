package java_BT;

import java.io.File;

public class vd13 {
public static void main(String[] args) {
	File f10 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT70");
	System.out.println(f10.getAbsolutePath());
	String h = f10.getAbsolutePath();
	File f11 = new File("h");
	System.out.println(f11);
	File[] arr = f10.listFiles();
	for (File file : arr) {
		System.out.println(file);
	}

}
}
