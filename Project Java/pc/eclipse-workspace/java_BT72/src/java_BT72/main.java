package java_BT72;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class main {
public static void main(String[] args) {
	//Tao va ghi file\
	File f1 = new File("D:\\Project Java\\pc\\eclipse-workspace\\java_BT72\\test1.txt");

	
	try {
		f1.createNewFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		try {
		PrintWriter pw = new PrintWriter(f1);
		pw.println("Day la nguyen truong vu");
		pw.println(18);
		pw.println("Doc Than");
		pw.flush();
		pw.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 //Doc file bang BufferedReader
		System.out.println("Doc bang BufferedReader");
		try {
			BufferedReader br = Files.newBufferedReader(f1.toPath(), StandardCharsets.UTF_8);
	     
			while (true) {
			  String h = br.readLine();
			if(h == null) {
				break;
			}else {
				System.out.println(h);
			}
	        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Doc bang Files: Stream va List\n");
		System.out.println("List\n");
		try {
			List<String> f2 = Files.readAllLines(f1.toPath(), StandardCharsets.UTF_8);
			for (String string : f2) {
				System.out.println(string);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Stream\n");
		try {
			String f4;
			Stream<String> f3 = Files.lines(f1.toPath(), StandardCharsets.UTF_8);
			f3.forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
}
