package thide2;

import java.util.ArrayList;
import java.util.List;

public class Cau3 {
	 List<Subject> listSubject;
	 List<Student> listStu;

	public void createList() {
		Subject subjects[] = { new Subject("123", "LTNC", 4), new Subject("124", "CTMT", 2),
				new Subject("125", "LTNC", 2), new Subject("126", "LTNC", 1), new Subject("127", "CTMT", 3),
				new Subject("128", "LTCB", 4), new Subject("129", "LTCB", 3), new Subject("130", "LTCB", 2),
				new Subject("131", "LTNC", 2), new Subject("132", "LTCB", 3) };
		Student students[] = { new Student("001", "Vu", subjects[0], 9), new Student("002", "Vy", subjects[1], 8),
				new Student("003", "Vo", subjects[2], 9), new Student("004", "Viet", subjects[3], 1),
				new Student("005", "Van", subjects[4], 9), new Student("006", "Hoa", subjects[5], 3),
				new Student("007", "Tho", subjects[6], 4), new Student("008", "Hoan", subjects[7], 6),
				new Student("009", "Cong", subjects[8], 7), new Student("010", "Ba", subjects[9], 4) };
		listStu = new ArrayList<Student>();
		for (int i = 0; i < students.length; i++) {
			listStu.add(students[i]);
		}
		listSubject = new ArrayList<Subject>();
		for (int i = 0; i < subjects.length; i++) {
			listSubject.add(subjects[i]);
		}
	}

	public static double diemTB(List<Student> list) {
		double sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i).getDiem();
		}
		return sum / list.size();
	}

	public static void main(String[] args) {
		Cau3 c3 = new Cau3();
		c3.createList();
		System.out.println(diemTB(c3.listStu));
	}
}
