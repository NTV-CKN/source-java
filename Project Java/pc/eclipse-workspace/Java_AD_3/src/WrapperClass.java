
public class WrapperClass {
	public static void main(String[] args) {
		@SuppressWarnings("removal")
		Integer x3 = new Integer(5);
		Integer x1 = 5;
		int x2 = 5;
		System.out.println(x3-x2);
		System.out.println(x3==x1);
		System.out.println(x1==x2);
	
	}
}
