package Ex_4;
/**
 * trong ShapeUtils co 1 phuong thuc static dung de duoc goi cho phuong thuc contains cua Rectangle va Square
 * +  static boolean between(int value, int low, int high)
 */
public class ShapeUtils {
	static boolean between(int value, int low, int high) {
		return low <= value && value <= high;
	}

}
