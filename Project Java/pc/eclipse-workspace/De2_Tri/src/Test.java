import junit.framework.*;
public class Test extends TestCase{
public void test() {
	
	
	Employee staff1 = new Staff(101, "Le Nhan Minh", "145 vo van tan tphcm", "efe", 1500000, 1.2, "Bo giao hang");
	Employee staff2 = new Staff(102, "Le Nhan Minh", "145 vo van tan tphcm", "efe", 1500000, 1.5, "Bo giao hang");
	
	Product product1 = new Product(101, "May Lanh", 40);
	Product product2 = new Product(102, "Tu Lanh", 35);
	Product product3 = new Product(103, "Am Dun Nuoc", 30);
	Product product4 = new Product(104, "Lo Nuong", 60);
	
	DanhSachProduct ds1 = new ConsProduct(product1, new ConsProduct(product2, new ConsProduct(product4, new EmptyProduct())));
	DanhSachProduct ds2 = new ConsProduct(product2, new ConsProduct(product4, new EmptyProduct()));
	DanhSachProduct ds3 = new ConsProduct(product1, new ConsProduct(product3, new EmptyProduct()));
	
	Employee saleStaff1 = new SaleStaff(201, "rgrgr", "svdf", "sgdsf",900000, 2.5, ds1);
	Employee saleStaff2 = new SaleStaff(202, "rgrgr", "svdf", "sgdsf",900000, 2.2, ds2);
	Employee saleStaff3 = new SaleStaff(203, "rgrgr", "svdf", "sgdsf",900000, 2.0, ds3);
	
	ConsNhanVien dsnv = new ConsNhanVien(saleStaff1, new ConsNhanVien(saleStaff2, new ConsNhanVien(saleStaff3,  new EmptyDS())));
	
	assertEquals(1800000.0, staff1.salary());
	assertEquals(11250000.0, saleStaff1.salary());
	
	assertEquals(3, saleStaff1.countEmployeeSaleStaff());
	
	assertEquals(false, saleStaff1.equals(product3));

	dsnv.getSalers(product1);
	
}
}
