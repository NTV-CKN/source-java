package Ex_7;
import junit.framework.*;
public class Test extends TestCase{
	public void test() {
		//Cab
		Cab cab1 = new Cab(111, 5, 12.000);
		Cab cab2 = new Cab(112, 2, 19.000);
		
		//fare
		assertEquals(cab1.fare(6), 72.000);
		//lowerThan
		assertEquals(cab1.lowerThan(73.000, 6), true);
		//cheaperThan
		assertEquals(cab1.cheaperThan(cab2, 6, 2), false);
		
		
		//Limo
		Limo limo1 = new Limo(121, 10, 9.000, 4.000);
		Limo limo2 = new Limo(122, 11, 4.000, 4.000);
		
		//fare
		assertEquals(limo1.fare(6), 54.000);
		//lowerThan
		assertEquals(limo1.lowerThan(73.000, 6), true);
		//cheaperThan
		assertEquals(limo1.cheaperThan(limo2, 6, 2), false);
		
		//Van
		Van van1 = new Van(131, 9, 20.000, true);
		Van van2 = new Van(132, 3, 29.000, true);
		
		//fare
		assertEquals(van1.fare(6), 129.000);
		//lowerThan
		assertEquals(van1.lowerThan(73.000, 6), false);
		//cheaperThan
		assertEquals(van1.cheaperThan(van2, 6, 2), false);
		
	}
}
