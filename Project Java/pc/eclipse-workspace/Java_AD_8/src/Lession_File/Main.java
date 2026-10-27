package Lession_File;

import java.io.File;
import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int choose = 0;
	try {
		do {
			System.out.println("PRESS 1 TO WRITE A FILE\nPRESS 2 TO READ A FILE\n"
		+ "PRESS 3 TO ZIP A FILE\nPRESS 4 TO UNZIP A FILE\nPRESS 5 TO COPY FILE\n"
		+ "PRESS 6 TO DELETE FILE");
			choose = sc.nextInt();sc.nextLine();
			if(choose == 1) {
				System.out.println("Nhap noi dung muon ghi: ");
				String str = sc.nextLine();
				Method.writeFile(str);
			}else if(choose == 2) {
				Method.readFile();
			}else if(choose == 6) {
				File f = new File("D:\\File");
				Method.deleteFile(f);
			}else if(choose == 3) {
				File f = new File("D:\\File\\text1.txt");
				File fileZip = new File("D:\\File\\file.zip");
				Method.newZip(f, fileZip);
			}else if(choose == 4) {
				File file1 = new File("D:\\File\\text1.txt");
				File file2 = new File("D:\\File\\ef.txt");
				File file3 = new File("D:\\File\\helo.txt");
				Method.zipMultiFiles(file1, file2, file3);
				
			}
		} while (choose>=1 &&choose<=6);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
