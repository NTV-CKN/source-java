package java_BT56;

import java.util.Arrays;

public class main {
public static void main(String[] args) {
	String v1 = "Hello bon may, tao la, nguyen truong vu. Mot chiec dev bi tri!";
	
	String[] v2 = v1.split("\\,|\\.");
	System.out.println("Cach dau , va . : "+Arrays.toString(v2));
	String[] v3 = v1.split(",", 2);
	System.out.println("Gioi han 2 phan tu: "+Arrays.toString(v3));
}
}
