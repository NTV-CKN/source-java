package model.strategy;

public class DectToBin implements ConversionFunction {
	@Override
	public String convert(int valueDecimal) {
		StringBuilder sb = new StringBuilder();
		int save = valueDecimal;
		while (save != 0) {
			sb.append(save % 2);
			save /= 2;
		}
		return sb.reverse().toString();
	}
}
