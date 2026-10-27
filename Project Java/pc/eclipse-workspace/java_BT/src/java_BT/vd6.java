package java_BT;

import java.util.Arrays;
import java.util.Scanner;  
public class vd6 {
	public static void main(String[] args) {
		Scanner vu = new Scanner(System.in);
		System.out.println("nhap vao kich thuoc mang: ");
		int n = vu.nextInt();
		int[] vux = new int[n];
		for (int v = 0; v < vux.length; v++) {
			System.out.println("nhap gia tri phan tu= ");
			int c = vu.nextInt();
			vux[v] = c;
		}
		Arrays.sort(vux);
		System.out.println(Arrays.toString(vux));
		int i, j;
		for( i = 0, j = vux.length -1 ;i<j; i++, j--) {
			int template = vux[i];
		    vux[i] = vux[j];
		    vux[j] = template;
		}System.out.println("dao mang: "+Arrays.toString(vux));
	}
}

