package Ex_5_3;

import java.util.Objects;

/**
 * trong  ConstructRestaurant se co 2 thuoc tinh giup tao danh sach nha hang:
 -IRestaurants iRest
 -Restaurant rest
 */
public class ConstructRestaurant implements IRestaurants{
	private Restaurant rest;//nha hang
	private IRestaurants iRest;//them 1 constructor moi
	//constructor
	public ConstructRestaurant(Restaurant rest, IRestaurants iRest) {
		this.rest = rest;
		this.iRest = iRest;
	}
	//toString
	@Override
	public String toString() {
		return "ConsRestaurant: " + rest.toString() + "\n"  + iRest.toString();
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
		ConstructRestaurant other = (ConstructRestaurant) obj;
		return Objects.equals(iRest, other.iRest) && Objects.equals(rest, other.rest);
	}
	
}
