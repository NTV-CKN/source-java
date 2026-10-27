package java_BT65;

import java.util.Scanner;

public class main {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	Map map = new Map();
	int luaChon = 0;

	do {
	try {
	   do {
		
			System.out.println("MOI CHON\nPRESS 1 TO ADD WORD\nPRESS 2 TO REMOVE WORD\nPRESS 3 TO SEARCH\nPRESS 4 TO PRINT LIST KEYS\nPRESS 5 TO PRINT LIST VALUES\nPRESS 6 TO TAKE SIZE OF MAP\nPRESS 7 TO CLEAR\nPRESS 8 TO OUT");
	        luaChon = sc.nextInt();
	        sc.nextLine();
	        if(luaChon == 1) {
	        	String k, v;
	        	System.out.println("Nhap tu ");k = sc.nextLine();
	        	 System.out.println("Nhap nghia "); v = sc.nextLine();
	        	map.themTu(k, v);
	        }if(luaChon == 2) {
	        	System.out.println("Nhap tu muon xoa");
	        	String k = sc.nextLine();
	        	map.xoaTu(k);
	        }if(luaChon == 3) {
	        	System.out.println("Nhap tu muon kiem");
	        	String k = sc.nextLine();
	        	System.out.println("Nghia cua tu la: "+map.traTu(k)); 
	        }if(luaChon == 4) {
	        	map.inDSKey();
	        }if (luaChon == 5) {
				map.inDSValue();
			}if(luaChon == 6) {
				System.out.println(map.inSoLuong());
			}if(luaChon == 7) {
				map.xoaAll();
			}
			} while (luaChon != 8);
	}catch (Exception e) {
             System.out.println("Khong hop le!\nNhap lai 1 so bat ki\n");
             sc.nextLine();
			}    luaChon = sc.nextInt();
	}while(luaChon != 8);
}
}
