package Ex_5_3_5_9;

import junit.framework.TestCase;
public class ScoreBoardTest extends TestCase {
	public void test() {
		GradeRecord gr1 = new GradeRecord(23199, "Java Core", 3, 5);
		GradeRecord gr2 = new GradeRecord(23199, "Database", 2, 2);
		GradeRecord gr3 = new GradeRecord(23199, "Java Swing", 3, 10);
		
		IGrade ds1 = new ConsIGrade(gr3, new MTIGrade());
		IGrade ds2 = new ConsIGrade(gr2, new ConsIGrade(gr3, new MTIGrade()));
		IGrade ds3 = new ConsIGrade(gr1, new MTIGrade());
		
		ScoreBoard sb1 = new ScoreBoard("Nguyen Truong Vu", "Khoa 49", ds1);
		ScoreBoard sb2 = new ScoreBoard("Vu Truong Nguyen", "Khoa 49", ds2);
		ScoreBoard sb3 = new ScoreBoard("Nguyen Vu Truong", "Khoa 49", ds3);
		System.out.println(sb1);
		System.out.println("==================");
		System.out.println(sb2);
		System.out.println("==================");
		System.out.println(sb3);
		System.out.println("==================");
		System.out.println(sb2.gradeAverageS());
		System.out.println("==================");
		System.out.println("truoc:" +"\n" + sb2 );
		System.out.println("==================");
		System.out.println("sau: "+ "\n"+ sb2.sortByGradeS());
		System.out.println("==================");
		System.out.println(sb2.greaterThanListS(5));
	}
}
