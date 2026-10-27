import java.util.Objects;

public class Class2 {
	private String text = "hello";

//	@Override
//	public int hashCode() {
//		return Objects.hash(text);
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Class2 other = (Class2) obj;
		return Objects.equals(text, other.text);
	}

}
