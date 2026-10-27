package thuc_hanh_buoi_1;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Task6 {
	final int LEN_NAME = 50;
	final String path = "C:\\Users\\pc\\Downloads\\New folder\\list.dat";

	public void addStudent(Student st) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(path, "rw");
		int numStudent = 0;
		int lenName;
		if (raf.length() > 0) {
			numStudent = raf.readInt();
			lenName = raf.readInt();
		} else {
			raf.writeInt(numStudent);
			lenName = LEN_NAME;
			raf.writeInt(lenName);
		}
		int recSize = 4 + lenName + 4 + 8;
		long lastPos = raf.getFilePointer() + (recSize * numStudent);
		raf.seek(lastPos);
		st.addStudent(raf, lenName);

		raf.seek(0);
		raf.writeInt(numStudent + 1);
		raf.close();
	}

	public Student getStudent(int index) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(path, "r");
		int numStudent = 0;
		int lenName;
		if (raf.length() > 0) {
			numStudent = raf.readInt();
			lenName = raf.readInt();
		} else {
			raf.close();
			return null;
		}
		int recSize = 4 + lenName + 4 + 8;
		if (index >= numStudent) {
			raf.close();
			return null;
		}
		long indexPos = raf.getFilePointer() + (recSize * index);
		raf.seek(indexPos);
		int id = raf.readInt();
		String name = convertCharsToStr(raf, lenName);
		int bYear = raf.readInt();
		double grade = raf.readDouble();
		return new Student(id, name, bYear, grade);
	}

	public void updateStudent(int index, Student newSt) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(path, "rw");
		int numStudent = 0;
		int lenName;
		if (raf.length() > 0) {
			numStudent = raf.readInt();
			lenName = raf.readInt();
		} else {
			raf.close();
			return;
		}
		int recSize = 4 + lenName + 4 + 8;
		if (index >= numStudent) {
			raf.close();
			return;
		}
		long posIndex = raf.getFilePointer() + (recSize* index);
		raf.seek(posIndex);
		newSt.addStudent(raf, lenName);
	}

	public Student findById(int id) throws IOException {
		RandomAccessFile raf = new RandomAccessFile(path, "r");
		if (raf.length() == 0) {
			raf.close();
			return null;
		};
		int numStudent = raf.readInt();
		int len = raf.readInt();
		int recSize = 4 + len + 4 + 8;
		long headerSize = raf.getFilePointer();

		for (int i = 0; i < numStudent; i++) {
			long pos = headerSize + (recSize * i);
			raf.seek(pos);
			int idFind = raf.readInt();
			if (idFind == id) {
				String name = convertCharsToStr(raf, len);
				int bYear = raf.readInt();
				double grade = raf.readDouble();
				return new Student(idFind, name, bYear, grade);
			}
		}
		raf.close();
		return null;
	}

	private String convertCharsToStr(RandomAccessFile raf, int lenName) throws IOException {
		String res = "";
		for (int i = 0; i < lenName / 2; i++) {
			char c = raf.readChar();
			if (c != 0)
				res += c;
		}
		return res;
	}
	public static void main(String[] args) throws IOException {
		Task6 task6 = new Task6();
//		task6.addStudent(new Student(1, "Nguyễn Trường Vũ", 3, 10));
//		task6.addStudent(new Student(2, "Nguyễn Trọng Tín", 3, 10));
//		task6.addStudent(new Student(3, "Lê Phi Hùng", 4, 10));
		System.out.println(task6.findById(3));
		System.out.println(task6.getStudent(1));

	}
}
