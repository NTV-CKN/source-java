import junit.framework.*;
public class Test extends TestCase{
	public void test() {
		
	Date dateProduct1 = new Date(1, 12, 2019);
	Date dateProduct2 = new Date(1, 8, 2020);
	Date dateProduct3 = new Date(1, 6, 2019);
	Date dateProduct4 = new Date(1,11, 2021);
	
	Date dateExpired1 = new Date(1, 12, 2022);
	Date dateExpired2 = new Date(1, 8, 2023);
	Date dateExpired3 = new Date(1, 6, 2022);
	Date dateExpired4 = new Date(1, 11, 2023);

	Manufactor manu1 = new Manufactor("VinaMilk", "VietNam");
	Manufactor manu2 = new Manufactor("Nestle", "USA");
	Manufactor manu3 = new Manufactor("Meiji", "Japan");
	Manufactor manu4 = new Manufactor("VinaMilk", "VietNam");

	Spectification spec1 = new Spectification(12, 15);
	Spectification spec2 = new Spectification(15, 20);
	Spectification spec3 = new Spectification(15, 20);
	Spectification spec4 = new Spectification(15, 20);
	
	Milk milk1 = new Milk("Huh",0.5, 120000, spec1, manu1, dateProduct1, dateExpired1);
	Milk milk2 = new Milk("Huhu",0.9, 294000, spec2, manu2, dateProduct2, dateExpired2);
	Milk milk3 = new Milk("Huhuu",0.9, 463000, spec3, manu3, dateProduct3, dateExpired3);
	Milk milk4 = new Milk("Huhuu",0.9, 256000, spec4, manu4, dateProduct4, dateExpired4);

	DanhSach dsMilk = new ConsMilk(milk1, new ConsMilk(milk2, new ConsMilk(milk3, new ConsMilk(milk4, new Empty()))));
	
	assertEquals(milk1.sameCompany(milk2), false);
	assertEquals(milk3.volumn(), 14137.16, 0.01);
	assertEquals(dateExpired1.after(dateExpired4), false);
	assertEquals(milk4.discount(), 256000.0);
	assertEquals(milk4.isExpired(dateExpired4), false);
	System.out.println(dsMilk);
	}
}
