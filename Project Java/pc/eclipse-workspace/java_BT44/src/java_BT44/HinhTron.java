package java_BT44;

public class HinhTron extends Hinh {
	protected double r;
public HinhTron (ToaDoa toadoa, double r){
         super(toadoa);
         this.r = r;
}

public double getR() {
	return r;
}

public void setR(double r) {
	this.r = r;
}

@Override
public double tinhDienTich() {
	return (Math.PI*r*r);
}

}
