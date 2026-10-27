package java_BT51;

public class main {
public static void main(String[] args) {
	String vu1 = "d hello anh em nha";
	String vu2 = "kaka meow hello cac ban hello ";
	String vu3 = "cac ban hello";
	String vu4 ="hello hello hello hello";
	//ham indexOf
	//case1
	System.out.println(vu1.indexOf("anh em "));
	System.out.println(vu1.indexOf(vu3));
	//case2
	System.out.println(vu1.indexOf("anh em", 6));
	System.out.println();
	//case3
	char c = 'm';
	System.out.println(vu1.indexOf(c));
	System.out.println(vu1.indexOf(c, 12));
	System.out.println(vu1.indexOf('m'));
	//lastIndexOf
	System.out.println("===");
	System.out.println(vu1.lastIndexOf('h'));
	System.out.println(vu1.lastIndexOf('h', 1));
	System.out.println(vu1.lastIndexOf("anh"));
	System.out.println(vu2.lastIndexOf("hello", 23));
	
	System.out.println(vu4.lastIndexOf('e', 7));
	System.out.println(vu4.lastIndexOf("hello", 7));
}
}
