package relearn_7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Task {
	private final int LEN_BYTE_NAME = 100;
	private RandomAccessFile raf;

	public Task(String fileDat) throws FileNotFoundException {
		raf = new RandomAccessFile(fileDat, "rw");
	}

	public void addStudent(Student newSt) throws IOException {
		raf.seek(0);
		int numSt = 0;
		int lenByteName = LEN_BYTE_NAME;
		if (raf.length() == 0) {
			raf.writeInt(numSt);
			raf.writeInt(lenByteName);
		} else {
			numSt = raf.readInt();
			lenByteName = raf.readInt();
		}
		int pos = 8 + (lenByteName + 4 + 4 + 8) * numSt;
		raf.seek(pos);
		newSt.writeSt(raf, lenByteName);
		// Cap nhat lai header thi them thanh cong
		raf.seek(0);
		raf.writeInt(numSt + 1);
		raf.writeInt(lenByteName);
	}

	public Student getSt(int index) throws IOException {
		raf.seek(0);
		int numSt = 0;
		int lenByteName = LEN_BYTE_NAME;
		if (raf.length() == 0) {
			return null;
		} else {
			numSt = raf.readInt();
			lenByteName = raf.readInt();
			if (index >= numSt)
				return null;
		}
		int pos = 8 + (lenByteName + 4 + 4 + 8) * index;
		raf.seek(pos);
		int id = raf.readInt();
		String name = convertNameToStr(raf, lenByteName);
		int bYear = raf.readInt();
		double grade = raf.readDouble();

		return new Student(id, name, bYear, grade);
	}

	public Student getStById(int idT) throws IOException {
		raf.seek(0);
		int numSt = 0;
		int lenByteName = LEN_BYTE_NAME;
		if (raf.length() == 0) {
			return null;
		} else {
			numSt = raf.readInt();
			lenByteName = raf.readInt();
		}
		for (int i = 0; i < numSt; i++) {
			int pos = 8 + i * (4 + 4 + 8 + lenByteName);
			raf.seek(pos);
			int id = raf.readInt();
			if (id == idT) {
				String name = convertNameToStr(raf, lenByteName);
				int bYear = raf.readInt();
				double grade = raf.readDouble();
				return new Student(id, name, bYear, grade);
			}
		}
		return null;
	}

	public boolean removeStByIndex(int index) throws IOException {
		raf.seek(0);
		int numSt = 0;
		int lenByteName = LEN_BYTE_NAME;
		if (raf.length() == 0) {
			return false;
		} else {
			numSt = raf.readInt();
			lenByteName = raf.readInt();
			if (index >= numSt)
				return false;
		}
		int pos = 8 + (lenByteName + 4 + 4 + 8) * index;
		raf.seek(pos);
		// ghi de
		for (int i = index; i < numSt - 1; i++) {
			raf.seek(8 + (4 + 4 + 8 + lenByteName) * (i + 1));// seek next

			int id = raf.readInt();
			String name = convertNameToStr(raf, lenByteName);
			int bYear = raf.readInt();
			double grade = raf.readDouble();

			Student next = new Student(id, name, bYear, grade);

			raf.seek(8 + (4 + 4 + 8 + lenByteName) * i);// seek cur
			next.writeSt(raf, lenByteName);
		}
		raf.setLength(8 + (4 + 4 + 8 + lenByteName) * (numSt - 1));
		raf.seek(0);
		raf.writeInt(numSt - 1);

		return true;
	}

	public void updateSt(int index, Student newSt) throws IOException {
		raf.seek(0);
		int numSt = 0;
		int lenByteName = LEN_BYTE_NAME;
		if (raf.length() == 0) {
			return;
		} else {
			numSt = raf.readInt();
			lenByteName = raf.readInt();
		}
		int pos = 8 + (lenByteName + 4 + 4 + 8) * index;
		raf.seek(pos);
		newSt.writeSt(raf, lenByteName);
	}

	public void close() throws IOException {
		raf.close();
	}

	private String convertNameToStr(RandomAccessFile raf, int lenByteName) throws IOException {
		String res = "";
		for (int i = 0; i < lenByteName / 2; i++) {
			char c = 0;
			if ((c = raf.readChar()) != 0)
				res += c;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		Task t = new Task("C:\\Users\\pc\\Downloads\\sts.dat");
		boolean isAdd = false;

		if (isAdd) {
			t.addStudent(new Student(1, "Nguyen Truong Vu", 2005, 8));
			t.addStudent(new Student(2, "Lam Huu Loi", 2005, 8));
			t.addStudent(new Student(3, "Truong Cao Doan", 2005, 8));
			t.addStudent(new Student(4, "Vo Tan Linh", 2005, 8));
			t.addStudent(new Student(5, "Doan Xuan Truong", 2005, 8));
		} else {
			System.out.println(t.getSt(3));
			System.out.println(t.getStById(4));
			t.updateSt(4, new Student(12, "Vo Han", 2005, 8));
			System.out.println(t.getSt(4));
			System.out.println(t.getSt(2));
			t.removeStByIndex(2);
			System.out.println(t.getSt(2));
		}

	}
}
