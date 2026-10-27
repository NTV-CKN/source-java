
public class MTIStudent extends IStudent{

	@Override
	public String getStudents(String title) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public IStudent addSV(Student that) {
		// TODO Auto-generated method stub
		return new ConsStudent(that, new MTIStudent());
	}

	@Override
	public IStudent remove() {
		// TODO Auto-generated method stub
		return new MTIStudent();
	}

}
