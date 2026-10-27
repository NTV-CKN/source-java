package Ex_2;
/**
 * trong Gallery co 2 thuoc tinh :
 - String srcFile
 - double size
 
 
 */
public class Gallery {
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
	
}
