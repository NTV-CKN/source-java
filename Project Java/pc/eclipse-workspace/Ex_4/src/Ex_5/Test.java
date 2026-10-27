package Ex_5;
import junit.framework.*;
public class Test extends TestCase{
	public void testImage() {
		//khoi tao Image
		Image img = new Image("flower.gif", 57.234, 100, 50, "medium");
		//toString
		assertEquals(img.toString(), "flower.gif, 57.234, 100, 50, medium");
		//timeToDownload
		assertEquals(img.timeToDownload(3), 19.078);
		//smallerThan
		assertEquals(img.smallerThan(60.0), true);
		//sameName
		assertEquals(img.sameName("low.gif"), false);
	}
	public void testSound() {
		//khoi tao Sound
		 Sound sound = new Sound("theme.mp3", 40960.0, 3, 20);
		 //toString
		 assertEquals(sound.toString(), "theme.mp3, 40960.0, 3, 20");
			//timeToDownload
			assertEquals(sound.timeToDownload(1), 40960.0);
			//smallerThan
			assertEquals(sound.smallerThan(60.0), false);
			//sameName
			assertEquals(sound.sameName("theme.mp3"), true);
	}
	public void testText() {
		//khoi tao Text
		Text text = new Text("welcome.txt", 5.312, 830.0);
		//toString
		assertEquals(text.toString(), "welcome.txt, 5.312, 830.0");
		//timeToDownload
		assertEquals(text.timeToDownload(1), 5.312);
		//smallerThan
		assertEquals(text.smallerThan(60.0), true);
		//sameName
		assertEquals(text.sameName("welcome.txt"), true);
	}
	public void testGallery() {
		Gallery g1 = new Image("flower.gif", 57.234, 100, 50, "medium");
		Gallery g2 = new Sound("theme.mp3", 40960.0, 3, 20);
		Gallery g3 = new Sound("theme.mp3", 40960.0, 3, 20);
	}
}
