package Ex_5_3;

import java.util.Objects;

/**
 * trong Restaurant co 4 thuoc tinh:
-String name
-String priceRange
-String kindFood
-Intersection inter

vidu
Restaurant rest1 = new Restaurant("Hong Phat", "Vietnamese", "120k den 800k", inter1);
Restaurant rest2 = new Restaurant("Hong Ki", "French", "1 trieu den 4 trieu", inter2);
		
 */
public class Restaurant {
	private String name;//ten nha hang
	private String kindFood;//loai do an
	private String priceRange;//pham vi gia
	private Intersection inter;//duong
	//constructor
	public Restaurant(String name, String kindFood, String priceRange, Intersection inter) {
		this.name = name;
		this.kindFood = kindFood;
		this.priceRange = priceRange;
		this.inter = inter;
	}
	//toString
	@Override
	public String toString() {
		return "name: " + name + ", kindFood: " + kindFood + ", priceRange: " + priceRange + ", inter: " + inter;
	}
	//equals
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		return Objects.equals(inter, other.inter) && Objects.equals(kindFood, other.kindFood)
				&& Objects.equals(name, other.name) && Objects.equals(priceRange, other.priceRange);
	}
}
