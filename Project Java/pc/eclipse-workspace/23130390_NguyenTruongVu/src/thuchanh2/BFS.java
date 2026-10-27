package thuchanh2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	private Queue<Node> queue;

	BFS() {
		queue = new LinkedList<Node>();
	}

	public void bfsUsingQueue(Node initial, int nQueen) {
		queue.clear();
		processBfs(initial, nQueen);
	}

	private void processBfs(Node initial, int nQueen) {
		queue.add(initial);

		while (!queue.isEmpty()) {
			Node item = queue.poll();
			
			List<Node> neightbours = item.getNeighbours();
			if (neightbours != null) {
				for (Node temp : neightbours) {
					queue.add(temp);
					//Utils.printListState(temp.state, "add node with state:");
				}
			} else {
				Utils.backtrack(item.state);
				
			}
		}
	}

}
