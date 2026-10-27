package Ex_5_4;
/**
 * trong AncestorTree co 4 thuoc tinh:
-String name
-int yearOfBirth
-AncestorTree father
-AncestorTree mother
 */
public class AncestorTree {
	private String name;//ten
	private int yearOfBirth;//nam sinh
	private AncestorTree father;//bo
	private AncestorTree mother;//me
	private int count = 1;
	//constructor co tham so
	public AncestorTree(String name, int yearOfBirth, AncestorTree father, AncestorTree mother) {

		this.name = name;
		this.yearOfBirth = yearOfBirth;
		this.father = father;
		this.mother = mother;
	}
	//constructor rong
	public AncestorTree() {
	}
	//bien dem
	public int count() {
		return ++count;
	}
	@Override
	public String toString() {
		try {
				System.out.print("\n");
		for(int i = 0; i < Count.count; ++i ) {
			System.out.print("\t");
		} int save  = Count.count; Count.count(); 
		System.out.print("|__");
		System.out.print( " Name: " + this.getName() +" year of birth: "+this.getYearOfBirth());
	
			System.out.print(father.toString());
			System.out.print(mother.toString());
				Count.count = save;
		return  "";
		} catch (Exception e) {
			return "";
		}
	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public AncestorTree getFather() {
		return father;
	}
	public void setFather(AncestorTree father) {
		this.father = father;
	}
	public AncestorTree getMother() {
		return mother;
	}
	public void setMother(AncestorTree mother) {
		this.mother = mother;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
