package java_BT54;

public class main {
public static void main(String[] args) {
	SnhVien sv1 = new SnhVien(100, "Nguyen Truong An", 9.1);
	SnhVien sv2 = new SnhVien(179, "Nguyen Hoang Yen", 5.1);

	System.out.println(sv1.compareTo(sv2));
}
}
