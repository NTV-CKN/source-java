package Ex_5;
/**
 * trong Sound co 2 thuoc tinh:
-int hour
-int minute
	*ke thua them 2 thuoc tinh cua lop Gallery

	vidu
		//khoi tao Sound
		 Sound sound = new Sound("theme.mp3", 40960, 3, 20);
		 //toString
		 assertEquals(sound.toString(), "theme.mp3, 40960, 3, 20");
			//timeToDownload
			assertEquals(sound.timeToDownload(1), 40960.0);
			//smallerThan
			assertEquals(sound.smallerThan(60.0), false);
			//sameName
			assertEquals(sound.sameName("theme.mp3"), true);
 */
public class Sound extends Gallery{
	private int hour;//gio
	private int minute;//phut
	//constructor
	public Sound(String srcFile, double size, int hour, int minute) {
		super(srcFile, size);
		this.hour = hour;
		this.minute = minute;
	}
	//getter and setter
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	//toString
	@Override
	public String toString() {
		return super.toString() + this.getHour() + ", "+ this.getMinute();
	}
	
}
