package Ex_5_3_5_9;
/**
 * trong MTIGrade khong co thuoc tinh, day la lop implements lai tu IGrade de dung viec tao list
 */
public class MTIGrade implements IGrade{

	@Override
	public int howManyCredits() {
		return 0;
	}

	@Override
	public double gradeAverage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double sum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public IGrade insert(GradeRecord that) {
		return new ConsIGrade(that, new MTIGrade());
	}

	@Override
	public IGrade sortByGradeDec() {
		return new MTIGrade();
	}

	@Override
	public IGrade greaterThanList(double number) {
		return new MTIGrade();
	}

}
