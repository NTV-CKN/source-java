package Ex_2_3;
/**
 * trong Image co 4 thuoc tinh va 5 phuong thuc:
- int width
- int height
- String source
- String quality

+ boolean isPortrait() =>tra ve true neu chieu dai lon hon chieu rong cua anh
+ int size() =>tra ve so luong pixel cua anh
+ boolean isLarger(Image i) =>tra ve true neu this.size() > that.size()
+ boolean same(Image i) =>tra ve true neu this.size() == that.size()
+ String sizeString() =>tra ve 1 trong 3 truong hop: 
	"small" neu this.size() co gia tri <= 10.000
	"normal" neu this.size() co gia tri trong khoang 10.001 den 1.000.000
	"large" neu this.size() co gia tri > 1.000.000
*vidu:
* 	Image i_1	= new Image(300, 200, "alime.jpg", "high");
	Image i_2	= new Image(400, 500, "love.jpg", "low");
	Image i_3 = new Image(300, 200, "this.jpg", "high");
 */
public class Image {
	private int width;//chieu rong
	private int height;//chieu dai
	private String source;//nguon 
	private String quality;//chat luong
	//constructor
	public Image(int width, int height, String source, String quality) {
		this.width = width;
		this.height = height;
		this.source = source;
		this.quality = quality;
	}
	//isPortrait
	public boolean isPortrait() {
		return this.height > this.width;
	}
	//size
	public int size() {
		return this.height * this.width;
	}
	//isLarger
	public boolean isLarger(Image i) {
		return this.size() > i.size();
	}
	//same
	public boolean same(Image i) {
		return this.size() == i.size();
	}
	//sizeString
	public String sizeString() {
		String str = "";
		if(this.size() <= 10000) {
			str = "small";
		}else if(this.size() >10001 && this.size() < 1000000) {
			str = "normal";
		}else if(this.size() > 1000000) {
			str = "large";
		}
		return str;
	}
}
