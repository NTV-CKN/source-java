//tinh trung binh tong cac so 
public class BT1 {
	public static <T extends Number> double tinhTBC(T[] arr) {
		double save = 0;
		for (int i = 0; i < arr.length; i++) {
			save += Double.valueOf(arr[i] + "") ;
		}
		return (save/arr.length);
	}
	public static void main(String[] args) {
		Integer[] arr = {1,2,3,4,5};
		System.out.println(tinhTBC(arr));
	}
}
