package Lession_Regex_7;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Array {
	static 	String array[] = null;

	//array-create
public static void array() {
	array = null;
	try {
	Scanner sc = new Scanner(System.in);
	System.out.println("Nhap size: ");
		 int size = sc.nextInt();
	int count = 0;	
	array = new String[size];
	int c12;
	do {
	System.out.println("================\nNhap 0 de xoa di mang co ten trung cho truoc\nNhap 1 de tao mang\nNhap 2 de hoan thanh\nNhap 3 de tim\nNhap 4 de tim ho\nNhap 5 de tim ten");
	c12 = sc.nextInt();
	sc.nextLine();
		if(c12 == 1) {
			System.out.println("Nhap ");
			String save = sc.nextLine();
			if(count < array.length) {
			array[count] = save;
			count++;
			}else {
				System.err.println("VUOT QUA KICH THUOC MANG - THOAT");
				count=0;
				break;
			}
		}else if(c12 == 3) {
			System.out.println("Nhap ki tu");
			String name = sc.nextLine();
			Pattern pt = Pattern.compile("^.*"+name+".*$");
			Matcher m ;
			for(int i = 0; i<Array.array.length; i++) {
				m = pt.matcher(Array.array[i]);
				if(m.find()) {
					System.out.println(Array.array[i]);
				}
			}
		}else if(c12 == 4) {
				System.out.println("Nhap ho");
				String name = sc.nextLine();
				Pattern pt = Pattern.compile("^"+name);
				Matcher m ;
				for(int i = 0; i<Array.array.length; i++) {
					m = pt.matcher(Array.array[i]);
					if(m.find()) {
						System.out.println(Array.array[i]);
					}
				}
		}else if(c12 == 5) {
					System.out.println("Nhap ten");
					String name = sc.nextLine();
					Pattern pt = Pattern.compile(name+"$");
					Matcher m ;
					for(int i = 0; i<Array.array.length; i++) {
						m = pt.matcher(Array.array[i]);
						if(m.find()) {
							System.out.println(Array.array[i]);
						}
					}
		}else if(c12 == 0) {
			System.out.println("Nhap ten can xoa");
			String name = sc.nextLine();
			Pattern pt = Pattern.compile("^.*"+name+".*$");
			Matcher m ;
			for(int i = 0; i<Array.array.length; i++) {
				m = pt.matcher(Array.array[i]);
				if(m.find()) {
					Array.array[i] = Array.array[i].replaceAll(Array.array[i], "");
				}
			}
		}
	} while (c12 != 2);
	} catch (Exception e) {
		System.err.println("LOI");
	}
}
	//search
	public static void searchArray(String name) {
		Pattern pt = Pattern.compile("^.*"+name+".*$");
		Matcher m ;
		for(int i = 0; i<Array.array.length; i++) {
			m = pt.matcher(Array.array[i]);
			if(m.find()) {
				System.out.println(Array.array[i]);
			}
		}
	}

}
