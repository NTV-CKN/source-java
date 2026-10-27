package java_BT53;

import java.util.Arrays;

public class mang_1_chieu {
public static void main(String[] args) {
	int[] v1 = {1, 3, 6};
	System.out.println("mang v1= " +Arrays.toString(v1));
	
	//sao chep gan
	int[] b;
	b = v1;
	b[1] = 5;
	System.out.println("mang b= " +Arrays.toString(b));

	//ham clone
	int[] c = v1.clone();
	System.out.println("mang c= "+Arrays.toString(c));
	
	//ham system.arraycopy()
	int [] d = new int[v1.length]; 
	System.arraycopy(v1, 0, d, 0, 2);
			System.out.println("mang d= "+Arrays.toString(d));

}
}
