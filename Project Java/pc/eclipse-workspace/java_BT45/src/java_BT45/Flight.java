package java_BT45;

public class Flight extends PhuongTienDiChuyen{
private String loaiNhienLieu;

public Flight(String loaiPhuongTien, HangSX hsx, String loaiNhienLieu) {
	super(loaiPhuongTien, hsx);
	this.loaiNhienLieu = loaiNhienLieu;
}
public void catCanh() {
	System.out.println("bur bur lmao catcanh");
}
public void haCanh() {
	System.out.println("ha canh khan cap!!!");
}
@Override
public double layVanToc() {
	return 600.000;
}
}
