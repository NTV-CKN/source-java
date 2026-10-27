package bai_1.cau1;

import java.util.Random;

public class Factory {
	private int maxLengthShape = 3;

	public IShape createShape() {
		Random rand = new Random();
		Shape shape = Shape.values()[rand.nextInt(maxLengthShape)];

		switch (shape) {
		case Circle: {
			double result = rand.nextDouble(0.0, 10000.0);
			double save = ((int) (result* 100)) / 100.0;
//			System.out.println(result + " " + save);
			return new Circle(save);
		}
		case Rectangle: {
			return new Rectangle(rand.nextInt(0, Integer.MAX_VALUE), rand.nextInt(0, Integer.MAX_VALUE));
		}
		case Square: {
			return new Square(rand.nextInt(0, Integer.MAX_VALUE));
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + shape);
		}
	}
}
