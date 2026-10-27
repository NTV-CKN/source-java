package Lession1;

public class Calculator {
public static float divide(float x, float y) throws CustomException {
	if(y ==0) {
		throw new CustomException(x, y);
	}
	return x/y;
}
}
