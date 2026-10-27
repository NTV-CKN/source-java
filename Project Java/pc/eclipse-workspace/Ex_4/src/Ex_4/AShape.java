package Ex_4;
/**
 * trong AShape se co 1 thuoc tinh va 1 phuong thuc, AShape implements lai tu IsShape nen se co them 5 phuong thuc:
-CartPt cartPt

+double distanceToO()
 */
public abstract class AShape  implements IsShape{
	protected CartPt cartPt;//toa do xy
	//constructor
	public AShape(CartPt cartPt) {
		this.cartPt = cartPt;
	}
	//getter and setter
	public CartPt getCartPt() {
		return cartPt;
	}
	public void setCartPt(CartPt cartPt) {
		this.cartPt = cartPt;
	}
	//distanceToO
	public double distanceToO() {
		return this.cartPt.distanceTo(cartPt);
	}
}
