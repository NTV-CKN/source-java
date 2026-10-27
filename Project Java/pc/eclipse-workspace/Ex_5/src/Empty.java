/**
 * trong Empty se thuc hien hoa lai Interface Inventory, trong Empty khong co thuoc tinh va method
 va constructor la rong dung de tra ve doi tuong rong
 vidu
 	Inventory inv2 = new Empty();
 */
public class Empty implements Inventory{
	//constructor
	public Empty() {
		//toString
		
	}

	@Override
	public String toString() {
		return "Empty";
	}
}
