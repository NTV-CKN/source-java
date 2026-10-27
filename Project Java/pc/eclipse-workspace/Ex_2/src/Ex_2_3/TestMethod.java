package Ex_2_3;
import junit.framework.*;
public class TestMethod extends TestCase{
	public void testImageMethod() {
	Image i_1	= new Image(300, 200, "alime.jpg", "high");
	Image i_2	= new Image(400, 500, "love.jpg", "low");
	Image i_3 = new Image(300, 200, "this.jpg", "high");
	//isPortrait
	assertFalse(i_1.isPortrait());
	assertTrue(i_2.isPortrait());
	assertFalse(i_3.isPortrait());
	//size
	assertEquals(i_1.size(), 60000);
	assertEquals(i_2.size(), 200000);
	assertEquals(i_3.size(), 60000);
	//isLarger
	assertFalse(i_1.isLarger(i_2));
	assertTrue(i_2.isLarger(i_3));
	assertFalse(i_1.isLarger(i_3));
	//same
	assertFalse(i_1.same(i_2));
	assertTrue(i_1.same(i_3));
	assertFalse(i_2.same(i_3));
	//sizeString
	assertEquals(i_1.sizeString(), "normal");
	assertEquals(i_2.sizeString(), "normal");
	assertEquals(i_3.sizeString(), "normal");
	}
}
