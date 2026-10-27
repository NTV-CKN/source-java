import java.util.ArrayList;
import java.util.List;

public class Method {
	private Student student;
	private List<Student> list;
	
	public Method() {
	
	}
	
	public Method(Student student, List<Student> b) {
		this.student = student;
		this.list =b;
			}

	//add
	public void addSV() {
			list.add(student);	
	}
	//remove
	public void removeSV() {
			list.removeAll(list);
	}
	//in 
	public void printSV() {
		for(Student stu : list) {
			System.out.println(stu);
		}
	}
}
