package Ex_5_1;

import javax.swing.border.EmptyBorder;

import junit.framework.TestCase;
public class HouseTest extends TestCase {
	public void test() {
		House h1 = new House("Ranch", "7 rooms", 375.000, new Address(23, "Maple Street", "Brookline"));
		House h2 = new House("Colonial", "9 rooms", 450.000, new Address(5, "Joye Road", "Newton"));
		House h3 = new House("Cape", "6 rooms", 235.000, new Address(83, "Winslow Road", "Waltham"));
		//list
		IHouse ds = new ConsHouse(h1, new ConsHouse(h2, new ConsHouse(h3, new MTHouse())));
		System.out.println(ds);
	}
}
