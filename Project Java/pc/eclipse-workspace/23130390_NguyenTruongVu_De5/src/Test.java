
public class Test {
public static void main(String[] args) {
	Date date = new Date(12, 12, 2005);
	
	Product pD1 = new Product(1, 4, "Blaster", "Noi dia");
	Product pD2 = new Product(2, 2, "Ziku-Driver", "Noi dia");
	Product pD3 = new Product(3, 3, "Geats Mark 9", "Ngoai dia");
	Product pD4 = new Product(4, 4, "Khung long", "Noi dia");
	
	IProduct iP1 = new ConsIProduct(pD1, new ConsIProduct(pD3, new MTIProduct()));
	IProduct iP2 = new ConsIProduct(pD2, new ConsIProduct(pD4, new MTIProduct()));
	IProduct iP3 = new ConsIProduct(pD1, new ConsIProduct(pD2, new ConsIProduct(pD3, new ConsIProduct(pD4, new MTIProduct()))));
	
	Staff staff1 = new Staff(2, "Vu Dep Trai", "Nhon Trach", date, 12, 12, "Dong kho");
	Staff staff2 = new Staff(3, "Ngo Tuong Vy", "Vinh Cuu", date, 1212, 10000, "Khieng hang");
	
	SaleStaff sST1 = new SaleStaff(4, "Nguyen Truong Do", "Phu Yen", date, 1, 2, iP1);
	SaleStaff sST2 = new SaleStaff(5, "Lam Truong Do", "Phu Yen", date, 1, 2, iP2);
	SaleStaff sST3 = new SaleStaff(6, "Nguyen Thu Ha", "An Giang", date, 12, 2, iP3);
	
	IListE ds = new ConsIListE(staff1, new ConsIListE(staff2, new ConsIListE(sST1, new ConsIListE(sST2, new ConsIListE(sST3, new MTIListE())))));
	
	System.out.println("=======================");
	System.out.println("ban dau: "+iP3+"\n sau do \n "+ iP3.sortByTitle());
	System.out.println("=======================");
	System.out.println(iP2.totalSameProduct("Noi dia"));
	System.out.println("=======================");
	System.out.println(iP3.pL("Ngoai dia"));
	System.out.println("=======================");
	System.out.println(iP3.pL("Noi dia"));
	System.out.println("=======================");
	System.out.println(staff1.salary());
	System.out.println("=======================");
	System.out.println("Ban dau: \n"+ ds+"\n sau do:\n"+ds.sortBySalary());
	System.out.println("=======================");
	System.out.println(ds.addE(sST3));
	System.out.println("=======================");
	System.out.println(ds.removeStaff());
	System.out.println("=======================");
	System.out.println(ds.howManyE());
	System.out.println("=======================");
	System.out.println(ds.getSalers(pD1));
}
}
