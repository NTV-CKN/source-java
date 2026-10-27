
public class ConsIGradeRecord extends IGradeRecord{
private GradeRecord first;
private IGradeRecord rest;

	@Override
public String toString() {
	return "ConsIGradeRecord [first=" + first +"\n"+ ", rest=" + rest + "]";
}

	public ConsIGradeRecord(GradeRecord first, IGradeRecord rest) {
	super();
	this.first = first;
	this.rest = rest;
}

	@Override
	public String getTenMH() {
		// TODO Auto-generated method stub
		return this.first.getTenMH();
	}

	@Override
	public int howManyCredits() {
		// TODO Auto-generated method stub
		return this.first.getCredits()+this.rest.howManyCredits();
	}

	@Override
	public double sumProduct() {
		// TODO Auto-generated method stub
		return (this.first.getGrade()*this.first.getCredits()) + this.rest.sumProduct();
	}

	@Override
	public double resultAverage() {
		// TODO Auto-generated method stub
		return this.sumProduct()/this.howManyCredits();
	}

	@Override
	public IGradeRecord sortByDec() {
		// TODO Auto-generated method stub
		return this.rest.sortByDec().insert(first);
	}
//giam dan
	@Override
	public IGradeRecord insert(GradeRecord that) {
		// TODO Auto-generated method stub
		IGradeRecord ds = null;
		if(this.first.getGrade()< that.getGrade()) {
			ds = new ConsIGradeRecord(that, this);
		}else {
			ds = new ConsIGradeRecord(this.first, this.rest.insert(that));
		}
		return ds;
	}

	@Override
	public String getGreater(double save) {
		// TODO Auto-generated method stub
		String str="";
		if(this.first.getGrade() > save) {
			str = this.first + this.rest.getGreater(save);
		}else {
			str = this.rest.getGreater(save);
		}
		return str;
	}

}
