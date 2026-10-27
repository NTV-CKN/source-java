
public class Test {
public static void main(String[] args) {
	GradeRecord gR1 = new GradeRecord(1, "Ki nang giao tiep", 2, 0);
	GradeRecord gR2 = new GradeRecord(2, "Huong doi tuong", 4, 5);
	GradeRecord gR3 = new GradeRecord(3, "Giao tiep nguoi may", 4, 6.3);
	GradeRecord gR4 = new GradeRecord(4, "GDQP", 2, 0);
	//1 4
	IGradeRecord iGR1 = new ConsIGradeRecord(gR1, new ConsIGradeRecord(gR4, new MTIGrade()));
	//2 3
	IGradeRecord iGR2 = new ConsIGradeRecord(gR2, new ConsIGradeRecord(gR3, new MTIGrade()));
	// 1 2 3 4
	IGradeRecord iGR3 = new ConsIGradeRecord(gR1, new ConsIGradeRecord(gR2, new ConsIGradeRecord(gR3, new ConsIGradeRecord(gR4, new MTIGrade()))));
	
	ScoreBoard sB3 = new ScoreBoard("Nguyen Truong Vu", "DH23DTC", iGR3);
	ScoreBoard sB2 = new ScoreBoard("Lam Vy Da", "DH23DMT12", iGR2);
	ScoreBoard sB1 = new ScoreBoard("Trang Khan", "DH23VC1", iGR1);
	
	Student student3 = new Student(sB3);
	Student student2 = new Student(sB2);
	Student student1 = new Student(sB1);
	
	IStudent ds = new ConsStudent(student1, new ConsStudent(student2, new ConsStudent(student3, new MTIStudent())));
	
	
	System.out.println("======================");
	System.out.println(iGR3.howManyCredits());
	System.out.println("======================");
	System.out.println(student1.gradeAverage());
	System.out.println(student2.gradeAverage());
	System.out.println(student3.gradeAverage());
	System.out.println("======================");
	System.out.println("Ban dau: "+iGR3);
	System.out.println("Sau khi sort: \n"+ iGR3.sortByDec());
	System.out.println("======================");
	System.out.println(sB3.greaterThanList(4));
	System.out.println("======================");
	System.out.println(ds.getStudents("DH23DTC"));
	System.out.println("======================");
	System.out.println(ds.addSV(student1));
	System.out.println("======================");
	System.out.println(ds.remove());
}
}
