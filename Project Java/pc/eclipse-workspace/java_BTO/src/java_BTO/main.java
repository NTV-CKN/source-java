package java_BTO;

public class main {
	public static void main(String[] args) {
		QuocGia qg1 = new QuocGia(123, "VN");
		QuocGia qg2 = new QuocGia(132, "JP");
		QuocGia qg3 = new QuocGia(142, "RUS");

		HangSX hsx1 = new HangSX(qg1, "Asus");
		HangSX hsx2 = new HangSX(qg2, "Acer");
		HangSX hsx3 = new HangSX(qg3, "Dell");

		NgaySX nsx1 = new NgaySX(06, 01, 2005);
		NgaySX nsx2 = new NgaySX(01, 01, 2005);
		NgaySX nsx3 = new NgaySX(03, 01, 2005);

		MayTinh mt1 = new MayTinh(hsx1, nsx1, 120.000, 24);
		MayTinh mt2 = new MayTinh(hsx2, nsx3, 100.000, 36);
		MayTinh mt3 = new MayTinh(hsx3, nsx3, 200.000, 12);

		if (mt1.soSanh(mt2) == true) {
			System.out.println("Gia cua may " + hsx1.getTenHang() + " co gia mac hon " + hsx2.getTenHang());
		} else {
			System.out.println("Gia cua may " + hsx1.getTenHang() + " co gia re hon " + hsx2.getTenHang());

		}

		if (mt1.soSanh(mt3) == true) {
			System.out.println("Gia cua may " + hsx1.getTenHang() + " co gia mac hon " + hsx3.getTenHang());
		} else {
			System.out.println("Gia cua may " + hsx1.getTenHang() + " co gia re hon " + hsx3.getTenHang());

		}

		if (mt3.soSanh(mt2) == true) {
			System.out.println("Gia cua may " + hsx3.getTenHang() + " co gia mac hon " + hsx2.getTenHang());
		} else {
			System.out.println("Gia cua may " + hsx3.getTenHang() + " co gia re hon " + hsx2.getTenHang());

		}
		System.out.println("======");
		
		System.out.println("Ten quoc gia: "+qg1.getTenQG());
		System.out.println("Ten quoc gia: "+qg2.getTenQG());
		System.out.println("Ten quoc gia: "+qg3.getTenQG());

	}
}
