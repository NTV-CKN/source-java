package Ex_6_3;
/**
 * trong ILog co 3 phuong thuc abstract:
+double miles()
	=>return ve tong so dam ma nguoi chay trong 1 thang nhat dinh
+double maxDistance()
	=>return ve khoang cach lon nhat 
+ILog getLogs(int month, int year)
	=>return ve 1 ILog chua cac Entry cung month va year
 */
public abstract class ILog {
	public abstract double miles();
	public abstract double maxDistance();
	public abstract ILog getLogs(int month, int year);
}
