
public abstract class IProduct {
	public abstract IProduct sortByTitle();
	public abstract IProduct insert(Product that);
	public abstract int totalSameProduct(String allowcate);
	public abstract IProduct pL(String allowcate);
	public abstract String sameAvailable();
	public abstract boolean checkAvailable(Product that);
	public abstract boolean checkProduct(Product that);
}
