package model;
/*
 * trong ModelThongKe co 3 thuoc tinh la vanBan, tuKhoa, thongKe
 */
public class ModelThongKe {
	private String vanBan, tuKhoa, thongKe;
	//constructor
	public ModelThongKe() {
		this.vanBan = "";
		this.tuKhoa = "";
		this.thongKe = "";
	}
	//getter and setter
	public String getVanBan() {
		return vanBan;
	}
	public void setVanBan(String vanBan) {
		this.vanBan = vanBan;
	}
	public String getTuKhoa() {
		return tuKhoa;
	}
	public void setTuKhoa(String tuKhoa) {
		this.tuKhoa = tuKhoa;
	}
	public String getThongKe() {
		return thongKe;
	}
	public void setThongKe(String thongKe) {
		this.thongKe = thongKe;
	}
	//method thong ke
	public String thongKe() {
		int dem = 0, viTri =0;String h;
		while(true) {
		int i =	this.vanBan.indexOf(this.tuKhoa, viTri);
			if(i < 0) {
				break;
			}else {
				dem++;
				viTri = i + 1;
			}
		}
		return  h ="Co "+dem+" "+this.tuKhoa;
	//	System.out.println("Co "+dem+" "+this.tuKhoa);
	}
}
