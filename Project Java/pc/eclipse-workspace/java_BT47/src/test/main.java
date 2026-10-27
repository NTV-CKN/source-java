package test;
import datatask.bt;
public class main {
public static void main(String[] args) {
	datatask.bt vu = new datatask.bt(5, 2);
	System.out.println("5 plus 2= "+vu.plus());
	except.bt vu1 = new except.bt(5, 2);
	System.out.println("5 except 2= "+vu1.except());
}
}
