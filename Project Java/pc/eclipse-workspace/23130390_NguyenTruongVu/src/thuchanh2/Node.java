package thuchanh2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Node {
	int n;
	List<Integer> state;
	List<Node> neighbours;

	public Node(int n) {
		this.n = n;
		this.state = new ArrayList<>();
		this.neighbours = new ArrayList<>();

	}

	public Node(int n, List<Integer> state) {
		this.n = n;
		this.state = state;
		this.neighbours = new ArrayList<>();

	}

	public void addNeighbours(Node neighbourNode) {
		if (neighbourNode != null)
			this.neighbours.add(neighbourNode);
	}

	public List<Node> getNeighbours() {
		if (n == state.size())
			return null;
		
		for (int i = 0; i < n; i++) { //test place(row) for a new queen
			List<Integer> newState = place(i);
			if (newState != null) {
				addNeighbours(new Node(n, newState));
			}
		}

		return neighbours;
	}

	private List<Integer> place(int x) {
		if (isValid(state, x)) {
			List<Integer> newState = new ArrayList<Integer>();
			newState.addAll(state);
			newState.add(x);

			return newState;
		}
		return null;
	}

	private boolean isValid(List<Integer> state, int newQueen) { // newQueen: row
		int colCur = state.size(); // TODO: Check state size at place
		if (state.size() == 0)
			return true;
		for (int i = 0; i < state.size(); i++) { // i = column
			if (Math.abs(colCur - i) == Math.abs(newQueen - state.get(i)) || state.get(i) == newQueen) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hash(n, neighbours, state);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		return n == other.n && Objects.equals(neighbours, other.neighbours) && Objects.equals(state, other.state);
	}

}
