package ex_2;
/**
 * trong lop Author co 2 thuoc tinh:
 - int birthYear
 -String name
 */
public class Author {
	private String name;
	private int birthYear;
	//constructor1
	public Author(String name, int birthYear) {
		this.name = name;
		this.birthYear = birthYear;
	}
	//getter and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getBirthYear() {
		return birthYear;
	}
	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}
	
}
