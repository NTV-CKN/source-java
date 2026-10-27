package model.strategy;

import java.util.Stack;

public class DectToHex implements ConversionFunction {
	@Override
	public String convert(int valueDecimal) {
		Stack<Integer> stack = new Stack<Integer>();
		StringBuilder sb = new StringBuilder();
		int save = valueDecimal;
		while (save != 0) {
			stack.add(save % 16);
			save /= 16;
		}
		for (Integer integer : stack) {
			if (integer > 9) {
				sb.append(chooseCharacter(integer));
			} else {
				sb.append(integer);
			}
		}
		return sb.toString();
	}

	private char chooseCharacter(int num) {
		if (num > 9 && num < 16) {
			switch (num) {
			case 10:
				return 'A';
			case 11:
				return 'B';
			case 12:
				return 'C';
			case 13:
				return 'D';
			case 14:
				return 'E';
			case 15:
				return 'F';
			}
		}
		return '-';
	}
}