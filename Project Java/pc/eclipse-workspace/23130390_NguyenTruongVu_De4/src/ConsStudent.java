
public class ConsStudent extends IStudent{
private Student first;
private IStudent rest;

	@Override
public String toString() {
	return "ConsStudent [first=" + first +"\n"+ ", rest=" + rest + "]";
}

	public ConsStudent(Student first, IStudent rest) {
	super();
	this.first = first;
	this.rest = rest;
}

	@Override
	public String getStudents(String title) {
		// TODO Auto-generated method stub
		String str="";
		if(this.first.rest.clasS.equals(title)) {
			str = this.first+this.rest.getStudents(title);
		}else {
			str = this.rest.getStudents(title);
		}
		return str;
	}

	@Override
	public IStudent addSV(Student that) {
		// TODO Auto-generated method stub
		return new ConsStudent(that, this);
	}

	@Override
	public IStudent remove() {
		// TODO Auto-generated method stub
		IStudent ds = null;
		if(this.first.gradeAverage() <1) {
			ds = this.rest.remove();
		}else {
			ds = new ConsStudent(first, this.rest.remove());
		}
		return ds;
	}

}
