package java_BT45;

public class main {
 public static void main(String[] args) {
	HangSX hsx1 = new HangSX("toyota", "Japan");
	HangSX hsx2 = new HangSX("Huyndai", "China");
	HangSX hsx3 = new HangSX("HaiCang", "Viet Nam");
 
	PhuongTienDiChuyen pt1 = new XeDap("xe dap", hsx1);
	Flight pt2 = new Flight("may bay", hsx3, "xang");
	PhuongTienDiChuyen pt3 = new XeOto("xe oto", hsx2, "xang");

	System.out.println("van toc xe dap: "+pt1.layVanToc());
	System.out.println("van toc may bay: "+pt2.layVanToc());
	System.out.println("van toc oto: "+pt3.layVanToc());
System.out.println("============");
	pt2.batDau();
	pt2.catCanh();
	pt2.dungLai();
}
}
