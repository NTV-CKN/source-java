package Ex_5_3_6_1;

import java.util.Objects;

/**
 * trong Cons co 2 thuoc tinh va 4 phuong thuc duoc Override lai tu Inventory:
 Toy first
 Inventory rest
 
 */
public class Cons extends Inventory{	
		private Toy first;
		private Inventory rest;
		//constructor
		public Cons(Toy first, Inventory rest) {
			super();
			this.first = first;
			this.rest = rest;
		}
		@Override
		public String toString() {
			return "Cons [first=" + first + "\n"+", rest=" + rest + "]";
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Cons other = (Cons) obj;
			return Objects.equals(first, other.first) && Objects.equals(rest, other.rest);
		}
		
		@Override
		public boolean contains(String name) {
			boolean boo = false;
			if(this.first.name.equals(name)==false) {
				boo = this.rest.contains(name);
			}else {
				boo = true;
			}
			return boo;
		}
		@Override
		public boolean isBelow(double priceThat) {
			boolean boo  =	false;
			if(this.first.price < priceThat) {
				boo = this.rest.isBelow(priceThat);
			}else {
				boo = false;
			}
			return boo;
		}
		@Override
		public int howMany() {
			return Count.count;
		}
		@Override
		public Inventory priceRaise(double rate) {
			Toy toy = new Toy(this.first.name, this.first.price*(1+rate), this.first.available);
			return new Cons(toy, rest.priceRaise(rate));
			
		}
		@Override
		public double averagePrice() {
			Tong.tong(this.first.price);
			this.rest.averagePrice();
			return Tong.tong/Count.count;
		}
		@Override
		public void replaceName(Inventory list) {
			Cons ds = (Cons) list;
			if(ds.first.name.equals("Robot") == false) {
			ds.rest.replaceName(ds.rest);
			}else if(ds.first.name.equals("Robot") == true) {
				ds.first.setName("R2d2");
				ds.rest.replaceName(ds.rest);
			}
		}
		@Override
		public Inventory eliminate(String toyOfName) {
			Inventory ds = new Cons(this.first, 	this.rest.eliminate(toyOfName));
			if(this.first.name.equals(toyOfName)) {
				ds =  this.rest.eliminate(toyOfName);
			}else {
				ds = new Cons(this.first, this.rest.eliminate(toyOfName));
			}
			return ds;
		}
		
}
