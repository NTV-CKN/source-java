package dictionary;

import java.util.Iterator;

public class DictionaryTwo<K, V> {
	private K key;
	private V value;

	@Override
	public String toString() {
		return "Key: " + key + ", value: " + value + "\n";
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public DictionaryTwo(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public DictionaryTwo() {

	}

	public static void main(String[] args) {
		DictionaryTwo<Integer, Character> dicASCII[] = new DictionaryTwo[95];
		
		for (int i = 0; i < dicASCII.length; i++) {
			dicASCII[i] = new DictionaryTwo<Integer, Character>(i + 32, (char) (i + 32));
		}
		for (int i = 0; i < dicASCII.length; i++) {
			System.out.print(dicASCII[i]);
		}
	}
}
