package bai_1.cau1;

public class Square implements IShape {
	public int width;

	public Square(int width) {
		super();
		this.width = width;
	}

	@Override
	public String draw() {
		return "ve hinh vuong co chieu rong la " + width;
	}
}