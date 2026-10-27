package ex5;

/*
 * Example: A=65, “AA”
“AA” = 65* 31^(2-1) + 65*31^(2-2) = 2080
 */
public class Ex1 {
	private int mCount = 0;

	public int hashCodeJava(String data) {
		if (data == null) {
			return -1;
		}
		mCount = 0;
		return hashRec(data, data.length());
	}

	private int hashRec(String data, int length) {
		if (length == 0)
			return -1;
		
		char ch = data.charAt(0);
		int result = (int) ch * (int) Math.pow(31, length - ++mCount);

		if (mCount == length)
			return result;
		return result + hashRec(data.substring(1), length);
	}
}
