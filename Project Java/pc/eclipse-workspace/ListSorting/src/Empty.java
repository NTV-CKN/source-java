

public class Empty extends DanhSach{

	@Override
	public DanhSach insert(VuDepTrai that) {
		return new Cons(that, new Empty());
	}

	@Override
	public String toString() {
		return "";
	}

	@Override
	public DanhSach sort() {
		return new Empty();
	}

}
