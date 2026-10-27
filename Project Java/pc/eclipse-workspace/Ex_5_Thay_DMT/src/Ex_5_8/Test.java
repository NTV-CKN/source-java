package Ex_5_8;

public class Test {
public static void main(String[] args) {
	
	Inventory ds1 = new Empty();
	Inventory ds2 = new Cons(new Toy("Robot", 12000, 2), new Cons(new Toy("DonBlaster", 13000, 5), new Cons(new Toy("Robot", 15000, 2), new Cons(new Toy("Baguri", 11000, 2), new Empty()))));
	//contains
	System.out.println(ds1.contains("Gotchard Driver"));
	System.out.println(ds2.contains("Baguri"));
	System.out.println("=================");
	//isBelow
	System.out.println(ds2.isBelow(200000));
	System.out.println(ds2.isBelow(123));
	System.out.println(ds2.isBelow(13000));
	System.out.println("===================");
	//howMany
	System.out.println(ds1.howMany());
	System.out.println(ds2.howMany());
	System.out.println("===================");
	//averagePrice
	System.out.println("Average= "+ds2.averagePrice());//truoc khi rate
	System.out.println("===================");
	//priceRaise
	System.out.println(ds2);//ban dau
	System.out.println("====================");
	System.out.println(ds2.priceRaise(0.05));//sau khi rate
	System.out.println("===================");
	//averagePrice
	System.out.println("Average= "+ds2.averagePrice());//sau khi rate
	System.out.println("===================");
	//eliminate
	System.out.println(ds2.eliminate("Robot"));
	System.out.println("===================");
	
	//replacement
	ds2.replaceName(ds2);
	System.out.println(ds2);//sau khi replace
}
}
