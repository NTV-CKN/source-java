package java_BT66;

public class main {
public static void main(String[] args) {
	Box<String> v = new Box<String>("kaka");
	System.out.println(v.getValue());
	
	Box<Integer> v1 = new Box<Integer>(7);
	System.out.println(v1.getValue());
}
}
