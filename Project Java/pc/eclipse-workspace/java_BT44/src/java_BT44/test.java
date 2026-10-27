package java_BT44;

public class test {
public static void main(String[] args) {
	ToaDoa td1 = new ToaDoa(2, 1);
	ToaDoa td2 = new ToaDoa(1, 5);
	ToaDoa td3 = new ToaDoa(5, 0);
	
	Hinh h1 = new Diem(td1);
	HinhTron h2 = new HinhTron(td2, 3);
	
	System.out.println(h1.tinhDienTich());
	System.out.println(Math.round(h2.tinhDienTich())*100/100);
	h2.getR();
}
}
