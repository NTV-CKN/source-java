package Ex_5_5;
/**
 * trong Source khong thuoc tinh nao va duoc ke thua 1 thuoc tinh tu ARiver
 
 vidu
		ARiver ars1 = new Source(lc1, 120);
		ARiver ars2 = new Source(lc2, 50);
		ARiver ars3 = new Source(lc3, 100);
 */
public class Source extends ARiver{
	//constructor
	public Source(Location location, int length) {
		super(location, length );
		
	}
	//toString
	@Override
	public String toString() {
	//	System.out.print("\n");
	//	int count2 = super.countSave();
		
//		for(int j = 0; j <= count2; j++ ) {
//			System.out.print("\t");
//			
//		}
		System.out.print("|__");
		System.out.println("Source: " + this.location.toString() + " "+this.length);
		//return "Source: " + this.location.toString() + " "+this.length;
		return "";
	}
}
