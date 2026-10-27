
public class ConsNhanVien extends DanhSachNhanVien{
private Employee empl;
private DanhSachNhanVien ds;

public ConsNhanVien(Employee empl, DanhSachNhanVien ds) {
	super();
	this.empl = empl;
	this.ds = ds;
}
public Product pro;
//
public void getSalers(Product that) {
	this.pro = that;
	this.toString();
	//this.empl.goi(pro, empl);
//	this.ds.toString();
//		if(this.ds instanceof ConsNhanVien) {
//		this.toString();
//		}else {
//			System.out.println("khong");
//	}
}
@Override
public String toString() {
	this.empl = ((ConsNhanVien)ds).empl;
	this.empl.goi(pro, empl);
	this.ds.toString();
	return "";
}
}
