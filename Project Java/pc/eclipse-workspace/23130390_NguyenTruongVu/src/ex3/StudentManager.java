package ex3;

public class StudentManager {
	private String mIdStudent, mName;
	private Student[] mStudents;

	public StudentManager(String id, String name) {
		mIdStudent = id;
		mName = name;

		mStudents = new Student[8];
		for (int i = 0; i < mStudents.length; i++) {
			mStudents[i] = new Student(mIdStudent + i, mName + i);
		}
	}

	public void showStudents() {
		for (int i = 0; i < mStudents.length; i++) {
			System.out.println(mStudents[i]
					.getmFullName() + ", dtb: " + mStudents[i]
					.getDTB()
			);
		}
	}

	public void getArrayStudent_Sort_BubbleSort() {
		int n = mStudents.length;
		boolean swapped;
		for (int i = 0; i < n - 1; i++) {
			swapped = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (mStudents[j].getDTB() > mStudents[j + 1].getDTB()) {
					Student temp = mStudents[j];
					mStudents[j] = mStudents[j + 1];
					mStudents[j + 1] = temp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}
	}

	public void getArrayStudent_Sort_InsertionSort() {
		int n = mStudents.length;
		for (int i = 1; i < n; i++) {
			Student key = mStudents[i];
			int j = i - 1;

			while (j >= 0 && mStudents[j].getDTB() > key.getDTB()) {
				mStudents[j + 1] = mStudents[j];
				j--;
			}
			mStudents[j + 1] = key;
		}
	}

	public void getArrayStudent_Sort_SelectionSort() {
		int n = mStudents.length;
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (mStudents[j].getDTB() < mStudents[minIndex].getDTB()) {
					minIndex = j;
				}
			}
			Student temp = mStudents[minIndex];
			mStudents[minIndex] = mStudents[i];
			mStudents[i] = temp;
		}
	}

	public static void main(String[] args) {
		StudentManager manager = new StudentManager("VK", "VB");
		System.out.println("RAW");
		manager.showStudents();
		System.out.println("==========================");
		System.out.println("Bubble");
		manager.getArrayStudent_Sort_BubbleSort();
		manager.showStudents();
		System.out.println("==========================");
		System.out.println("Insert");
		manager.getArrayStudent_Sort_InsertionSort();
		manager.showStudents();
		System.out.println("==========================");
		System.out.println("Select");
		manager.getArrayStudent_Sort_SelectionSort();
		manager.showStudents();
	}
}
