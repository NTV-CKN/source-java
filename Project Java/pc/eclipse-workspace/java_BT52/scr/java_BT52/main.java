package java_BT52;

public class main {
public static void main(String[] args) {
	String v0 = "     haha ga    ";
	String v1 = "Hello may cung nha";
	String v2 = "da den voi cai cho neo cua chuy!";
	//ham concat
	String v3 = v1.concat(v2);
	System.out.println(v3);
	
	//ham replace
	String v4 = v1.replaceAll("Hello may cung","lo cc" );
	System.out.println(v4);
	
	// ham trim
	String v5 = v0.trim();
	System.out.println(v5);
	
	//ham toCharArray
	char[] vu6 = v1.toCharArray() ;
	System.out.println(vu6);
	System.out.println();
	for (int i = 0; i < vu6.length; i++) {
		if (i>=2 && i<=4) {
					System.out.print(vu6[i]);
		}
	}
	
	// ham subString
	String s7 = v1.substring(7, 9);
	System.out.println("\n"+ s7);
}
}
