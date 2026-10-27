package Ex_5;
/**
 * trong Image co 3 thuoc tinh:
-int height
-int width
-String quality
	*ke thua them 2 thuoc tinh cua lop Gallery
	
	vidu
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
 */
public class Image extends Gallery{
	private int height;//chieu dai
	private int width;//chieu rong
	private String quality;//chat luong anh
	//constructor
	public Image(String srcFile, double size, int height, int width, String quality) {
		super(srcFile, size);
		this.height = height;
		this.width = width;
		this.quality = quality;
	}
	//getter and setter
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public String getQuality() {
		return quality;
	}
	public void setQuality(String quality) {
		this.quality = quality;
	}
	//toString
	@Override
	public String toString() {
		return super.toString() + this.getHeight() + ", " + this.getWidth() + ", " + this.getQuality();
	}
	
}
