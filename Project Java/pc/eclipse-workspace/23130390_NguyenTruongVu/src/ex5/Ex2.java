package ex5;

import java.text.DecimalFormat;
import java.text.Format;

/*
 * Example: ASCII values: C=67, L=76, R=82, S=83.
There are 128 basic ASCII values.
So, CLRS = 67·1283+76 ·1282+ 82·1281+ 83·1280 = 141,764,947.
 */
public class Ex2 {
	public String hashCodeNatureKey(String data) {
		if(data == null) return "-1";
		long resut = clrs(data, 0, data.length());
		Format format = new DecimalFormat("#,###");
		return format.format(resut);
	}

	private Long clrs(String data, int index, int length) {
		if (length == 0 || index < 0)
			return -1L;

		char ch = data.charAt(0);
		long result = (int) ch * (int) Math.pow(128, length - ++index);

		if (index == length)
			return result;
		return result + clrs(data.substring(1), index, length);
	}
}
