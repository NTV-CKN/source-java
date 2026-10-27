package java_BT46;

import java.lang.reflect.UndeclaredThrowableException;

public class CasioFX500 implements MayTinhBoTuiInterface{

	@Override
	public double plus(double a, double b) {
		return a+b;
	}

	@Override
	public double except(double a, double b) {
		return a-b;
	}

	@Override
	public double multiply(double a, double b) {
		return a*b;
	}

	@Override
	public void divide(double a, double b) {
    try {
		System.out.println(a/b);
	} catch (ArithmeticException divide) {
	    System.out.println("loi chia 0!");
	}

	}

}
