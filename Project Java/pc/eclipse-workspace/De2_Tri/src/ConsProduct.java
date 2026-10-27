import java.util.Objects;

public class ConsProduct extends DanhSachProduct{
	private Product product;
	private DanhSachProduct danhSach;
	public ConsProduct(Product product, DanhSachProduct danhSach) {
		this.product = product;
		this.danhSach = danhSach;
	}
	//check

	public boolean checkProduct(Product that) {
	return this.product.equals(that) || this.danhSach.checkProduct(that);
	}
	//
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsProduct other = (ConsProduct) obj;
		return Objects.equals(danhSach, other.danhSach) && Objects.equals(product, other.product);
	}
	
}
