package de6;

public class Cau1 {
	public static boolean checkEvenMainDia(int[][] matrix) {
		int row = 0, col = 0;
		boolean flag = false;
		vu: while (row < matrix.length - 1 && col < matrix[0].length - 1) {
			if (matrix[row][col] <= matrix[row + 1][col + 1]) {
				row++;
				col++;
				while (row < matrix.length - 1 && col < matrix[0].length - 1) {
					if (matrix[row][col] > matrix[row + 1][col + 1]) {
						break vu;
					}
					row++;
					col++;
				}
				return true;
			} else {
				break;
			}
		}
		vu1: while (row < matrix.length - 1 && col < matrix[0].length - 1) {
			if (matrix[row][col] >= matrix[row + 1][col + 1]) {
				row++;
				col++;
				while (row < matrix.length - 1 && col < matrix[0].length - 1) {
					if (matrix[row][col] < matrix[row + 1][col + 1]) {
						break vu1;
					}
					row++;
					col++;
				}
				return true;
			} else {
				break;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 4, 2, 3 }, { 2, 4, 4 }, { 2, 3, 6 } };
		System.out.println(checkEvenMainDia(matrix));
	}
}
