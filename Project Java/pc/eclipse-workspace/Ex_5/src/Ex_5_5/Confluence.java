package Ex_5_5;

import java.util.Iterator;

/**
 * trong Confluence co 2 thuoc tinh:
-ARiver left
-ARiver right

2 thuoc tinh nay dung ta them 1 source hoac 1 Confluence tu do tao thanh 1 list va list nay dung lai cho den khi ta new Source
 
 vidu
		ARiver b = new Confluence(lc4,60, ars1, ars2);
		ARiver a = new Confluence(lc5,30, ars3, b);
 */
public class Confluence extends ARiver{
	private ARiver left, right;//trai phai	
	int baba;
	//constructor
	public Confluence(Location location, int length , ARiver left, ARiver right, int i) {
		super(location, length);
		this.left = left;
		this.right = right;
		this.baba = i;
	}
	//toString
//	@Override
//	public String toString() {
//		
//		return "Confluence: " +"length: "+this.length+"\n"+"left: " + left.toString() + "\n"+"right: " + right.toString();
//	}

	public int getBaba() {
		return baba;
	}

	public void setBaba(int baba) {
		this.baba = baba;
	}

	@Override
	public String toString() {
//	int baba = super.countSave();//1
		//int j = 1;
		this.setBaba(Count.count());

		System.out.print("\n"); 

		for(int i = 0; i <this.getBaba();i++) {
			System.out.print("\t");
		}System.out.print("|__");
		System.out.println("Confluence: " +"length: "+this.length); 
		System.out.print("\n");
		for(int i = 0; i <=this.getBaba();i++) {
			System.out.print("\t");
		}	System.out.print(left.toString()); //
	
	System.out.print("\n");
		//this.setBaba(j+1);
		for(int i = 0; i <=this.getBaba();i++) {
			System.out.print("\t");
		}
		System.out.println(right.toString());
		
		return "";
		//return "Confluence: " +"length: "+this.length + left.toString()+ right.toString();
	}
}
