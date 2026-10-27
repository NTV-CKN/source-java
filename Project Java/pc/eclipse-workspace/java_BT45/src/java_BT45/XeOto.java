package java_BT45;

public class XeOto extends PhuongTienDiChuyen{
private String tenLoaiNhienLieu;

public XeOto(String loaiPhuongTien, HangSX hsx, String tenLoaiNhienLieu) {
	super(loaiPhuongTien, hsx);
	this.tenLoaiNhienLieu = tenLoaiNhienLieu;
}
@Override
public double layVanToc() {
	return 250.000;
}


}
