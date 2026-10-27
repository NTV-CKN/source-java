package bai_1.cau1;

public class Test {
	public static void main(String[] args) {
		Factory factory = new Factory();

		System.out.println(factory.createShape().draw());
		System.out.println(factory.createShape().draw());
		System.out.println(factory.createShape().draw());
	}
}
