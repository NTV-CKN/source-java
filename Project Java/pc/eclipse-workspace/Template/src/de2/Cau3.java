package de2;

import java.util.ArrayList;
import java.util.List;

public class Cau3 {
	private List<MonHoc> listMonHoc = new ArrayList<MonHoc>();
	private List<Student> listStudent = new ArrayList<Student>();

	public void createArr() {
		MonHoc[] mhs = { new MonHoc("LTCB", "LTCB", 4), new MonHoc("LTNC", "LTNC", 1), new MonHoc("NMTH", "NMTH", 4),
				new MonHoc("LTCB", "LTCB", 10), new MonHoc("NMTH", "NMTH", 3), new MonHoc("NMTH", "NMTH", 7),
				new MonHoc("NMTH", "NMTH", 6), new MonHoc("LTNC", "LTNC", 4), new MonHoc("LTNC", "LTNC", 2),
				new MonHoc("LTNC", "LTNC", 9) };
		int index = 0;
		Student students[] = { new Student("23130390", "NTV", mhs[index++], 10.0),
				new Student("23130320", "NTHH", mhs[index++], 9), new Student("23130310", "VVCD", mhs[index++], 2),
				new Student("23130340", "NMN", mhs[index++], 10.0), new Student("23130350", "LTF", mhs[index++], 10.0),
				new Student("23136690", "SSS", mhs[index++], 10.0), new Student("23130590", "QSX", mhs[index++], 2),
				new Student("23137790", "SDS", mhs[index++], 10.0), new Student("23130690", "SSD", mhs[index++], 3),
				new Student("23130370", "SSSS", mhs[index++], 10.0) };
		for (int i = 0; i < students.length; i++) {
			listStudent.add(students[i]);
		}
		for (int i = 0; i < mhs.length; i++) {
			listMonHoc.add(mhs[i]);
		}
	}

	public List<MonHoc> getListMonHoc() {
		return listMonHoc;
	}

	public List<Student> getListStudent() {
		return listStudent;
	}

	public double diemTB() {
		double save = 0;
		for (int i = 0; i < listStudent.size(); i++) {
			save += listStudent.get(i).getDiemSo();
		}
		return save / listStudent.size();
	}

	public static void main(String[] args) {
		Cau3 temp = new Cau3();
		temp.createArr();
		System.out.println(temp.diemTB());
	}
}
