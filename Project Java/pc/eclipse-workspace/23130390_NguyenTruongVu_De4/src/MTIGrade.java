
public class MTIGrade extends IGradeRecord{

	@Override
	public String getTenMH() {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public int howManyCredits() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double sumProduct() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double resultAverage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IGradeRecord sortByDec() {
		// TODO Auto-generated method stub
		return new MTIGrade();
	}

	@Override
	public IGradeRecord insert(GradeRecord that) {
		// TODO Auto-generated method stub
		return new ConsIGradeRecord(that, new MTIGrade());
	}

	@Override
	public String getGreater(double save) {
		// TODO Auto-generated method stub
		return "";
	}

}
