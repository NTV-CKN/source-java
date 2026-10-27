package bai_2;

public class Bai2Utils {
	public static double baseToHelper(double amount, SymbolUnit unit) {
		switch (unit) {
		case EUR: {
			return amount * 0.8776;
		}
		case GBP: {
			return amount * 0.7393;
		}
		case JPY: {
			return amount * 144.9;
		}
		case VND: {
			return amount * 26.050;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + unit);
		}
	}
}
