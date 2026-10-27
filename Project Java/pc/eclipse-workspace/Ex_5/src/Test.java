import junit.framework.*;
public class Test extends TestCase{
	public void testInventory() {
		//khoi tao Toy
		Toy toy1 = new Toy("Khung long", 50, 50.000);
		Toy toy2 = new Toy("Bup be", 510, 505.000);
		Toy toy3 = new Toy("Xe dua", 10, 450.000);
		//tao Inventory
		Inventory inv1 = new Construct(new Construct(new Construct(new Empty(), toy3), toy2), toy1);
		Inventory inv2 = new Empty();
		//sysout
		System.out.println(inv1);
		System.out.println(inv2);
	}
}
