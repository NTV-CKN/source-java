package java_BT50;

import java.util.Scanner;

public class MAIN {
public static void main(String[] args) {
	//Ham compareTo
	System.out.println("Ham compareTo: ");
	Scanner vc = new Scanner(System.in);
String [] vuxx = new String[5];
String bienNho = "";

for(int i = 0; i<vuxx.length; i++) {

	thongTin vcc = new thongTin(null);
	if( vcc.hoVaTen == null) {
		System.out.println("Nhap: ");
		vcc.hoVaTen = vc.nextLine();
		 vuxx[i] = vcc.hoVaTen; 
		
	}
}
for (int i = 0; i < vuxx.length-1; i++) {
	for(int j = i + 1; j<vuxx.length; j++) {
		System.out.println("so sanh phan tu "+i+"va phan tu "+j+" la "+vuxx[i].compareTo(vuxx[j]));
	}
}
//regionMatches
System.out.println("Ham regionMatches:");

String vu1 = "h0186 307 0026";
String vu2 = "H0185 309 1212";
String vu3 = "taolaymay.jpg";

System.out.println(vu1.regionMatches(true, 0, vu2, 0, 5));
System.out.println(vu1.regionMatches(0, vu2, 0, 5));
//starsWith
System.out.println("startsWith: ");
System.out.println(vu1.startsWith("h0186"));
System.out.println(vu1.startsWith("309"));
//endsWith
System.out.println("endsWith: ");
if (vu3.endsWith("JPG") || vu3.endsWith("jpg")) {
	System.out.println("day la hinh anh");
}else {
	System.out.println("cai what do phac");
}
//charAt()
System.out.println("Ham charAt");
System.out.println(vu1.charAt(4));
//getChar()
System.out.println("getChars: ");
char[] cc = new char[6];
vu1.getChars(0, 5,cc , 0);
for(char x : cc) {
	System.out.print(x+"  ");
}

}
}
