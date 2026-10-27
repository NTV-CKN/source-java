package bai_1.cau2;

import java.util.Date;

import bai_1.cau2.strategy.CreditCard;
import bai_1.cau2.strategy.PayPal;

@SuppressWarnings("deprecation")
public class Test {
	public static void main(String[] args) {
		Customer cus1 = new Customer("123", "Nguyen Truong Vu", "0793189034", "190 ha noi", new Date("2005/01/07"),
				new CreditCard("", ""));
		Customer cus2 = new Customer("124", "Nguyen Le Vy", "0793189034", "190 ha noi", new Date("2009/01/01"),
				new PayPal("", ""));
		Customer cus3 = new Customer("125", "Le Tho So", "0793189034", "190 ha noi", new Date("2001/01/09"),
				new CreditCard("", ""));
		Customer cus4 = new Customer("126", "Nguyen Truong Dai", "0793189034", "190 ha noi", new Date("2005/01/02"),
				new PayPal("", ""));

		Product prod1 = new Product("p1", "Sua rua mat", 100.000);
		Product prod2 = new Product("p2", "Keo con chuot", 20.000);
		Product prod3 = new Product("p3", "Ghe gaming", 1000.000);
		Product prod4 = new Product("p4", "Ban hoc em be", 100.000);
		Product prod5 = new Product("p5", "Sac du phong 50.000mA", 700.000);

		ShoppingCart shop1 = new ShoppingCart(cus1);
		shop1.addProduct(prod1);
		shop1.addProduct(prod5);
		shop1.addProduct(prod5);

		ShoppingCart shop2 = new ShoppingCart(cus2);
		shop2.addProduct(prod1);
		shop2.addProduct(prod3);

		ShoppingCart shop3 = new ShoppingCart(cus3);
		shop3.addProduct(prod4);
		shop3.addProduct(prod2);
		
		Company companyX = new Company("Phuong trinh x");
		companyX.addCustomer(cus1);
		companyX.addCustomer(cus2);
		companyX.addCustomer(cus3);
		companyX.addCustomer(cus4);
		
		companyX.addProduct(prod1);
		companyX.addProduct(prod2);
		companyX.addProduct(prod3);
		companyX.addProduct(prod4);
		companyX.addProduct(prod5);
		
		companyX.addShoppingCart(shop1);
		companyX.addShoppingCart(shop2);
		companyX.addShoppingCart(shop3);
		
		System.out.println("So tien phai tra cua cus1 " + companyX.pay(cus1.getId()));
		System.out.println("So tien phai tra cua cus4 " + companyX.pay(cus4.getId()) );
		System.out.println("So tien phai tra cua cus2 " + companyX.pay(cus2.getId()) );
	}
}
