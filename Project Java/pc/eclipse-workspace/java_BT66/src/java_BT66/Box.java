package java_BT66;

public class Box<T> {
private T value;

public Box(T value) {
	super();
	this.value = value;
}

public T getValue() {
	return value;
}

public void setValue(T value) {
	this.value = value;
}

}
