package java_BT54b;

import java_BT54b.SnhVien;

public class main {
public static void main(String[] args) {
	SnhVien sv1 = new SnhVien(100, "Nguyen Truong An", 9.1);
	SnhVien sv2 = new SnhVien(179, "Nguyen Hoang Yen", 9.2);
	
	System.out.println(sv1.compareTo(sv2));
}
}
