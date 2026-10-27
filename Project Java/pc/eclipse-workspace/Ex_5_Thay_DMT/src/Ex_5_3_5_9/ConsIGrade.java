package Ex_5_3_5_9;
/**
 * trong ConsIGrade co 2 thuoc tinh
 -GradeRecord first
-IGrade rest

day la lop implements lai tu IGrade de them GradeRecord vao va tao them vi tri cho list
 */
public class ConsIGrade implements IGrade{
	private GradeRecord first;
	private IGrade rest;
	//constructor
	public ConsIGrade(GradeRecord first, IGrade rest) {
		super();
		this.first = first;
		this.rest = rest;
	}
	@Override
	public String toString() {
		return "ConsIGrade [first=" + first +"\n"+ ", rest=" + rest + "]";
	}
	@Override
	public int howManyCredits() {
		return this.first.countCredit() + this.rest.howManyCredits();
	}
	@Override
	public double gradeAverage() {
		return this.sum()/this.howManyCredits();
	}
	@Override
	public double sum() {
		return this.rest.sum()+(this.first.getCredits() * this.first.getGrade());
	}
	//>=
	@Override
	public IGrade insert(GradeRecord that) {
		IGrade ds = null;
		if(that.checkGrade(this.first)) {
			ds = new ConsIGrade(that, this);
		}else {
			ds = new ConsIGrade(this.first, this.rest.insert(that));
		}
		return ds;
	}
	@Override
	public IGrade sortByGradeDec() {
		return this.rest.sortByGradeDec().insert(first);
	}
	@Override
	public IGrade greaterThanList(double number) {
		IGrade ds = null;
		if(this.first.getGrade()> number) {
			ds = new ConsIGrade(first, this.rest.greaterThanList(number));
		}else {
			ds = this.rest.greaterThanList(number);
		}
		return ds;
	}
}
