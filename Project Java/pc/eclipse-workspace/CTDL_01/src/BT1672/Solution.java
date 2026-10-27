package BT1672;

public class Solution {
	int numberRow;
	int numberCol;
	int total = 0;
	int max = 0;
	public int maximumWealth(int[][] accounts) {
		numberRow = accounts.length;
		numberCol = accounts[0].length;
		for (int i = 0; i < numberRow; i++) {
			for (int j = 0; j < numberCol; j++) {
				total += accounts[i][j];
			}
			if(total > max) {
				max = total;
			}
			total = 0;
		}
    	return max;
    }

public static void main(String[] args) {
	Solution so = new Solution();
	int [][] a = {{1,2,3}, {3,2,1}};
	int[][] b = {{1,5},{7,3},{3,5}};
	System.out.println(so.maximumWealth(a));
	System.out.println(so.maximumWealth(b));
}
}
