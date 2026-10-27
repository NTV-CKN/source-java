package java_BT71;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class main {
public static void main(String[] args) {
	try {
		PrintWriter pw = new PrintWriter("D:\\Project Java\\pc\\eclipse-workspace\\java_BT71\\fileTest.txt", "UTF-8");
		pw.println("Hello cac ban, minh yeu cac ban");
		pw.print(3000);
		pw.println('>');
		pw.append('3');
		pw.print("lakak");
		pw.flush();
		pw.close();
	} catch (FileNotFoundException | UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
