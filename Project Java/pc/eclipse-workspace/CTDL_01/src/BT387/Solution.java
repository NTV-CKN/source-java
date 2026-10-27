package BT387;

public class Solution {
	public static int firstUniqChar(String s) {
		char[] c = s.toCharArray();
		int[] count = new int[123];
		for (int i = 0; i < c.length; i++) {
			int index = (int) c[i];
			count[index]++;
		}
		for (int i = 0; i < c.length; i++) {
			int index = (int) c[i];
			if (count[index] == 1) {
				return i;
			}
		}
		return -1;
	}
  public static void main(String[] args) {
	String str1 = "ddlllleetssvfdsvevcode";
	System.out.println(Solution.firstUniqChar(str1));
	
}
}
