

public class VuDepTrai {
private String name;
private int old;
public VuDepTrai(String name, int old) {
	super();
	this.name = name;
	this.old = old;
}
@Override
public String toString() {
	return "VuDepTrai [name=" + name + ", old=" + old + "]";
}
//
public boolean hasOldSmallerThan(VuDepTrai that) {
	return this.old <= that.old;
}
}
