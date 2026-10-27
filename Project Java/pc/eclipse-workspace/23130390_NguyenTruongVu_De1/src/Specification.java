
public class Specification {
private double baseDiameter, height;

@Override
public String toString() {
	return "Specification [baseDiameter=" + baseDiameter + ", height=" + height + "]";
}

public double getBaseDiameter() {
	return baseDiameter;
}

public void setBaseDiameter(double baseDiameter) {
	this.baseDiameter = baseDiameter;
}

public double getHeight() {
	return height;
}

public void setHeight(double height) {
	this.height = height;
}

public Specification(double baseDiameter, double height) {
	super();
	this.baseDiameter = baseDiameter;
	this.height = height;
}
}
