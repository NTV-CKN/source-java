
public class test {
public static void main(String[] args) {
	Vehicle pt1 = new Vehicle("xe tai", 1);
	Vehicle pt2 = new Vehicle("xe mo", 33);
	Vehicle pt3 = new Vehicle("xe ban tai", 2);
	Vehicle pt4 = new Vehicle("xe ban tai", 2);
	
	DanhSach ds = new Cons(pt1, new Cons(pt2, new Cons(pt4, new Empty())));
	
	Driver d = new Driver("vu", "123", ds);
	
	System.out.println(d.getDrivers(pt4));
}
}
