package java_BT43;

public class main {
public static void main(String[] args) {
	overload o = new overload();
	System.out.println("tim min " +o.timMin(6, 7));
	System.out.println("tim min "+o.timMin(6.5, 2.1));
	System.out.println("=========================");
	System.out.println("tinh tong= "+o.tinhTong(3, 2));
	int[] arr2 = new int[4];
	System.out.println(o.tinhTong(arr2));
	double[] arr = new double[] {4, 5, 3, 2};
	System.out.println("tinh tong mang= "+o.tinhTong(arr));
}
}
