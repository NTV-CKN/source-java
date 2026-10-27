package Ex_5_5;
/**
 * trong RiverSystem co 2 thuoc tinh:
-Mouth mouth
-ARiver river

vidu
		//RiverSystem
		RiverSystem rs = new RiverSystem(mouth, a);
		//sysout
		System.out.println(rs);
 */
public class RiverSystem {
	private Mouth mouth;
	private ARiver river;
	
	//constructor
	public RiverSystem(Mouth mouth, ARiver A ) {
		this.mouth = mouth;
		this.river = A;
	}
	//toString
	@Override
	public String toString() {
		System.out.print("RiverSystem: " +"\n" +mouth.toString() );  
		System.out.print(river.toString());
		return "";
	}

}
