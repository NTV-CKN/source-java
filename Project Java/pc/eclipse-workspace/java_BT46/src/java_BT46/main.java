package java_BT46;

public class main {
public static void main(String[] args) {
	System.out.println("Test cau a: ");
	//May casioFX500
MayTinhBoTuiInterface mtFX = new CasioFX500();
MayTinhBoTuiInterface mtm = new Casio500M();
System.out.println("CasioFX500 5+3= "+mtFX.plus(5, 3));
System.out.println("CasioFX500 5-3= "+mtFX.except(5, 3));
System.out.println("CasioFX500 5+3= "+mtFX.multiply(5, 3));
mtFX.divide(5, 0);
//May casio500M
System.out.println("=====-=====");
System.out.println("Casio500M 5+3= "+mtm.plus(5, 3));
System.out.println("Casio500M 5-3= "+mtm.except(5,3));
System.out.println("Casio500M 5x3= "+mtm.multiply(5, 3));
mtm.divide(5, 0);

//ArraySort
System.out.println("test cau b: ");
SapXepInterface sxchon = new SapXepChon();
SapXepInterface sxchen = new SapXepChen();

double[] arr = new double[] {1, 6, 9, 2, 4, 5};
double [] arr2 = new double[] {2, 12, 32, 1, 200};
sxchon.SapXepTang(arr);
	System.out.println("sap xep chon tang dan: ");
for (int i = 0; i < arr.length; i++) {
	System.out.print(arr[i] + "  ");
}
	sxchen.SapXepTang(arr2);
			System.out.println("\nsap xep chen tang dan: ");

	for (int j = 0; j < arr2.length; j++) {
		System.out.print(arr2[j]+ "  ");
	}

	System.out.println("\ntest cau c");
	PhanMemMayTinh pmmt = new PhanMemMayTinh();
	pmmt.SapXepGiam(arr);
	System.out.println("sap xep chon giam dan: ");
for (int i = 0; i < arr.length; i++) {
	System.out.print(arr[i] + "  ");
}
}
}
