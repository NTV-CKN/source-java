import java.util.Objects;

public class Spectification {
private double baseDiameter, height;

public Spectification(double baseDiameter, double height) {
	super();
	this.baseDiameter = baseDiameter;
	this.height = height;
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

@Override
public String toString() {
	return "Spectification [baseDiameter=" + baseDiameter + ", height=" + height + "]";
}

@Override
public int hashCode() {
	return Objects.hash(baseDiameter, height);
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Spectification other = (Spectification) obj;
	return Double.doubleToLongBits(baseDiameter) == Double.doubleToLongBits(other.baseDiameter)
			&& Double.doubleToLongBits(height) == Double.doubleToLongBits(other.height);
}

}
