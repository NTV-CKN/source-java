package Ex_2_2;
import junit.framework.*;
public class TestMethod extends TestCase{
	public void testMovieTheaterMethod() {
		assertEquals(new MovieTheater(20, 0.5, 5).totalProfit(40), 160.0);
	}
}
