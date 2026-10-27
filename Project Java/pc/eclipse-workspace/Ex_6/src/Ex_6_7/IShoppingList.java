package Ex_6_7;
/**
 * trong IShoppingList co 3thuoc tinh abstract:
+int howMany 
	=> tra ve so luong Items trong IShoppingList
+String brandList
	=>tra ve 1 danh sach cac  ten thuong hieu cua hang trong IShoppingList
+double highestPrice 
	=>lay ra gia cao nhat trong cac items cua IShoppingList
 */
public abstract class IShoppingList {
	public abstract int howMany();
	public abstract String brandList();
	public abstract double highestPrice() ;
	
}
