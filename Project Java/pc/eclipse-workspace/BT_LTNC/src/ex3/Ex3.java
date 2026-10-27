package ex3;

public class Ex3 {
public static void main(String[] args) {
	Product[] products = {
			new Product("Chuoi", "chuoi01", 3.4),
			new Product("Ao so mi", "somi02", 200.0),
			new Product("Noi chien khong dau", "nckd03", 1000.0)
	};
	Product productAdd = new Product("Den ngu", "dn04", 120.0);
	
	ShoppingCart myShoppingCart = new ShoppingCart(products);
	Customer cus = new Customer("Vu", myShoppingCart);
	
	System.out.println(cus.toString());
	//add
	cus.addProduct(productAdd);
	System.out.println("=======================================");
	System.out.println(cus.toString());
	//remove
	cus.removeProduct("dn04");
	System.out.println(cus.toString());
	//checkout
	System.out.println(cus.checkout());
}
}
