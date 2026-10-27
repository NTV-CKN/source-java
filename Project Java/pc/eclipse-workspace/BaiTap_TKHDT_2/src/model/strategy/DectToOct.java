package model.strategy;

public class DectToOct implements ConversionFunction {
	@Override
	public String convert(int valueDecimal) {
		StringBuilder sb = new StringBuilder();
		int save = valueDecimal;
		while (save != 0) {
			sb.append(save % 8);
			save /= 8;
		}
		return sb.reverse().toString();
	}
}