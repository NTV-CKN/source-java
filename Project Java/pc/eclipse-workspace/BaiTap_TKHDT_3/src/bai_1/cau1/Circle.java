package bai_1.cau1;

public class Circle implements IShape {
	public double radius;

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	@Override
	public String draw() {
		return "Ve duong tron co ban kinh " + radius;
	}
}
