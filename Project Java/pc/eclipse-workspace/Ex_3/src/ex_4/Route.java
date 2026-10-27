package ex_4;
/**
 * trong Route co 2 thuoc tinh:
 - String origin
- String destination
 */
public class Route {
	 private String origin;
	 private String destination;
	 //constructor
	public Route(String origin, String destination) {
		this.origin = origin;
		this.destination = destination;
	}
	//setter and getter
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
}
