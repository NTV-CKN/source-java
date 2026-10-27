package java_BT43;

public class overload {
public int timMin (int a, int b) {
if (a > b) {
	return a;
}else {
	return b;
}
}
public double timMin (double a, double b) {
	if (a > b) {
		return b;
	}else {
		return a;
	}
}
public double tinhTong(double a,  double b) {
	return a+b;
}
public int tinhTong(int a, int b ) {
	return a+b;
}
public double tinhTong(double[] arr) {
	int tong = 0;
    for (int i = 0; i < arr.length; i++) {
	tong+=arr[i];	
	}return tong;

}
public int tinhTong(int[] arr) {
	int tong = 0;
   vu: for (int i = 1; i <= arr.length; i++) {
        tong+=i;
   }return tong;
}

}
