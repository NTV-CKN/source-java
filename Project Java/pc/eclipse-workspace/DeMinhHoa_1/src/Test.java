import java.util.List;

public class Test {
public static void main(String[] args) {
	Produce pd1 = new Produce(110, "May Rung", 23, "noi dia");
	Produce pd2 = new Produce(114, "May Danh Trung", 53, "ngoai dia");
	Produce pd3 = new Produce(1110, "May Giam", 2, "noi dia");
	Produce pd4 = new Produce(130, "May Danh", 21, "noi dia");
	
	ListProduce ds1 = new ConsProduce(pd1, new ConsProduce(pd2, new ConsProduce(pd3, new ConsProduce(pd4, new MTProduce()))));
	ListProduce ds2 = new ConsProduce(pd3, new ConsProduce(pd4, new MTProduce()));

	Date date = new Date(2, 2,1222);
	
	Staff staff1 = new Staff(123, "Vu dep trai", "Ko noi dau", date, 12, 21, "an hai dai khai");
	Staff staff2 = new Staff(124, "Vu dep trai", "Ko noi dau ahihi", date, 12, 21, "an hai dai khai");
	
	SaleStaff sT1 = new SaleStaff(221, "Vu dep chai", "Khong noi", date, 1,10, ds1);
	SaleStaff sT2 = new SaleStaff(222, "Vu dep chai st1", "Khong noi", date, 1,10, ds2);
	
	ListE dsE2 = new ConsE(sT2, new MTE());
	ListE dsE1 = new ConsE(sT1, new ConsE(sT2, new ConsE(staff1, new ConsE(staff2, new MTE()))));
	
	System.out.println(dsE2.howManyE());
	System.out.println("=======================");
	System.out.println(staff1.salary());
	System.out.println("=======================");
	System.out.println(staff1.isProduce(pd4));
	System.out.println(sT2.isProduce(pd1));
	System.out.println(sT1.isProduce(pd4));
	System.out.println("=======================");
	System.out.println(dsE1.getSalers(pd4));
	System.out.println("=======================");
	System.out.println(dsE2.getSalers(pd4));
	System.out.println("=======================");
	System.out.println("Ban dau");
	System.out.println(ds1);
	System.out.println("Sau phan ung");
	System.out.println(ds1.sortByTitle());
	System.out.println("=======================");
	System.out.println(ds1.totalSL("noi dia"));
	System.out.println(ds1.totalSL("ngoai dia"));
	System.out.println("=======================");
	System.out.println("truoc");
	System.out.println(ds1);
	System.out.println("sau");
	System.out.println(ds1.pLSP("ngoai dia"));
}
}
