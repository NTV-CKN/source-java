package Ex_6_9;



public class test {
public static void main(String[] args) {
	//khoi tao Location
	Location lc1 = new Location(1, 1, "s");//Source
	Location lc2 = new Location(1, 5, "t");//Source
	Location lc3 = new Location(3, 7, "u");//Source
	
	Location sss = new Location(100, 100, "xx");
	
	Location lc4 = new Location(3, 3, "b");//Confluence
	Location lc5 = new Location(5, 5, "a");//Confluence
	Location lc6 = new Location(7, 5, "m");//Mouth
	ARiver ars1 = new Source(lc1, 120);
	ARiver ars2 = new Source(lc2, 50);
	ARiver ars3 = new Source(lc3, 100);
	
	ARiver b = new Confluence(lc4,60, ars1, ars2);
	ARiver a = new Confluence(lc5,30, ars3, b);
	ARiver c = new Confluence(lc6, 123, ars2, a);
	
	Mouth mouth = new Mouth(lc6, c);
	//getNumberSources
	System.out.println(mouth.getNumberSource());
	System.out.println("========================");
	//checkLocationS
	System.out.println(mouth.checkLocationS(sss));
	System.out.println(mouth.checkLocationS(lc4));
	System.out.println("========================");
	//getMilesARiver
	System.out.println(b.getMilesARiver());
	System.out.println(a.getMilesARiver());
	System.out.println(mouth.getMilesMouth());
	System.out.println("========================");
	//checkRadiusS
	System.out.println(mouth.checkLocationS(lc1));//true
	System.out.println(mouth.checkLocationS(sss));//false
	System.out.println(c.checkRadiusLocation(lc6));//true
	System.out.println(a.checkRadiusLocation(sss));//false
	System.out.println("========================");
	//maxLength
	System.out.println(c.maxLength());//123
	System.out.println(a.maxLength());//100
	System.out.println("========================");
	//locations
	System.out.println(mouth.locations());
}
}
