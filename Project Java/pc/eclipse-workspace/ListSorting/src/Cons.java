

public class Cons extends DanhSach{
private VuDepTrai v;
private DanhSach ds;
public Cons(VuDepTrai v, DanhSach ds) {
	this.v = v;
	this.ds = ds;
}
//this <= that
@Override
public DanhSach insert(VuDepTrai that) {
	DanhSach ds = null;
	if(that.hasOldSmallerThan(this.v)==true)
		 ds = new Cons(that, this);
	else if(that.hasOldSmallerThan(this.v)==false){
		 ds = new Cons(this.v, this.ds.insert(that));
	}
	return ds;
}
@Override
public String toString() {
	return "Cons [v=" + v +"\n"+ ", ds=" + ds + "]" ;
}
@Override
public DanhSach sort() {
	return  this.ds.sort().insert(this.v);
}
}
