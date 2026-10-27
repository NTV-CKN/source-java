package ex5;

public class Ex3 {
	public static class Student implements Comparable<Student> {
		private String id, fullName;
		private int birthYear;
		private double avg;

		public Student(String id, String fullName, int birthYear, double avg) {
			super();
			this.id = id;
			this.fullName = fullName;
			this.birthYear = birthYear;
			this.avg = avg;
		}

		@Override
		public int compareTo(Student o) {
			int result = fullName.compareTo(o.fullName);
			if (result == 0) {
				return id.compareTo(o.id);
			}
			return result;
		}

		@Override
		public int hashCode() {
			return hashCodeStudent();
		}

		@Override
		public String toString() {
			return "id " + id + ", full name " + fullName + ", birth year " + birthYear + ", " + avg;
		}

		private int hashCodeStudent() {
			if (fullName != null && id == null) {
				return hashCodeFullName(fullName, 0, fullName.length());
			} else if (id != null && fullName == null) {
				return hashCodeId(id, 0, id.length());
			} else if (id == null && fullName == null) {
				return (int) (birthYear + avg);
			}
			return hashCodeFullName(fullName, 0, fullName.length()) + hashCodeId(id, 0, id.length());
		}

		private int hashCodeFullName(String data, int index, int length) {
			if (length == 0 || index < 0)
				return -1;

			char ch = data.charAt(0);
			int result = (int) ch * (int) Math.pow(38, length - ++index);

			if (index == length)
				return result;
			return result + hashCodeFullName(data.substring(1), index, length);
		}

		private int hashCodeId(String data, int index, int length) {
			if (length == 0 || index < 0)
				return -1;

			char ch = data.charAt(0);
			int result = (int) ch * (int) Math.pow(38, length - ++index);

			if (index == length)
				return result;
			return result + hashCodeId(data.substring(1), index, length);
		}
	}
}
