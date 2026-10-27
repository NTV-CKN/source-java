package SVRollNo;

import java.util.ArrayList;
import java.util.List;

public class SharedData {
	List<Student>listValid;
	List<String>listUnValid;
	
	String rollNoo;
	int index;
	boolean boole = true;
	public SharedData() {
		listValid = new ArrayList<Student>();
		listUnValid= new ArrayList<String>();
		index = 0;
	}
	public List<Student> getListValid() {
		return listValid;
	}
	public void setListValid(List<Student> listValid) {
		this.listValid = listValid;
	}
	public List<String> getListUnValid() {
		return listUnValid;
	}
	public void setListUnValid(List<String> listUnValid) {
		this.listUnValid = listUnValid;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	//add
	public void addValid(String str) {
		Student stu = new Student(str);
		this.listValid.add(stu);
	}
	public void addUnValid(String str) {
		this.listUnValid.add(str);
	}
	public boolean isBoole() {
		return boole;
	}
	public void setBoole(boolean boole) {
		this.boole = boole;
	}
	
	//luu rollno
	public void setRollNo(String str) {
		this.rollNoo = str;
	}
	public String getRollNo() {
		return this.rollNoo;
	}
}
