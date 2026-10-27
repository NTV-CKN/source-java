package java_BT40;

public class test {
public static void main(String[] args) {
	//single
	Dog dg = new Dog("dog");

	dg.getName();
	dg.eat();
	dg.bark();
	System.out.println("-----=-----");
	//multilevel
	BabyDog bbd = new BabyDog();
	
	bbd.getName();
	bbd.eat();
	bbd.weep();
	System.out.println("-----=-----");

	//Nhieu thang
	Cat c = new Cat("cat");
	
	c.eat();
	c.meow();
	
	Dog dg1 = new Dog("dog");
	
	dg1.bark();
	dg1.eat();
}
}
