package dictionary;

public class Dictionary<T> {
	private T key, value;

	@Override
	public String toString() {
		return "key: " + key + ", value: " + value + "\n";
	}

	public Dictionary(T key, T value) {
		this.key = key;
		this.value = value;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public static void main(String[] args) {
		Dictionary<Integer> dic1 = new Dictionary<Integer>(1, 100);
		Dictionary<String> dic2 = new Dictionary<String>("How's it going?", "Moi chuyen the nao roi?");
		Dictionary<Double> dic3 = new Dictionary<Double>(12.2, 12.3);
		
		Dictionary<String>[] dicArr = new Dictionary[10];
		for (int i = 0; i < dicArr.length; i++) {
			dicArr[i] = new Dictionary<String>("" + (char) i*10, "" + (char) i *20);
		}
		
		//System.out.println(dic1 + "" + dic2 + "" + dic3);
		for (int i = 0; i < dicArr.length; i++) {
			System.out.print(dicArr[i]);
		}
	}
}
