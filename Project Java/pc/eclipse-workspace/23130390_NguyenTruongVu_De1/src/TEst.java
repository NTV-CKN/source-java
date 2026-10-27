
public class TEst {
public static void main(String[] args) {
	Date dsx1 = new Date(1, 7, 2023);
	Date dsx2 = new Date(1, 12, 2022);
	Date dsx3 = new Date(12, 9, 2019);
	
	Date dhh1 = new Date(23, 12, 2021);
	Date dhh2 = new Date(23, 12, 2023);
	Date dhh3 = new Date(21, 12, 2022);
	
	Specification spec1 = new Specification(12, 2);
	Specification spec2 = new Specification(32, 3);
	Specification spec3 = new Specification(2, 6);
	
	Manufactor manu1 = new Manufactor("Nguyen Vu", "VI");
	Manufactor manu2 = new Manufactor("Vu", "VI");
	Manufactor manu3 = new Manufactor("Ngu", "VI");
	
	Milk milk1 = new Milk("Sua oc cho", 1, 12, spec1, manu1, dsx1, dhh1);
	Milk milk2 = new Milk("Sua con bo", 12, 2, spec2, manu2, dsx2, dhh2);
	Milk milk3 = new Milk("Sua co gai ha lan", 3, 15, spec3, manu3, dsx3, dhh3);
	
	IMilk i1 = new ConsMilk(milk1, new ConsMilk(milk2, new ConsMilk(milk3, new MTMilk())));
	
	System.out.println(milk1.sameCompany("Nguyen Vu"));
	System.out.println("+========================+");
	System.out.println(milk2.greaterThan(milk3));
	System.out.println("+========================+");
	System.out.println(milk3.produceAfter(dsx1));
	System.out.println(milk2.produceAfter(dsx3));
	System.out.println("+========================+");
	System.out.println(milk2.isExpired());
	System.out.println(milk3.isExpired());
	System.out.println(milk1.isExpired());
	System.out.println("+========================+");
	System.out.println("Ban dau: "+"\n" +i1);
	System.out.println("Sau khi sort: "+"\n"+ i1.sortByVolumn());
	System.out.println("+========================+");
	System.out.println(i1.listSameManufactor(manu2));
	System.out.println("+========================+");
	System.out.println(i1.deleteExpired());
}
}
