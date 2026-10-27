package Ex_3;
import junit.framework.*;
public class Test extends TestCase{
	public void testVehicles() {
		Verhicles b = new Bus("#hds", "NhaTr", "#123", 18);
		Verhicles lm = new Limo("#hdb", "Celes" , 2005, 18);
		Verhicles car = new Car("#hdc", "KIA", 4, true);
		Verhicles sw = new Subway("#hdf", "AK" , 5.3, 100);

		assertEquals(b.toString(), "#hds, NhaTr, #123, 18");
		assertEquals(lm.toString(), "#hdb, Celes, 18, 2005");
		assertEquals(car.toString(), "#hdc, KIA, 4, true");
		assertEquals(sw.toString(), "#hdf, AK, 5.3, 100.0");
		
	}
}
