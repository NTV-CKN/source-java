
public class Test {
	public static void main(String[] args) {
Date date1 = new Date(1, 1, 2);

Item item1 = new Item(5, "Khung Long", "BanDai", 1);
Item item2 = new Item(7, "DonBlaster", "BanDai", 1);
Item item3 = new Item(6, "Zio", "Toei", 1);

IItem ds1 = new ConsItem(item1, new ConsItem(item2, new MTItem()));
IItem ds2 = new ConsItem(item1, new ConsItem(item2, new ConsItem(item3, new MTItem())));


SaleStaff sS1 = new SaleStaff(1, "Vu", "Dong Nai", date1, 12, 11, ds1);
SaleStaff sS2 = new SaleStaff(2, "Hieu", "Bien Hoa", date1, 1, 12, ds2);

Staff st1 = new Staff(3, "Trang", "Thu Duc", date1, 1, 1, "Dong goi");
Staff st2 = new Staff(4, "Hoa", "Thu Duc", date1, 1, 1, "Dong goi");

IList ds = new ConsEm(sS1, new ConsEm(sS2, new ConsEm(st1, new ConsEm(st2, new MTIList()))));

System.out.println("How many: "+ds.howManyEmployee());
System.out.println("=====================");
System.out.println("Get salers: "+ ds.getSalers(item1));
System.out.println("=====================");
System.out.println("Salary: "+sS1.salary());
System.out.println("=====================");
System.out.println("Count: "+st1.count());
System.out.println("=====================");
System.out.println("Is product: "+sS1.isProduct(item3));
System.out.println("=====================");
System.out.println("Truoc: "+ ds2+"\n"+ "sau: " );
System.out.println("sortByTitle: "+ds2.sortByTitle());
System.out.println("=====================");
System.out.println("Total: "+ds2.total("BanDai"));
System.out.println("=====================");
System.out.println("Phan Loai: "+ds2.pL("Toei"));

	}
}
