package thuchanh2;

import java.util.List;

public class DFS {
	public void dfsRec(Node node, int n) {

		List<Node> nodeT = node.getNeighbours();
		if (nodeT == null) {
			Utils.backtrack(node.state);
			return;
		}

		for (Node item : nodeT) {
			dfsRec(item, n);
		}
	}
}
