package Ex_2;
import junit.framework.*;
public class Test extends TestCase{
	public void testImage() {
		//khoi tao Image
		Image img = new Image("flower.gif", 57.234, 100, 50, "medium");
		//toString
		assertEquals(img.toString(), "flower.gif, 57.234, 100, 50, medium");
	}
	public void testSound() {
		//khoi tao Sound
		 Sound sound = new Sound("theme.mp3", 40960.0, 3, 20);
		 //toString
		 assertEquals(sound.toString(), "theme.mp3, 40960.0, 3, 20");
	}
	public void testText() {
		//khoi tao Text
		Text text = new Text("welcome.txt", 5.312, 830.0);
		//toString
		assertEquals(text.toString(), "welcome.txt, 5.312, 830.0");
	}
}
