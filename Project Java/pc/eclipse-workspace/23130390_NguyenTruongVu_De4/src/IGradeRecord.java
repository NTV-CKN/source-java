
public abstract class IGradeRecord {
	public abstract String getTenMH();
	public abstract int howManyCredits();
	public abstract double sumProduct();
	public abstract double resultAverage();
	public abstract IGradeRecord sortByDec();
	public abstract IGradeRecord insert(GradeRecord that);
	public abstract String getGreater(double save);
}
