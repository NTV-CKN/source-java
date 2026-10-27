package Ex_5_8;
/**
 * trong Inventory co 4 phuong thuc abstract:
-boolean contains(String name)
-boolean isBelow(double priceThat)
-int howMany()
-Toy priceRaise(double rate)
dung de dinh nghia cho cac lop extends lai no

vidu 
Inventory ds1 = new Empty();
Inventory ds2 = new Cons(new Toy("Gotchard Driver", 12000, 2), new Cons(new Toy("DonBlaster", 13000, 5), new Cons(new Toy("Zenkaiger", 15000, 2), new Cons(new Toy("Baguri", 11000, 2), new Empty()))));

//contains
	System.out.println(ds1.contains("Gotchard Driver"));=>false
	System.out.println(ds2.contains("Baguri"));==>true
	//isBelow
	System.out.println(ds2.isBelow(200000));=>true
	System.out.println(ds2.isBelow(123));=>false
	System.out.println(ds2.isBelow(13000));=>false
	//howMany
	System.out.println(ds1.howMany());=>0
	System.out.println(ds2.howMany());=>4
	//priceRaise
	System.out.println(ds2);//ban dau
	System.out.println(ds2.priceRaise(0.05));//sau khi rate
 */
public abstract class Inventory {
	public abstract boolean contains(String name);
	public abstract boolean isBelow(double priceThat);
	public abstract int howMany();
	public abstract Inventory priceRaise(double rate);
	public abstract double averagePrice();
	public abstract void replaceName(Inventory list);
	public abstract Inventory eliminate(String toyOfName);
}
