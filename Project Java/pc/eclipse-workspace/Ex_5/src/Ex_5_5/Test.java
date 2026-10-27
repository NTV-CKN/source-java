package Ex_5_5;
import junit.framework.*;
public class Test extends TestCase{
	public void testConstructor() {
		//khoi tao Location
		Location lc1 = new Location(1, 1, "s");//Source
		Location lc2 = new Location(1, 5, "t");//Source
		Location lc3 = new Location(3, 7, "u");//Source
		
		Location lc4 = new Location(3, 3, "b");//Confluence
		Location lc5 = new Location(5, 5, "a");//Confluence
		Location lc6 = new Location(7, 5, "m");//Mouth
		//khoi tao Mouth
		Mouth mouth = new Mouth(lc6);
		//khoi tao ARiver
		ARiver ars1 = new Source(lc1, 120);
		ARiver ars2 = new Source(lc2, 50);
		ARiver ars3 = new Source(lc3, 100);
		
		ARiver b = new Confluence(lc4,60, ars1, ars2, 0);
		ARiver a = new Confluence(lc5,30, ars3, b, 0);
		ARiver c = new Confluence(lc6, 123, ars2, a, 0);
		//RiverSystem
		RiverSystem rs = new RiverSystem(mouth, c );
		//sysout
		System.out.println(rs);
	}
}
