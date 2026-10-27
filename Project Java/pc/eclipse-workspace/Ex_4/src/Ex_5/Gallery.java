package Ex_5;
/**
 * trong Gallery co 2 thuoc tinh va co 3 phuong thuc :
 - String srcFile
 - double size
 
 +timeToDownload => tra ve KDL double voi tham so dau vao la double
 	return this.getSize()/networkSpeed;
 +smallerThan => tra ve KDL boolean voi tham so dau la double (maxSize)
 	return true neu maxSize > this.getSize() va nguoc lai
 +sameName => tra ve KDL String voi tham so dau vao la String (scrName)
 	return true neu 2 chuoi giong nhau va nguoc lai
 	
 	vidu 
		Gallery g1 = new Image("flower.gif", 57.234, 100, 50, "medium");
		Gallery g2 = new Sound("theme.mp3", 40960.0, 3, 20);
		Gallery g3 = new Sound("theme.mp3", 40960.0, 3, 20);
 
 */
public abstract class Gallery {
	private String srcFile;//nguon tep
	private double size;//so luong byte
	//constructor
	public Gallery(String srcFile, double size) {
		this.srcFile = srcFile;
		this.size = size;
	}
	//getter and setter
	public String getSrcFile() {
		return srcFile;
	}
	public void setSrcFile(String srcFile) {
		this.srcFile = srcFile;
	}
	public double getSize() {
		return size;
	}
	public void setSize(double size) {
		this.size = size;
	}
	//toString
	@Override
	public String toString() {
		return this.getSrcFile() + ", "+ this.getSize() + ", ";
	}
	//timeToDownload
	public double timeToDownload(double networkSpeed) {
		return this.getSize()/networkSpeed;
	}
	//smallerThan
	public boolean smallerThan(double maxSize) {
		boolean b;
		if(this.getSize() > maxSize) {
			b = false;
		}else {
			b = true;
		}
		return b;
	}
	//sameName
	public boolean sameName(String srcName) {
		boolean b;
		if(this.getSrcFile().equals(srcName)) {
			b = true;
		}else {
			b = false;
		}
		return b;
	}
}
