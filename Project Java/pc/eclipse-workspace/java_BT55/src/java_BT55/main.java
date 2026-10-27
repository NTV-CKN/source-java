package java_BT55;

import java.util.Arrays;

import java_BT55.SnhVien;
public class main {
public static void swap(int[] v) {
	int j, i;
	for ( i = 0, j = v.length -1; i < v.length && j >= 0; i++, j--) {
		int temp = v[i];
		v[i] = v[j];
		v[j] = temp;
	} 
}


public static void main(String[] args) {
	int[] v1 = new int[] {2, 1, 7, 4, 3};
	int[] v2 = new int[15];
	

	//ham sort
	System.out.println("mang v1 ban dau: ");  
	 Arrays.sort(v1);
	System.out.println("mang v1 sau khi sort: " +Arrays.toString(v1));
	
	//Ham binarySearch
	System.out.println("so 7 nam o phan tu thu: " +Arrays.binarySearch(v1, 7));
	
	//Ham dao mang
	System.out.println("dao mang:");
	main.swap(v1);
	System.out.println(Arrays.toString(v1));
	
	//ham fill
	Arrays.fill(v2, 6);
	System.out.println(Arrays.toString(v2));
	
	//sap xep mang doi tuong theo hooVaTen
	SnhVien sv1 = new SnhVien(100, "Nguyen Truong Thien", 9.1);
	SnhVien sv2 = new SnhVien(179, "Nguyen Hoang An", 9.2);
	
	SnhVien [] a = new SnhVien[] {sv1, sv2};//giong mang 2 chieu, a se chua 2 phan tu sv1 sv2 va trong sv 1 2 lai chua 3 phan tu la maSV hoVaTen diemTB
	sv1.compareTo(sv2);
	System.out.println("mang a: "+a.toString());
	System.out.println("Thang Thien o phan tu thu may trong doi tuong sv1 khong "+Arrays.binarySearch(a, sv1) );
}
}
