
import junit.framework.TestCase;

public class DanhSachTest extends TestCase {
public void test() {
	VuDepTrai v1 = new VuDepTrai("Vu khoai to", 12);
	VuDepTrai v2 = new VuDepTrai("Vu khoai bu", 17);
	VuDepTrai v3 = new VuDepTrai("Vu khoai ok", 121);
	VuDepTrai v4 = new VuDepTrai("Vu khoai vua", 1);
	
	DanhSach ds = new Cons(v1, new Cons(v2, new Cons(v4, new Cons(v3, new Empty()))));
	
	assertEquals(ds.sort(), new Cons(v4, new Cons(v1, new Cons(v2, new Cons(v3, new Empty())))));
}
}
