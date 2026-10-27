package Ex_5_3_5_9;
/**
 * trong ScoreBoard co 3 thuoc tinh:
-String name
-String classKH
-IGrade rest

vidu
		
		ScoreBoard sb1 = new ScoreBoard("Nguyen Truong Vu", "Khoa 49", ds1);
		ScoreBoard sb2 = new ScoreBoard("Vu Truong Nguyen", "Khoa 49", ds2);
		ScoreBoard sb3 = new ScoreBoard("Nguyen Vu Truong", "Khoa 49", ds3);
 */
public class ScoreBoard {
	private String name;//ten sv
	private String classKH;//khoa hoc
	private IGrade rest;//ds diem
	//constructor
	public ScoreBoard(String name, String classKH, IGrade rest) {
		this.name = name;
		this.classKH = classKH;
		this.rest = rest;
	}
	@Override
	public String toString() {
		return "ScoreBoard [name=" + name + ", classKH=" + classKH + ", rest=" + rest + "]";
	}
	//
	public double gradeAverageS() {
		return this.rest.gradeAverage();
	}
	//
	public IGrade sortByGradeS() {
		return this.rest.sortByGradeDec();
	}
	//
	public IGrade greaterThanListS(double number) {
		return this.rest.greaterThanList(number);
	}
}
