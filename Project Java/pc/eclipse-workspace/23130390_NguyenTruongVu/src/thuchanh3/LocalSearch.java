package thuchanh3;

import java.util.ArrayList;
import java.util.SortedMap;
import java.util.TreeMap;

public class LocalSearch {
	public int checkHorizontal(Node node) {
		int conflicts = 0;
		for (int i = 0; i < node.state.size(); i++) {
			for (int j = i + 1; j < node.state.size(); j++) {
				if (node.state.get(i).equals(node.state.get(j))) {
					conflicts++;
				}
			}
		}
		return conflicts;
	}

	public int checkDiagonal(Node node) {
		int conflicts = 0;
		for (int i = 0; i < node.state.size(); i++) {
			for (int j = i + 1; j < node.state.size(); j++) {
				// kiem tra khi tru cot va hang cua 2 vi tri queen lieu co bang nhau khong
				// neu bang nhau nghia la dang nam tren duong cheo
				if (Math.abs(i - j) == Math.abs(node.state.get(i) - node.state.get(j))) {
					conflicts++;
				}
			}
		}
		return conflicts;
	}

	// gia tri xung dot cua 2 thang cong lai cang thap thi cang tot
	public int heuristic(Node node) {
		return checkHorizontal(node) + checkDiagonal(node);
	}

//	
//	public int tryMovingOneQueen(Node node, int x, int y) {
//		Node newNode = node.copy();
//		newNode.state.set(y, x);
//		int heuristic = heuristic(newNode);
//		return heuristic;
//	}
	public SortedMap<Integer, Node> generateNeighbours(Node node) {
		SortedMap<Integer, Node> neighbours = new TreeMap<Integer, Node>();

		for (int col = 0; col < node.n; col++) {
			for (int row = 0; row < node.n; row++) {
				// neu dong cua queen hien tai khac dong cua vong lap
				if (row != node.state.get(col)) {
					Node newNode = node.copy();
					newNode.state.set(col, row);
					int heuristic = heuristic(newNode);

					//neu chua co key la heuristic nay thi ta tao va luu value Node moi
					if (!neighbours.containsKey(heuristic)) {
						// tao 1 doi tuong Node moi chua state da thay doi voi key la heuristic
						// dam bao khi update lai oldPos se khong bi thay doi trong doi tuong Node moi
						// nay
						neighbours.put(heuristic, new Node(newNode.n, new ArrayList(newNode.state)));
					}
				}
			}
		}

		return neighbours;
	}

	public void run(int n) {
		Node initial = new Node(n); 
		if (heuristic(initial) == 0) // goal
		{
			System.out.println(initial.state);
			return;
		}
		System.out.println("Initial state is: " + initial.state);
		Node node = initial;
		SortedMap<Integer, Node> neighbours = generateNeighbours(node);

		Integer bestHeuristic = neighbours.firstKey();
		while (bestHeuristic < heuristic(node)) {
//			System.out.println("sss");
			node = neighbours.get(bestHeuristic);
			neighbours = generateNeighbours(node);
			bestHeuristic = neighbours.firstKey();
		}
		if (heuristic(node) == 0) {
			System.out.println("Goal is: " + node.state);
		} else
			System.out.println("Cannot find goal state! Best state is: " + node.state);
	}
	
	public static void main(String[] args) {
		LocalSearch ls = new LocalSearch();
		ls.run(8);
	}
}
