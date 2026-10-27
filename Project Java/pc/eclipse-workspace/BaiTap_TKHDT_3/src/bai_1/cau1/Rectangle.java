package bai_1.cau1;

public class Rectangle implements IShape {
	public int width, height;

	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public String draw() {
		return "Ve hinh chu nhat co chieu rong la " + width + ", chieu dai la " + height;
	}
}