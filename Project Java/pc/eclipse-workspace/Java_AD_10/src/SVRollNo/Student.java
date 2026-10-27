package SVRollNo;

import java.io.Serializable;

public class Student implements Serializable{
	private String rollNo;

	public Student(String rollNo) {
		super();
		this.rollNo = rollNo;
	}

	public String getRollNo() {
		return rollNo;
	}

	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	//add

	@Override
	public String toString() {
		return rollNo;
	}
}
