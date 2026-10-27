package thuchanh3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Node {
	int n;
	List<Integer> state;

	public Node(int n) {
		this.n = n;
		this.state = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			Random r = new Random();
			this.state.add(r.nextInt(n));
		}
	}

	public Node(int n, List<Integer> state) {
		this.n = n;
		this.state = new ArrayList<Integer>(state);
	}

	public Node copy() {
		return new Node(this.n, new ArrayList<Integer>(this.state));
	}
}
