package ThoiKhoaBieu;

public class tkb {
private Day ngay;
private String monHoc;
public tkb(Day ngay, String monHoc) {
	this.ngay = ngay;
	this.monHoc = monHoc;
}
@Override
public String toString() {
	return "Thu " + ngay + ",  hoc mon :" + monHoc + "";
}

}
