package java_BT67;

import java.io.File;
import java.io.IOException;

public class main {
public static void main(String[] args) {
	File v1 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT67");
	File v2 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT68");
	
	//check exists
	System.out.println(v1.exists());
	System.out.println(v2.exists());
	//create folder
	File v3 = new File("D:\\Excel\\Test 3 Excel");
	v3.mkdir();
	File v4 = new File("D:\\Excel\\Test 4 Excel\\Test1\\Test2");
	v4.mkdirs();
	//create file
	File v5 = new File("D:\\Excel\\Test 3 Excel\\write.xls");
	try {
		v5.createNewFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	File v6 = new File("D:\\Excel\\Test 4 Excel\\write1.xlsx");
	try {
		v6.createNewFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
