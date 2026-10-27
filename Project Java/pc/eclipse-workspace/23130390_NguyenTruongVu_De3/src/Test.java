
public class Test {
public static void main(String[] args) {
	Product pd1 = new Product(1, "Robot", 2);
	Product pd2= new Product(2, "Zio", 2);
	Product pd3 = new Product(3, "Robot", 5);
	Product pd4 = new Product(4, "Geats", 10);
	
	Date date = new Date(1, 0, 0);
	
	IItem ds1 = new ConsIItem(pd1, new ConsIItem(pd2, new ConsIItem(pd3, new ConsIItem(pd4, new MTIItem()))));
	IItem ds2 = new ConsIItem(pd4, new ConsIItem(pd3, new MTIItem()));
	
	Staff st1 = new Staff(1, "Vu Mo Hon", "Hoi lam gi", date, 12, 12, "An hai dai khai");
	
	SaleStaff sST1 = new SaleStaff(2, "Vy ne", "Nhon Trach", date, 1, 2, ds1);
	SaleStaff sST2 = new SaleStaff(3, "Khai ne ", "Phu Trach", date, 1, 1, ds2);
	
	IListE ds = new ConsE(sST1, new ConsE(st1, new ConsE(sST2, new MTE())));
	
	System.out.println("======================");
	System.out.println(sST2.salary());
	System.out.println(sST1.salary());
	System.out.println("======================");
	System.out.println(sST1.isProduct(pd2));
	System.out.println(sST2.isProduct(pd2));
	System.out.println("======================");
	System.out.println(ds.howManyE());
	System.out.println("======================");
	System.out.println(ds.getSalers(pd1));
	System.out.println("======================");
	System.out.println(ds.getSalers(pd4));
	System.out.println("======================");
	System.out.println("Trc: "+ds1);
	
	System.out.println("\n sau "+ds1.sortByTitle());
	System.out.println("======================");
	System.out.println(ds2.pL(2));
	System.out.println("======================");
	System.out.println(ds1.pL(2));
	System.out.println("======================");
	System.out.println(ds1.reName());
	
}
}
