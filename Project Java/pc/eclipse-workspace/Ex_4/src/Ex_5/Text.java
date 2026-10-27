package Ex_5;
/**
 * trong Text co 1 thuoc tinh:
 -double numberLine
 	*ke thua them 2 thuoc tinh cua lop Gallery
 	
 	vidu
 		//khoi tao Text
		Text text = new Text("welcome.txt", 5.312, 830);
		//toString
		assertEquals(text.toString(), "welcome.txt, 5.312, 830");
		//timeToDownload
		assertEquals(text.timeToDownload(1), 5.312);
		//smallerThan
		assertEquals(text.smallerThan(60.0), true);
		//sameName
		assertEquals(text.sameName("welcome.txt"), true);
 */
public class Text extends Gallery{
	private double numberLine;//so dong
	//constructor

	public Text(String srcFile, double size, double numberLine) {
		super(srcFile, size);
		this.numberLine = numberLine;
	}
	//getter and setter

	public double getNumberLine() {
		return numberLine;
	}

	public void setNumberLine(double numberLine) {
		this.numberLine = numberLine;
	}
	//toString

	@Override
	public String toString() {
		return super.toString() + this.getNumberLine();
	}
	
}
