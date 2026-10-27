package lab10;

public class ModelEx3 implements Comparable<ModelEx3> {
	private String name, sp;

	public ModelEx3(String name, String sp) {
		super();
		this.name = name;
		this.sp = sp;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return   name + ", sp" + sp+"\n";
	}

	public String getSp() {
		return sp;
	}

	@Override
	public int compareTo(ModelEx3 o) {
		if (this.getName().compareTo(o.getName()) == 0) {
			return this.getSp().compareTo(o.getSp());
		}
		return this.getName().compareTo(o.getName());
	}

}
