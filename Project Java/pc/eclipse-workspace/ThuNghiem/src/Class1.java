import java.util.Objects;

public class Class1 {
	private String text;
	private int i = 0;

	public Class1() {
		text = "hello";
	}

	public Class1(String name) {
		text = name;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public int hashCode() {

		return Objects.hash(text) + i++;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Class1 other = (Class1) obj;
		return Objects.equals(text, other.text);
	}

}
