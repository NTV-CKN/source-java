package Ex_5_5;
/**
 * trong ARiver co 2 thuoc tinh:
#Location location
#int length
 day la lop bo cua 2 lop Source va Confluence giup tao thanh list
 */
public class ARiver {
	protected Location location;//toa do
	protected int length;//do dai
	protected int save = 0;//1
	//constructor
	public ARiver(Location location, int length) {
		this.location = location;
		this.length = length;	
	}
	//toString
//	@Override
//	public String toString() {
//		System.out.print("River:");
//		for(int i = 0; i< save; i++) {
//			System.out.print(conflu.toString());
//			this.save = 1;
//			System.out.print(scr.toString());
//		}
//		
//		return "";
//	}
	
	public int countSave() {
		save+=1;
		this.setSave(save);
		return save;
	}

	public int getSave() {
		return save;
	}

	public void setSave(int save) {
		this.save = save;
	}
}
