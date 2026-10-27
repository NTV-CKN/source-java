/*
 * trong lop Image ta co 4 thuoc tinh voi modifier o dang private:
 * int height
 * int width
 * String source
 * String quality
 * Vi du:
 * 	new Image(5, 10, "small.gif", "low");

		new Image(120, 200, "med.gif", "low");

		new Image(1200, 1000, "large.gif", "high");
 */
public class Image {
	private int height; // pixels
	private int width; // pixels
	private String source; // file name
	private String quality; // informal
	//constructor
	public Image(int height, int width, String source, String quality) {
		this.height = height;
		this.width = width;
		this.source = source;
		this.quality = quality;
	}
}