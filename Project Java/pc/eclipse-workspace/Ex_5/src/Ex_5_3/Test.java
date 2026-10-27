package Ex_5_3;
import junit.framework.*;
public class Test extends TestCase{
	public void testIRestaurants() {
		//khoi tao Intersection
		Intersection inter1 = new Intersection(12, "Hung Vuong");
		Intersection inter2 = new Intersection(9, "Hoang Hoa Tham");
		//khoi tao Restaurant
		Restaurant rest1 = new Restaurant("Hong Phat", "Vietnamese", "120k den 800k", inter1);
		Restaurant rest2 = new Restaurant("Hong Ki", "French", "1 trieu den 4 trieu", inter2);
		//khoi tao list
		IRestaurants irest1 = new ConstructRestaurant(rest1, new ConstructRestaurant(rest2, new MTRestaurant()));
		IRestaurants irest2 = new MTRestaurant();
		//sysout
		System.out.println(irest1);
		System.out.println(irest2);
	}
}
