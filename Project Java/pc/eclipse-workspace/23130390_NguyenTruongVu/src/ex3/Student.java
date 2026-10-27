package ex3;

import java.util.Random;

public class Student {
	private String mIdStudent, mFullName, mAccademyYear;
	private float mMath, mChemistry, mPhysic;

	public Student(String id, String name) {
		this.mIdStudent = id;
		this.mFullName = name;

		Random rd = new Random();

		mAccademyYear = "" + rd.nextInt(4) + 1;
		mChemistry = rd.nextFloat(10.0f);
		mMath = rd.nextFloat(10.0f);
		mPhysic = rd.nextFloat(10.0f);
	}

	public String getmIdStudent() {
		return mIdStudent;
	}

	public String getmFullName() {
		return mFullName;
	}

	public String getmAccademyYear() {
		return mAccademyYear;
	}

	public float getmMath() {
		return mMath;
	}

	public float getmChemistry() {
		return mChemistry;
	}

	public float getmPhysic() {
		return mPhysic;
	}

	public float getDTB() {
		return (int) ((mChemistry + mMath + mPhysic) / 3 * 100) / 100.0f;
	}
}
