package Ex_4;
/**
 * day la interface cua AShape va chua 4 phuong thuc rong la :
+double area() => dien tich
+double distanceToO() => khoang cach toi O
+boolean contains(CartPt point) => kiem tra tham so CartPt co nam trong hinh hay khong
+Rectangle boundingBox() => bao hinh cn
+double perimeter() => chu vi
 */
public interface IsShape {
	
	public double area();
	public double distanceToO();
	public boolean contains(CartPt point);
	public Rectangle boudingBox();
	public double perimeter();
}
