
public class ConsMilk implements DanhSach{
private Milk milk;
private DanhSach ds;
public ConsMilk(Milk milk, DanhSach ds) {
	super();
	this.milk = milk;
	this.ds = ds;
}
@Override
public String toString() {
	return "ConsMilk [milk=" + milk.toString() +"\n"+ ", ds=" + this.ds.toString() + "]";
}

}
