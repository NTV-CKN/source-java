package Ex_2;
/**
 * trong Text co 1 thuoc tinh:
 -double numberLine
 	*ke thua them 2 thuoc tinh cua lop Gallery
 	
 	vidu
 		//khoi tao Text
		Text text = new Text("welcome.txt", 5.312, 830);
		//toString
		assertEquals(text.toString(), "welcome.txt, 5.312, 830");
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
