package Ex_2_6;
/**
 * trong Quadratic co 3 thuoc tinh va 2 phuong thuc:
 * ax^2 + bx + c =0
 - double a
- double b
- double c

+computeDelta()=>tra ve KDL double, return this.b * this.b - 4*this.a*this.c
+whatKind()=>tra ve KDL String voi 4 truong hop:
	neu a == 0 => return "degenerate"
	neu this.computeDelta > 0=> return "two solution"
	neu this.computeDelta < 0=> return "none"
	neu this.computeDelta == 0=> return "one solution"
	*vidu:
Quadratic q1= new Quadratic(0.0, 1.0, 2.0);
Quadratic q2= new Quadratic(2.0, 1.0, 2.0);
Quadratic q3= new Quadratic(1.0, 2.0, 1.0);
Quadratic q4= new Quadratic(2.0, 3.0, 1.0);

assertEquals("degenerate", q1.whatKind());
assertEquals("none", q2.whatKind());
assertEquals("one solution", q3.whatKind());
assertEquals("two solution", q4.whatKind());
 */
public class Quadratic {
	 private double a;
	 private double b;
	 private double c;
	 //constructor
	public Quadratic(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	 //computeDelta
	public double computeDelta() {
		 return this.b * this.b - 4*this.a*this.c;
	}
	//whatKind
	public String whatKind() {
		String str = "";
		if(this.a == 0) {
			str = "degenerate";
		}else if(this.computeDelta() > 0) {
			str = "two solution";
		}else if(this.computeDelta() < 0) {
			str = "none";
		}else {
			str = "one solution";
		}
		return str;
	}
}
